package com.emp.org.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.emp.org.model.ClaimsDraftModel;

public interface ClaimsDraftService {
	
	List<ClaimsDraftModel> getAllDraftClaims();

    List<ClaimsDraftModel> saveDraftClaims(List<ClaimsDraftModel> claimsDraftModels);

    List<ClaimsDraftModel> uploadDraftClaim(List<MultipartFile> files, List<ClaimsDraftModel> fileUploadDraftList)
            throws IOException;
    
    List<ClaimsDraftModel>getAllByExpTypeAndWbsIdAndEmpCode(Long empCode,String wbsId,String expenseType);
   
   

}



