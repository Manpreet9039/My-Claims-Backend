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
import com.emp.org.model.MobileModel;
import com.emp.org.model.TravelModel;
import com.emp.org.repository.ClaimsDraftRepository;
import com.emp.org.repository.MobileRepository;

import jakarta.transaction.Transactional;

@Service
public class MobileServiceImpl implements MobileService{
	
	@Autowired
	private MobileRepository mobileRepository;
	
	String uploadDir = "D:\\document";

	@Override
	public List<MobileModel> getAllMobiles() {
		// TODO Auto-generated method stub
		return mobileRepository.findAll();
	}

	@Override
	public List<MobileModel> saveMobiles(List<MobileModel> mobileModels) {
		// TODO Auto-generated method stub
		List<MobileModel> savedMobiles = new ArrayList<>();
		for(MobileModel mobileModel : mobileModels) {
			savedMobiles.add(mobileRepository.save(mobileModel));
		}
		return savedMobiles;
	}
	
	@Autowired
	private ClaimsDraftRepository claimsDraftRepository;
	

	@Override
	@Transactional
	public List<MobileModel> uploadMobile(List<MultipartFile> files, List<MobileModel> fileUploadDataList)
			throws IOException {
		// TODO Auto-generated method stub
		boolean result = claimsDraftRepository.existsByExpenseType("Mobile");
		System.out.println(result);
		
		if(!result) {
		List<MobileModel> mobileModelList = new ArrayList<>();
		for(int i=0; i< fileUploadDataList.size(); i++) {
			MultipartFile file = files.get(i);
			
			MobileModel fileUploadData = fileUploadDataList.get(i);
			if(!file.isEmpty()) {
				 byte[] bytes = file.getBytes();
	             Path path = Paths.get(uploadDir + "\\" + file.getOriginalFilename());
	             Files.write(path, bytes);
				fileUploadData.setFileName(file.getOriginalFilename());
				fileUploadData.setDate(fileUploadData.getDate());
				fileUploadData.setExpenseType(fileUploadData.getExpenseType());
				fileUploadData.setCurrency(fileUploadData.getCurrency());
				fileUploadData.setAmount(fileUploadData.getAmount());
				fileUploadData.setEmpCode(fileUploadData.getEmpCode());
				fileUploadData.setWbsId(fileUploadData.getWbsId());
				fileUploadData.setFilePath(uploadDir + file.getOriginalFilename());
				mobileModelList.add(fileUploadData);
			}
		}
		
		 return mobileRepository.saveAll(mobileModelList);
	}
		else {
			List<MobileModel> mobileModelList = new ArrayList<>();
			for(int i=0; i< fileUploadDataList.size(); i++) {
				MultipartFile file = files.get(i);
				
				MobileModel fileUploadData = fileUploadDataList.get(i);
				if(!file.isEmpty()) {
					 byte[] bytes = file.getBytes();
		             Path path = Paths.get(uploadDir + "\\" + file.getOriginalFilename());
		             Files.write(path, bytes);
					fileUploadData.setFileName(file.getOriginalFilename());
					fileUploadData.setDate(fileUploadData.getDate());
					fileUploadData.setExpenseType(fileUploadData.getExpenseType());
					fileUploadData.setCurrency(fileUploadData.getCurrency());
					fileUploadData.setAmount(fileUploadData.getAmount());
					fileUploadData.setEmpCode(fileUploadData.getEmpCode());
					fileUploadData.setWbsId(fileUploadData.getWbsId());
					fileUploadData.setFilePath(uploadDir + file.getOriginalFilename());
					mobileModelList.add(fileUploadData);
				}
			}
			 
			// Delete existing data based on both expense type and employee code
            for (MobileModel mobileModel : mobileModelList) {
                claimsDraftRepository.deleteByExpenseTypeAndEmpCodeAndWbsId(mobileModel.getExpenseType(), mobileModel.getEmpCode(), mobileModel.getWbsId());
            }
			 return mobileRepository.saveAll(mobileModelList);
		}
			
		}
	

}
