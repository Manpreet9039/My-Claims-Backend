package com.emp.org.service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.emp.org.model.TravelModel;
import com.emp.org.repository.ClaimsDraftRepository;
import com.emp.org.repository.TravelRepository;

import jakarta.transaction.Transactional;


@Service
public class TravelServiceImpl implements TravelService{
	
	@Autowired
	private TravelRepository travelRepository;
	
	String uploadDir = "D:\\document";

	@Override
	public List<TravelModel> getAllTravels() {
		// TODO Auto-generated method stub
		return travelRepository.findAll();
	}

	@Override
	public List<TravelModel> saveTravels(List<TravelModel> travelModels) {
		// TODO Auto-generated method stub
		List<TravelModel> savedTravels = new ArrayList<>();
		for(TravelModel travelModel : travelModels) {
			savedTravels.add(travelRepository.save(travelModel));
		}
		return savedTravels;
	}
	
	
	
	@Autowired
	private ClaimsDraftRepository claimsDraftRepository;
	
	@Override
	@Transactional
	public List<TravelModel> uploadTravel(List<MultipartFile> files, List<TravelModel> fileUploadDataList)
			throws IOException {
		// TODO Auto-generated method stub
		
		boolean result=claimsDraftRepository.existsByExpenseType("Travel");
		
		System.out.print(result);
		
		if(!result) {
			
		List<TravelModel> travelModelList = new ArrayList<>();
		for(int i=0; i< fileUploadDataList.size(); i++) {
			MultipartFile file = files.get(i);
			
			TravelModel fileUploadData = fileUploadDataList.get(i);
			if(!file.isEmpty()) {
				 byte[] bytes = file.getBytes();
	             Path path = Paths.get(uploadDir + "\\" + file.getOriginalFilename());
	             Files.write(path, bytes);
				fileUploadData.setFileName(file.getOriginalFilename());
				fileUploadData.setDate(fileUploadData.getDate());
			    fileUploadData.setFromLocation(fileUploadData.getFromLocation());
                fileUploadData.setToLocation(fileUploadData.getToLocation());
                fileUploadData.setExpMode(fileUploadData.getExpMode());
				fileUploadData.setExpenseType(fileUploadData.getExpenseType());
				fileUploadData.setCurrency(fileUploadData.getCurrency());
				fileUploadData.setAmount(fileUploadData.getAmount());
				fileUploadData.setEmpCode(fileUploadData.getEmpCode());
				fileUploadData.setWbsId(fileUploadData.getWbsId());
				fileUploadData.setFilePath(uploadDir + file.getOriginalFilename());
				travelModelList.add(fileUploadData);
				
				
			}
		}
		return travelRepository.saveAll(travelModelList);
		}
		else {
			List<TravelModel> travelModelList = new ArrayList<>();
			for(int i=0; i< fileUploadDataList.size(); i++) {
				MultipartFile file = files.get(i);
				
				TravelModel fileUploadData = fileUploadDataList.get(i);
				if(!file.isEmpty()) {
					 byte[] bytes = file.getBytes();
		             Path path = Paths.get(uploadDir + "\\" + file.getOriginalFilename());
		             Files.write(path, bytes);
					fileUploadData.setFileName(file.getOriginalFilename());
					fileUploadData.setDate(fileUploadData.getDate());
				    fileUploadData.setFromLocation(fileUploadData.getFromLocation());
	                fileUploadData.setToLocation(fileUploadData.getToLocation());
	                fileUploadData.setExpMode(fileUploadData.getExpMode());
					fileUploadData.setExpenseType(fileUploadData.getExpenseType());
					fileUploadData.setCurrency(fileUploadData.getCurrency());
					fileUploadData.setAmount(fileUploadData.getAmount());
					fileUploadData.setEmpCode(fileUploadData.getEmpCode());
					fileUploadData.setWbsId(fileUploadData.getWbsId());
					fileUploadData.setFilePath(uploadDir + file.getOriginalFilename());
					travelModelList.add(fileUploadData);
					
					
				}
			}
			// Delete existing data based on both expense type and employee code
            for (TravelModel travelModel : travelModelList) {
                claimsDraftRepository.deleteByExpenseTypeAndEmpCodeAndWbsId(travelModel.getExpenseType(), travelModel.getEmpCode(), travelModel.getWbsId());
            }
            return travelRepository.saveAll(travelModelList);
			
		}
		
		
		 
	}


	

}
