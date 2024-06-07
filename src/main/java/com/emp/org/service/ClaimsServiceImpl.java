//
//package com.emp.org.service;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//import com.emp.org.model.ClaimsModel;
//import com.emp.org.repository.ClaimsRepository;
//
//@Service
//public class ClaimsServiceImpl implements ClaimsService {
//
//    @Autowired
//    private ClaimsRepository claimsRepository;
//
//    String uploadDir = "D:\\document"; // Change to your desired upload directory
//
//    @Override
//    public List<ClaimsModel> getAllClaims() {
//        return claimsRepository.findAll();
//    }
//
//    @Override
//    public List<ClaimsModel> saveClaims(List<ClaimsModel> claimModels) {
//        List<ClaimsModel> savedClaims = new ArrayList<>();
//        for (ClaimsModel claimModel : claimModels) {
//            savedClaims.add(claimsRepository.save(claimModel));
//        }
//        return savedClaims;
//    }
//
//    @Override
//    public List<ClaimsModel> uploadClaim(List<MultipartFile> files, List<ClaimsModel> fileUploadDataList)
//            throws IOException {
//        List<ClaimsModel> claimModelList = new ArrayList<>();
//
//        for (int i = 0; i < fileUploadDataList.size(); i++) {
//            MultipartFile file = files.get(i);
//
//            ClaimsModel fileUploadData = fileUploadDataList.get(i);
//
//            if (!file.isEmpty()) {
//                byte[] bytes = file.getBytes();
//
//                Path path = Paths.get(uploadDir + "\\" + file.getOriginalFilename());
//                Files.write(path, bytes);
//                fileUploadData.setFileName(file.getOriginalFilename());
//                fileUploadData.setToDate(fileUploadData.getToDate());
//                fileUploadData.setFromLocation(fileUploadData.getFromLocation());
//                fileUploadData.setToLocation(fileUploadData.getToLocation());
//                fileUploadData.setToTime(fileUploadData.getToTime());
//                fileUploadData.setMode(fileUploadData.getMode());
//                fileUploadData.setKms(fileUploadData.getKms());
//                fileUploadData.setPurpose(fileUploadData.getPurpose());
//                fileUploadData.setExpenseType(fileUploadData.getExpenseType());
//                fileUploadData.setAmount(fileUploadData.getAmount());
//                fileUploadData.setCurrency(fileUploadData.getCurrency());
//                fileUploadData.setFilePath(uploadDir + file.getOriginalFilename());
//
//                claimModelList.add(fileUploadData);
//            }
//
//        }
//        return claimsRepository.saveAll(claimModelList);
//    }
//
//    @Override
//    public List<ClaimsModel> searchClaim(String expenseType) {
//        List<ClaimsModel>claims=claimsRepository.findByexpenseTypeContaining(expenseType);
//        return claims;
//
//    }
//}
//
