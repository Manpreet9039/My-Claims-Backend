
package com.emp.org.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.emp.org.model.ClaimsDraftModel;
import com.emp.org.model.ConveyanceModel;
import com.emp.org.model.FoodItemModel;
import com.emp.org.model.MiscellaneousModel;
import com.emp.org.model.MobileModel;
import com.emp.org.model.TravelModel;
import com.emp.org.repository.ClaimsDraftRepository;
import com.emp.org.repository.ConveyanceRepository;
import com.emp.org.repository.EmpInfoRepository;
import com.emp.org.repository.FoodItemRepository;
import com.emp.org.repository.MiscellaneousRepository;
import com.emp.org.repository.MobileRepository;
import com.emp.org.repository.TravelRepository;

import jakarta.transaction.Transactional;

@Service
public class ClaimsDraftServiceImpl implements ClaimsDraftService {
	
	@Autowired
    private ClaimsDraftRepository claimsDraftRepository;
	
	@Autowired
    private EmpInfoRepository empInfoRepository;


    
    String uploadDir = "D:\\document"; // Change to your desired upload directory

    @Override
    public List<ClaimsDraftModel> getAllDraftClaims() {
        return claimsDraftRepository.findAll();
    }
    


    @Override
    public List<ClaimsDraftModel> saveDraftClaims(List<ClaimsDraftModel> claimsDraftModels) {
        List<ClaimsDraftModel> savedClaims = new ArrayList<>();
        for (ClaimsDraftModel claimDraftModel : claimsDraftModels) {
            savedClaims.add(claimsDraftRepository.save(claimDraftModel));
        }
        return savedClaims;
    }
    


 
    @Override
    public List<ClaimsDraftModel> uploadDraftClaim(List<MultipartFile> files, List<ClaimsDraftModel> fileUploadDraftList)
            throws IOException {
        List<ClaimsDraftModel> draftModelList = new ArrayList<>();

        for (int i = 0; i < fileUploadDraftList.size(); i++) {
            MultipartFile file = files.get(i);

            ClaimsDraftModel fileUploadDraft = fileUploadDraftList.get(i);

            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();

                Path path = Paths.get(uploadDir + "\\" + file.getOriginalFilename());
                Files.write(path, bytes);
                fileUploadDraft.setFileName(file.getOriginalFilename());
                fileUploadDraft.setDate(fileUploadDraft.getDate());
                fileUploadDraft.setFromLocation(fileUploadDraft.getFromLocation());
                fileUploadDraft.setToLocation(fileUploadDraft.getToLocation());
                fileUploadDraft.setFromTime(fileUploadDraft.getFromTime());
                fileUploadDraft.setToTime(fileUploadDraft.getToTime());
                fileUploadDraft.setExpMode(fileUploadDraft.getExpMode());
                fileUploadDraft.setDistance(fileUploadDraft.getDistance());
                fileUploadDraft.setPurpose(fileUploadDraft.getPurpose());
                fileUploadDraft.setExpenseType(fileUploadDraft.getExpenseType());
                fileUploadDraft.setAmount(fileUploadDraft.getAmount());
                fileUploadDraft.setCurrency(fileUploadDraft.getCurrency());
                fileUploadDraft.setEmpCode(fileUploadDraft.getEmpCode());
                fileUploadDraft.setWbsId(fileUploadDraft.getWbsId());
                fileUploadDraft.setFilePath(uploadDir + file.getOriginalFilename());



                draftModelList.add(fileUploadDraft);
            }
        }

        return claimsDraftRepository.saveAll(draftModelList);






    }

@Override
@Transactional
public List<ClaimsDraftModel> getAllByExpTypeAndWbsIdAndEmpCode(Long empCode, String wbsId,String expenseType) {
	System.out.println(expenseType+"expenseTypeim"+wbsId+"wbsIdim"+empCode+"empCodeim");
	return claimsDraftRepository.findByEmpCodeAndWbsIdAndExpenseType(empCode,wbsId, expenseType);
}


	
}


   
    

















