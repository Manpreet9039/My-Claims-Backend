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
import com.emp.org.model.ConveyanceModel;
import com.emp.org.model.FoodItemModel;
import com.emp.org.repository.ClaimsDraftRepository;
import com.emp.org.repository.ConveyanceRepository;

import jakarta.transaction.Transactional;

@Service
public class ConveyanceServiceImpl implements ConveyanceService{
	
	@Autowired
	private ConveyanceRepository conveyanceRepository;
	
	String uploadDir = "D:\\document";

	@Override
	public List<ConveyanceModel> getAllConveyances() {
		// TODO Auto-generated method stub
		return conveyanceRepository.findAll();
	}
	
	@Autowired
	private ClaimsDraftRepository claimsDraftRepository;

	@Override
	public List<ConveyanceModel> saveConveyances(List<ConveyanceModel> conveyanceModels) {
		// TODO Auto-generated method stub
		List<ConveyanceModel> savedConveyances = new ArrayList<>();
		for(ConveyanceModel conveyanceModel : conveyanceModels) {
			savedConveyances.add(conveyanceRepository.save(conveyanceModel));
		}
		return savedConveyances;
	}

	
	@Override
	@Transactional
	public List<ConveyanceModel> uploadConveyance(List<MultipartFile> files, List<ConveyanceModel> fileUploadDataList)
			throws IOException {
		// TODO Auto-generated method stub
		boolean result = claimsDraftRepository.existsByExpenseType("");
		System.out.println(result);
		
		if(!result) {
		List<ConveyanceModel> conveyanceModelList = new ArrayList<>();
		for(int i=0; i< fileUploadDataList.size(); i++) {
			MultipartFile file = files.get(i);
			
			ConveyanceModel fileUploadData = fileUploadDataList.get(i);
			if(!file.isEmpty()) {
				 byte[] bytes = file.getBytes();
	             Path path = Paths.get(uploadDir + "\\" + file.getOriginalFilename());
	             Files.write(path, bytes);
				fileUploadData.setFileName(file.getOriginalFilename());
				fileUploadData.setDate(fileUploadData.getDate());
			    fileUploadData.setFromLocation(fileUploadData.getFromLocation());
                fileUploadData.setToLocation(fileUploadData.getToLocation());
                fileUploadData.setFromTime(fileUploadData.getFromTime());
                fileUploadData.setToTime(fileUploadData.getToTime());
                fileUploadData.setModeOfTravel(fileUploadData.getModeOfTravel());
                fileUploadData.setDistance(fileUploadData.getDistance());
				fileUploadData.setExpenseType(fileUploadData.getExpenseType());
				fileUploadData.setCurrency(fileUploadData.getCurrency());
				fileUploadData.setAmount(fileUploadData.getAmount());
				fileUploadData.setEmpCode(fileUploadData.getEmpCode());
				fileUploadData.setWbsId(fileUploadData.getWbsId());
				fileUploadData.setFilePath(uploadDir + file.getOriginalFilename());
				conveyanceModelList.add(fileUploadData);
				
				
			}
		}
		
		 return conveyanceRepository.saveAll(conveyanceModelList);
	}
		else {
			List<ConveyanceModel> conveyanceModelList = new ArrayList<>();
			for(int i=0; i< fileUploadDataList.size(); i++) {
				MultipartFile file = files.get(i);
				
				ConveyanceModel fileUploadData = fileUploadDataList.get(i);
				if(!file.isEmpty()) {
					 byte[] bytes = file.getBytes();
		             Path path = Paths.get(uploadDir + "\\" + file.getOriginalFilename());
		             Files.write(path, bytes);
					fileUploadData.setFileName(file.getOriginalFilename());
					fileUploadData.setDate(fileUploadData.getDate());
				    fileUploadData.setFromLocation(fileUploadData.getFromLocation());
	                fileUploadData.setToLocation(fileUploadData.getToLocation());
	                fileUploadData.setFromTime(fileUploadData.getFromTime());
	                fileUploadData.setToTime(fileUploadData.getToTime());
	                fileUploadData.setModeOfTravel(fileUploadData.getModeOfTravel());
	                fileUploadData.setDistance(fileUploadData.getDistance());
					fileUploadData.setExpenseType(fileUploadData.getExpenseType());
					fileUploadData.setCurrency(fileUploadData.getCurrency());
					fileUploadData.setAmount(fileUploadData.getAmount());
					fileUploadData.setEmpCode(fileUploadData.getEmpCode());
					fileUploadData.setWbsId(fileUploadData.getWbsId());
					fileUploadData.setFilePath(uploadDir + file.getOriginalFilename());
					conveyanceModelList.add(fileUploadData);
					
					
				}
			}
			
			// Delete existing data based on both expense type and employee code
	        for (ConveyanceModel conveyanceModel : conveyanceModelList) {
	            claimsDraftRepository.deleteByExpenseTypeAndEmpCodeAndWbsId(conveyanceModel.getExpenseType(), conveyanceModel.getEmpCode(), conveyanceModel.getWbsId());
	        }
			 return conveyanceRepository.saveAll(conveyanceModelList);
		
		}
			
		}
	
	
//	@Override
//	public List<ConveyanceModel> searchClaim(String expenseType) {
//		// TODO Auto-generated method stub
//		List<ConveyanceModel>claims = conveyanceRepository.findByExpenseTypeContaining(expenseType);
//		return claims;
//	}

}
