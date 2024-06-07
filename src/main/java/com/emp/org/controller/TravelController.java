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

import com.emp.org.model.ConveyanceModel;
import com.emp.org.model.TravelModel;
import com.emp.org.service.ConveyanceService;
import com.emp.org.service.TravelService;

@RestController
@CrossOrigin
public class TravelController {
	
	 @Autowired
	    private TravelService travelService;
	    
	    @GetMapping("/travel")
	    public ResponseEntity<List<TravelModel>> getAllTravels() {
	        List<TravelModel> travels = travelService.getAllTravels();
	        return ResponseEntity.ok(travels);
	    }

	    @PostMapping("/uploadTravelDetails")
	    public ResponseEntity<?> uploadTravel(
	            @RequestPart("files") List<MultipartFile> files,
	            @RequestPart("data") List<TravelModel> fileUploadDataList) throws IOException {
	    	System.out.print(files+""+fileUploadDataList);
	        List<TravelModel> uploadedTravels = travelService.uploadTravel(files, fileUploadDataList);
	        if (!uploadedTravels.isEmpty()) {
	            return ResponseEntity.ok("Files and data saved successfully");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Files and data not saved");
	        }
	    }


}
