package com.emp.org.service;
import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.emp.org.model.FoodItemModel;

public interface FoodItemService {
	
	List<FoodItemModel> getAllFoodItems();

	List<FoodItemModel> uploadFoodItem(List<MultipartFile> files, List<FoodItemModel> fileUploadDataList)
	        throws IOException;


}



