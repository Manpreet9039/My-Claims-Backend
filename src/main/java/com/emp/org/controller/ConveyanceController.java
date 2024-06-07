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
import com.emp.org.service.ConveyanceService;


@RestController
@CrossOrigin
public class ConveyanceController {
	
	 @Autowired
	    private ConveyanceService conveyanceService;
	    
	    @GetMapping("/conveyance")
	    public ResponseEntity<List<ConveyanceModel>> getAllConveyances() {
	        List<ConveyanceModel> conveyances = conveyanceService.getAllConveyances();
	        return ResponseEntity.ok(conveyances);
	    }

	    @PostMapping("/uploadConveyance")
	    public ResponseEntity<?> uploadConveyance(
	            @RequestPart("files") List<MultipartFile> files,
	            @RequestPart("data") List<ConveyanceModel> fileUploadDataList) throws IOException {
	        List<ConveyanceModel> uploadedConveyances = conveyanceService.uploadConveyance(files, fileUploadDataList);
	        if (!uploadedConveyances.isEmpty()) {
	            return ResponseEntity.ok("Files and data saved successfully");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Files and data not saved");
	        }
	    }


//	    @GetMapping("/search-expenseType/{expenseType}")
//	    public ResponseEntity<?> searchClaims(@PathVariable String expenseType){
//	        List<FoodItemModel>claims=foodItemService.searchClaim(expenseType);
//	        if(!claims.isEmpty()){
//	            return ResponseEntity.ok(claims);
//	        }
//	        else{
//	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("data based on search not found");
//	        }
//	    }

}
