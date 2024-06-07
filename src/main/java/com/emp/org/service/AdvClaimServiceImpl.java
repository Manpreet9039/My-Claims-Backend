//
//package com.emp.org.service;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.emp.org.model.ClaimsModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.emp.org.model.AdvClaimModel;
//import com.emp.org.repository.AdvClaimRepository;
//
//@Service
//public class AdvClaimServiceImpl implements AdvClaimService {
//
//    @Autowired
//    private AdvClaimRepository advClaimRepository;
//
//    String uploadDir = "D:\\document"; // Change to your desired upload directory
//
//    @Override
//    public List<AdvClaimModel> getAllClaims() {
//        return advClaimRepository.findAll();
//    }
//
//    @Override
//    public List<AdvClaimModel> saveAdvClaims(List<AdvClaimModel> advClaimModels) {
//        List<AdvClaimModel> savedClaims = new ArrayList<>();
//        for (AdvClaimModel advClaimModel : advClaimModels) {
//            savedClaims.add(advClaimRepository.save(advClaimModel));
//        }
//        return savedClaims;
//    }
//
//    @Override
//    public List<AdvClaimModel> uploadAdvClaim(List<MultipartFile> files, List<AdvClaimModel> fileUploadDataList)
//            throws IOException {
//        List<AdvClaimModel> advClaimModelList = new ArrayList<>();
//
//        for (int i = 0; i < fileUploadDataList.size(); i++) {
//            MultipartFile file = files.get(i);
//
//            AdvClaimModel fileUploadData = fileUploadDataList.get(i);
//
//            if (!file.isEmpty()) {
//                byte[] bytes = file.getBytes();
//
//                Path path = Paths.get(uploadDir + "\\" + file.getOriginalFilename());
//                Files.write(path, bytes);
//                fileUploadData.setFileName(file.getOriginalFilename());
//                fileUploadData.setToDate(fileUploadData.getToDate());
//                fileUploadData.setPurpose(fileUploadData.getPurpose());
//                fileUploadData.setExpenseType(fileUploadData.getExpenseType());
//                fileUploadData.setAmount(fileUploadData.getAmount());
//                fileUploadData.setCurrency(fileUploadData.getCurrency());
//                fileUploadData.setFilePath(uploadDir + file.getOriginalFilename());
//
//                advClaimModelList.add(fileUploadData);
//            }
//
//        }
//        return advClaimRepository.saveAll(advClaimModelList);
//    }
//
//    @Override
//    public List<AdvClaimModel> searchClaim(String expenseType) {
//        List<AdvClaimModel>claims=advClaimRepository.findByexpenseTypeContaining(expenseType);
//        return claims;
//
//    }
//}
