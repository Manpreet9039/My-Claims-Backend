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
import com.emp.org.model.MobileModel;
import com.emp.org.service.MobileService;

@RestController
@CrossOrigin
public class MobileController {
	
	 @Autowired
	    private MobileService mobileService;
	    
	    @GetMapping("/mobile")
	    public ResponseEntity<List<MobileModel>> getAllMobiles() {
	        List<MobileModel> mobiles = mobileService.getAllMobiles();
	        return ResponseEntity.ok(mobiles);
	    }

	    @PostMapping("/uploadMobileExpense")
	    public ResponseEntity<?> uploadMobile(
	            @RequestPart("files") List<MultipartFile> files,
	            @RequestPart("data") List<MobileModel> fileUploadDataList) throws IOException {
	        List<MobileModel> uploadedMobiles = mobileService.uploadMobile(files, fileUploadDataList);
	        if (!uploadedMobiles.isEmpty()) {
	            return ResponseEntity.ok("Files and data saved successfully");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Files and data not saved");
	        }
	    }


}
