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
import com.emp.org.model.MiscellaneousModel;
import com.emp.org.model.MobileModel;
import com.emp.org.repository.ClaimsDraftRepository;
import com.emp.org.repository.MiscellaneousRepository;

import jakarta.transaction.Transactional;


@Service
public class MiscellaneousServiceImpl implements MiscellaneousService{
	
	@Autowired
	private  MiscellaneousRepository  miscellaneousRepository;
	
	String uploadDir = "D:\\document";

	@Override
	public List< MiscellaneousModel> getAllMiscellaneous() {
		// TODO Auto-generated method stub
		return  miscellaneousRepository.findAll();
	}

	@Override
	public List<MiscellaneousModel> saveMiscellaneous(List< MiscellaneousModel>  miscellaneousModels) {
		// TODO Auto-generated method stub
		List<MiscellaneousModel> savedMiscellaneous = new ArrayList<>();
		for(MiscellaneousModel miscellaneousModel : miscellaneousModels) {
			savedMiscellaneous.add(miscellaneousRepository.save(miscellaneousModel));
		}
		return savedMiscellaneous;
	}
	
	@Autowired
	private ClaimsDraftRepository claimsDraftRepository;
	
	

	@Override
	@Transactional
	public List<MiscellaneousModel> uploadMiscellaneous(List<MultipartFile> files, List<MiscellaneousModel> fileUploadDataList)
			throws IOException {
		// TODO Auto-generated method stub
		boolean result = claimsDraftRepository.existsByExpenseType("Miscellaneous");
		System.out.println(result);
		
		if(!result) {
		List<MiscellaneousModel> miscellaneousModelList = new ArrayList<>();
		for(int i=0; i< fileUploadDataList.size(); i++) {
			MultipartFile file = files.get(i);
			
			MiscellaneousModel fileUploadData = fileUploadDataList.get(i);
			if(!file.isEmpty()) {
				 byte[] bytes = file.getBytes();
	             Path path = Paths.get(uploadDir + "\\" + file.getOriginalFilename());
	             Files.write(path, bytes);
				fileUploadData.setFileName(file.getOriginalFilename());
				fileUploadData.setDate(fileUploadData.getDate());
				fileUploadData.setExpMode(fileUploadData.getExpMode());
				fileUploadData.setExpenseType(fileUploadData.getExpenseType());
				fileUploadData.setCurrency(fileUploadData.getCurrency());
				fileUploadData.setAmount(fileUploadData.getAmount());
				fileUploadData.setEmpCode(fileUploadData.getEmpCode());
				fileUploadData.setWbsId(fileUploadData.getWbsId());
				fileUploadData.setFilePath(uploadDir + file.getOriginalFilename());
				miscellaneousModelList.add(fileUploadData);
			}
		}
		
		 return miscellaneousRepository.saveAll(miscellaneousModelList);
	}
		else {
			List<MiscellaneousModel> miscellaneousModelList = new ArrayList<>();
			for(int i=0; i< fileUploadDataList.size(); i++) {
				MultipartFile file = files.get(i);
				
				MiscellaneousModel fileUploadData = fileUploadDataList.get(i);
				if(!file.isEmpty()) {
					 byte[] bytes = file.getBytes();
		             Path path = Paths.get(uploadDir + "\\" + file.getOriginalFilename());
		             Files.write(path, bytes);
					fileUploadData.setFileName(file.getOriginalFilename());
					fileUploadData.setDate(fileUploadData.getDate());
					fileUploadData.setExpMode(fileUploadData.getExpMode());
					fileUploadData.setExpenseType(fileUploadData.getExpenseType());
					fileUploadData.setCurrency(fileUploadData.getCurrency());
					fileUploadData.setAmount(fileUploadData.getAmount());
					fileUploadData.setEmpCode(fileUploadData.getEmpCode());
					fileUploadData.setWbsId(fileUploadData.getWbsId());
					fileUploadData.setFilePath(uploadDir + file.getOriginalFilename());
					miscellaneousModelList.add(fileUploadData);
				}
			}
			
			// Delete existing data based on both expense type and employee code
            for (MiscellaneousModel miscellaneousModel : miscellaneousModelList) {
                claimsDraftRepository.deleteByExpenseTypeAndEmpCodeAndWbsId(miscellaneousModel.getExpenseType(), miscellaneousModel.getEmpCode(), miscellaneousModel.getWbsId());
            }
			 return miscellaneousRepository.saveAll(miscellaneousModelList);
		
			
		}
			
		}
	
}
