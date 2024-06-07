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
import com.emp.org.model.FoodItemModel;
import com.emp.org.model.MiscellaneousModel;
import com.emp.org.model.TravelModel;
import com.emp.org.repository.ClaimsDraftRepository;
import com.emp.org.repository.FoodItemRepository;

import jakarta.transaction.Transactional;





@Service
public class FoodItemServiceImpl implements FoodItemService{
	
	@Autowired
	private FoodItemRepository foodItemRepository;
	
	String uploadDir = "D:\\document";

	@Override
	public List<FoodItemModel> getAllFoodItems() {
		// TODO Auto-generated method stub
		return foodItemRepository.findAll();
	}

//	@Override
//	public List<FoodItemModel> saveFoodItems(List<FoodItemModel> foodItemModels) {
//		// TODO Auto-generated method stub
//		List<FoodItemModel> savedFoodItems = new ArrayList<>();
//		for(FoodItemModel foodItemModel : foodItemModels) {
//			savedFoodItems.add(foodItemRepository.save(foodItemModel));
//		}
//		return savedFoodItems;
//	}

	
	
	
	@Autowired
	private ClaimsDraftRepository claimsDraftRepository;
	
	@Override
	@Transactional
	public List<FoodItemModel> uploadFoodItem(List<MultipartFile> files, List<FoodItemModel> fileUploadDataList)
			throws IOException {
		// TODO Auto-generated method stub
		
		boolean result=claimsDraftRepository.existsByExpenseType("Food");
		System.out.print(result);
		
		if(!result) {
			
			List<FoodItemModel> foodItemModelList = new ArrayList<>();
			for(int i=0; i< fileUploadDataList.size(); i++) {
				MultipartFile file = files.get(i);
				
				FoodItemModel fileUploadData = fileUploadDataList.get(i);
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
					foodItemModelList.add(fileUploadData);
				}
			}
			
			 return foodItemRepository.saveAll(foodItemModelList);
		}
			
		
		
		else {
			
		
		
		List<FoodItemModel> foodItemModelList = new ArrayList<>();
		for(int i=0; i< fileUploadDataList.size(); i++) {
			MultipartFile file = files.get(i);
			
			FoodItemModel fileUploadData = fileUploadDataList.get(i);
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
				foodItemModelList.add(fileUploadData);
			}
		}
		
		// Delete existing data based on both expense type and employee code
        for (FoodItemModel foodItemModel : foodItemModelList) {
            claimsDraftRepository.deleteByExpenseTypeAndEmpCodeAndWbsId(foodItemModel.getExpenseType(), foodItemModel.getEmpCode(), foodItemModel.getWbsId());
        }
		 return foodItemRepository.saveAll(foodItemModelList);
		
		
		 
	}
		
	}
}


	
	
	
	
	
	
//	@Override
//	public List<FoodItemModel> uploadFoodItem(List<MultipartFile> files, List<FoodItemModel> fileUploadDataList)
//			throws IOException {
//		// TODO Auto-generated method stub
//		List<FoodItemModel> foodItemModelList = new ArrayList<>();
//		for(int i=0; i< fileUploadDataList.size(); i++) {
//			MultipartFile file = files.get(i);
//			
//			FoodItemModel fileUploadData = fileUploadDataList.get(i);
//			if(!file.isEmpty()) {
//				 byte[] bytes = file.getBytes();
//	             Path path = Paths.get(uploadDir + "\\" + file.getOriginalFilename());
//	             Files.write(path, bytes);
//				fileUploadData.setFileName(file.getOriginalFilename());
//				fileUploadData.setDate(fileUploadData.getDate());
//				fileUploadData.setExpenseType(fileUploadData.getExpenseType());
//				fileUploadData.setCurrency(fileUploadData.getCurrency());
//				fileUploadData.setAmount(fileUploadData.getAmount());
//				fileUploadData.setFilePath(uploadDir + file.getOriginalFilename());
//				foodItemModelList.add(fileUploadData);
//			}
//		}
//		
//		 return foodItemRepository.saveAll(foodItemModelList);
//	}
//	
	
//	@Override
//	public List<FoodItemModel> searchClaim(String expenseType) {
//		// TODO Auto-generated method stub
//		List<FoodItemModel>claims = foodItemRepository.findByExpenseTypeContaining(expenseType);
//		return claims;
//	}

//}

