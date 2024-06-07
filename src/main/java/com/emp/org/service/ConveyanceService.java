package com.emp.org.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.emp.org.model.ConveyanceModel;

public interface ConveyanceService {
	
	List<ConveyanceModel> getAllConveyances();

	List<ConveyanceModel> saveConveyances(List<ConveyanceModel> conveyanceModels);

	List<ConveyanceModel> uploadConveyance(List<MultipartFile> files, List<ConveyanceModel> fileUploadDataList)
	        throws IOException;

//	List<FoodItemModel> searchClaim(String expenseType);

}
