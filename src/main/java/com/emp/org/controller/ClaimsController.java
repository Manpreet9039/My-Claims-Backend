//
//package com.emp.org.controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import com.emp.org.model.AdvClaimModel;
//import com.emp.org.model.ClaimsModel;
//import com.emp.org.service.AdvClaimService;
//import com.emp.org.service.ClaimsService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@RestController
//@CrossOrigin
//public class ClaimsController {
//
//    @Autowired
//    private ClaimsService claimsService;
//    
//    @GetMapping("/claims")
//    public ResponseEntity<List<ClaimsModel>> getAllClaims() {
//        List<ClaimsModel> claims = claimsService.getAllClaims();
//        return ResponseEntity.ok(claims);
//    }
//
//    @PostMapping("/uploadClaim")
//    public ResponseEntity<?> uploadClaim(
//            @RequestPart("files") List<MultipartFile> files,
//            @RequestPart("data") List<ClaimsModel> fileUploadDataList) throws IOException {
//        List<ClaimsModel> uploadedClaims = claimsService.uploadClaim(files, fileUploadDataList);
//        if (!uploadedClaims.isEmpty()) {
//            return ResponseEntity.ok("Files and data saved successfully");
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Files and data not saved");
//        }
//    }
//
//
//    @GetMapping("/search-expenseType/{expenseType}")
//    public ResponseEntity<?> searchClaims(@PathVariable String expenseType){
//        List<ClaimsModel>claims=claimsService.searchClaim(expenseType);
//        if(!claims.isEmpty()){
//            return ResponseEntity.ok(claims);
//        }
//        else{
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("data based on search not found");
//        }
//    }
//
//}
//
//
//
//
