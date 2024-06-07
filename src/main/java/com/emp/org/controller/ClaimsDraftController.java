package com.emp.org.controller;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.emp.org.model.ClaimsDraftModel;
import com.emp.org.service.ClaimsDraftService;


@RestController
@CrossOrigin
public class ClaimsDraftController {
	
	 @Autowired
	    private ClaimsDraftService claimsDraftService;
	    
	    @GetMapping("/draft-of-claims")
	    public ResponseEntity<List<ClaimsDraftModel>> getAllDraftClaims() {
	        List<ClaimsDraftModel> drafts = claimsDraftService.getAllDraftClaims();
	        return ResponseEntity.ok(drafts);
	    }


	    @GetMapping("/getByExpTypeAndWbsIdAndEmpCode/{empCode}/{wbsId}/{expenseType}")
	    public ResponseEntity<List<ClaimsDraftModel>> getAllByEmpCodeAndWbsId(@PathVariable Long empCode,@PathVariable String wbsId,@PathVariable String expenseType) {
	    	System.out.println(expenseType+"expenseType"+wbsId+"wbsId"+empCode+"empCode");
	        List<ClaimsDraftModel> drafts = claimsDraftService.getAllByExpTypeAndWbsIdAndEmpCode(empCode,wbsId, expenseType);
	        return ResponseEntity.ok(drafts);
	    }

	    
	    @PostMapping("/uploadClaimsDrafts")
	    public ResponseEntity<?> uploadDraftClaim(
	            @RequestPart("files") List<MultipartFile> files,
	            @RequestPart("data") List<ClaimsDraftModel> fileUploadDraftList) throws IOException {
	    	System.out.print(files+"..."+fileUploadDraftList);
	        List<ClaimsDraftModel> uploadedDrafts = claimsDraftService.uploadDraftClaim(files, fileUploadDraftList);
	        if (!uploadedDrafts.isEmpty()) {
	            return ResponseEntity.ok("Files and data saved successfully");
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Files and data not saved");
	        }
	    }
}

	    
	    
