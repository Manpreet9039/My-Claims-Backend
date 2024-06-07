package com.emp.org.service;

import java.util.List;
import java.util.Optional;

import com.emp.org.model.EmpInfoModel;

public interface EmpInfoService {
	
	List<EmpInfoModel> getAllEmpInfo();
	
	EmpInfoModel saveEmpInfo(EmpInfoModel empInfoModel);
	
	List<EmpInfoModel> getEmpInfoByEmpCode(Long empCode);

}






