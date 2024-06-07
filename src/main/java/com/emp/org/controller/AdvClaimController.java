//package com.emp.org.controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import com.emp.org.model.ClaimsModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import com.emp.org.model.AdvClaimModel;
//import com.emp.org.service.AdvClaimService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@RestController
//@CrossOrigin
//public class AdvClaimController {
//
//    @Autowired
//    private AdvClaimService advClaimService;
//    
//    @GetMapping("/advClaims")
//    public ResponseEntity<List<AdvClaimModel>> getAllAdvClaims() {
//        List<AdvClaimModel> advClaims = advClaimService.getAllClaims();
//        return ResponseEntity.ok(advClaims);
//    }
//
//    @PostMapping("/uploadAdvClaim")
//    public ResponseEntity<?> uploadAdvClaim(
//            @RequestPart("files") List<MultipartFile> files,
//            @RequestPart("data") List<AdvClaimModel> fileUploadDataList) throws IOException {
//        List<AdvClaimModel> uploadedAdvClaims = advClaimService.uploadAdvClaim(files, fileUploadDataList);
//        if (!uploadedAdvClaims.isEmpty()) {
//            return ResponseEntity.ok("Files and data saved successfully");
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Files and data not saved");
//        }
//    }
//
//    @GetMapping("/search-advanceType/{expenseType}")
//    public ResponseEntity<?> searchClaims(@PathVariable String expenseType){
//        List<AdvClaimModel>claims=advClaimService.searchClaim(expenseType);
//        if(!claims.isEmpty()){
//            return ResponseEntity.ok(claims);
//        }
//        else{
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("data based on search not found");
//        }
//    }
//}
//
//
//
