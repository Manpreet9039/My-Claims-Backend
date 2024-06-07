package com.emp.org.controller;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.emp.org.model.FoodItemModel;
import com.emp.org.service.FoodItemService;


@RestController
@CrossOrigin
public class FoodItemController {
	
	 @Autowired
	    private FoodItemService foodItemService;
	    
	    @GetMapping("/food_items")
	    public ResponseEntity<List<FoodItemModel>> getAllFoodItems() {
	        List<FoodItemModel> foods = foodItemService.getAllFoodItems();
	        return ResponseEntity.ok(foods);
	    }

	    @PostMapping("/uploadFoodExpense")
	    public ResponseEntity<?> uploadFoodItem(
	            @RequestPart("files") List<MultipartFile> files,
	            @RequestPart("data") List<FoodItemModel> fileUploadDataList) throws IOException {
	        List<FoodItemModel> uploadedFoodItems = foodItemService.uploadFoodItem(files, fileUploadDataList);
	        if (!uploadedFoodItems.isEmpty()) {
	            return ResponseEntity.ok("Files and data saved successfully");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Files and data not saved");
	        }
	    }




}







