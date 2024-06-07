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
import com.emp.org.model.MiscellaneousModel;
import com.emp.org.service.MiscellaneousService;



@RestController
@CrossOrigin
public class MiscellaneousController {
	
	 @Autowired
	    private MiscellaneousService miscellaneousService;
	    
	    @GetMapping("/miscellaneous")
	    public ResponseEntity<List<MiscellaneousModel>> getAllMiscellaneous() {
	        List<MiscellaneousModel> miscellaneous = miscellaneousService.getAllMiscellaneous();
	        return ResponseEntity.ok(miscellaneous);
	    }

	    @PostMapping("/uploadMiscellaneous")
	    public ResponseEntity<?> uploadMiscellaneous(
	            @RequestPart("files") List<MultipartFile> files,
	            @RequestPart("data") List<MiscellaneousModel> fileUploadDataList) throws IOException {
	        List<MiscellaneousModel> uploadedMiscellaneous = miscellaneousService.uploadMiscellaneous(files, fileUploadDataList);
	        if (!uploadedMiscellaneous.isEmpty()) {
	            return ResponseEntity.ok("Files and data saved successfully");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Files and data not saved");
	        }
	    }

}
