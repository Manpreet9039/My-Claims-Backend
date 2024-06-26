//
//
//package com.emp.org.service;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import com.emp.org.model.AdvClaimModel;
//import com.emp.org.model.ClaimsModel;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.emp.org.model.DraftModel;
//import com.emp.org.repository.AdvClaimRepository;
//import com.emp.org.repository.ClaimsRepository;
//import com.emp.org.repository.DraftRepository;
//
//@Service
//public class DraftServiceImpl implements DraftService {
//
//    @Autowired
//    private DraftRepository draftRepository;
//
//    @Autowired
//    private AdvClaimRepository advClaimRepository;
//
//
//    @Autowired
//    private ClaimsRepository claimsRepository;
//
//    String uploadDir = "D:\\document"; // Change to your desired upload directory
//
//    @Override
//    public List<DraftModel> getAllDraftClaims() {
//        return draftRepository.findAll();
//    }
//
//    @Override
//    public List<DraftModel> saveDraftClaims(List<DraftModel> draftModels) {
//        List<DraftModel> savedClaims = new ArrayList<>();
//        for (DraftModel draftModel : draftModels) {
//            savedClaims.add(draftRepository.save(draftModel));
//        }
//        return savedClaims;
//    }
//
//    @Override
//    public List<DraftModel> uploadDraftClaim(List<MultipartFile> files, List<DraftModel> fileUploadDraftList)
//            throws IOException {
//        List<DraftModel> draftModelList = new ArrayList<>();
//
//        for (int i = 0; i < fileUploadDraftList.size(); i++) {
//            MultipartFile file = files.get(i);
//
//            DraftModel fileUploadDraft = fileUploadDraftList.get(i);
//
//            if (!file.isEmpty()) {
//                byte[] bytes = file.getBytes();
//
//                Path path = Paths.get(uploadDir + "\\" + file.getOriginalFilename());
//                Files.write(path, bytes);
//                fileUploadDraft.setFileName(file.getOriginalFilename());
//                fileUploadDraft.setToDate(fileUploadDraft.getToDate());
//                fileUploadDraft.setFromLocation(fileUploadDraft.getFromLocation());
//                fileUploadDraft.setToLocation(fileUploadDraft.getToLocation());
//                fileUploadDraft.setToTime(fileUploadDraft.getToTime());
//                fileUploadDraft.setMode(fileUploadDraft.getMode());
//                fileUploadDraft.setKms(fileUploadDraft.getKms());
//                fileUploadDraft.setPurpose(fileUploadDraft.getPurpose());
//                fileUploadDraft.setExpenseType(fileUploadDraft.getExpenseType());
//                fileUploadDraft.setAmount(fileUploadDraft.getAmount());
//                fileUploadDraft.setCurrency(fileUploadDraft.getCurrency());
//                fileUploadDraft.setFilePath(uploadDir + file.getOriginalFilename());
//
//
//
//                draftModelList.add(fileUploadDraft);
//            }
//        }
//
//        return draftRepository.saveAll(draftModelList);
//
//
//
//
//
//
//    }
//
//
//    @Override
//    @Transactional
//    public List<?> submitDraftClaim(List<MultipartFile> files, List<DraftModel> fileUploadDraftList) throws IOException {
//        List<AdvClaimModel> advClaimModelList = new ArrayList<>();
//        List<ClaimsModel> claimsModelList = new ArrayList<>();
//        boolean hasRtaIou=false;
//        String expType="";
//
//        for (int i = 0; i < fileUploadDraftList.size(); i++) {
//            MultipartFile file = files.get(i);
//            DraftModel fileUploadDraft = fileUploadDraftList.get(i);
//
//            if (fileUploadDraft.getExpenseType().equals("IOU") || fileUploadDraft.getExpenseType().equals("RTA")) {
//                hasRtaIou = true;
//                if (!file.isEmpty()) {
//                    byte[] bytes = file.getBytes();
//
//                    Path path = Paths.get(uploadDir + "\\" + file.getOriginalFilename());
//                    Files.write(path, bytes);
//
//                    AdvClaimModel advClaimModel = new AdvClaimModel();
//                    advClaimModel.setFileName(file.getOriginalFilename());
//                    advClaimModel.setToDate(fileUploadDraft.getToDate());
//                    advClaimModel.setPurpose(fileUploadDraft.getPurpose());
//                    advClaimModel.setExpenseType(fileUploadDraft.getExpenseType());
//                    advClaimModel.setAmount(fileUploadDraft.getAmount());
//                    advClaimModel.setCurrency(fileUploadDraft.getCurrency());
//                    advClaimModel.setFilePath(uploadDir + file.getOriginalFilename());
//                    expType=fileUploadDraft.getExpenseType();
//
//
//
//
//
//                    advClaimModelList.add(advClaimModel);
//                }
//            } else {
//                hasRtaIou = false;
//                if (!file.isEmpty()) {
//                    byte[] bytes = file.getBytes();
//
//                    Path path = Paths.get(uploadDir + "\\" + file.getOriginalFilename());
//                    Files.write(path, bytes);
//
//                    ClaimsModel claimsModel = new ClaimsModel();
//                    claimsModel.setFileName(file.getOriginalFilename());
//                    claimsModel.setToDate(fileUploadDraft.getToDate());
//                    claimsModel.setFromLocation(fileUploadDraft.getFromLocation());
//                    claimsModel.setToLocation(fileUploadDraft.getToLocation());
//                    claimsModel.setToTime(fileUploadDraft.getToTime());
//                    claimsModel.setMode(fileUploadDraft.getMode());
//                    claimsModel.setKms(fileUploadDraft.getKms());
//                    claimsModel.setPurpose(fileUploadDraft.getPurpose());
//                    claimsModel.setExpenseType(fileUploadDraft.getExpenseType());
//                    claimsModel.setAmount(fileUploadDraft.getAmount());
//                    claimsModel.setCurrency(fileUploadDraft.getCurrency());
//                    claimsModel.setFromDate(fileUploadDraft.getFromDate());
//                    claimsModel.setFromTime(fileUploadDraft.getFromTime());
//                    claimsModel.setStatus(fileUploadDraft.getStatus());
//                    claimsModel.setWbsId(fileUploadDraft.getWbsId());
//
//                    claimsModel.setFilePath(uploadDir + file.getOriginalFilename());
//                    expType=fileUploadDraft.getExpenseType();
//
//
//
//                    claimsModelList.add(claimsModel);
//                }
//            }
//        }
//
//        if(hasRtaIou) {
//            draftRepository.deleteByExpenseType(expType);
//            return advClaimRepository.saveAll(advClaimModelList);
//        } else {
//            draftRepository.deleteByExpenseType(expType);
//            return  claimsRepository.saveAll(claimsModelList);
//        }
//    }
//
//    @Override
//    public List<DraftModel> getAllByExpType(String expType) {
//        return draftRepository.findByExpenseType(expType);
//    }
//    
//    
//  
//
//
//}
//
//
//
