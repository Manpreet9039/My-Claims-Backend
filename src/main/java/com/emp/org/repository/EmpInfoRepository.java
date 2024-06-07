package com.emp.org.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.org.model.EmpInfoModel;

public interface EmpInfoRepository extends JpaRepository<EmpInfoModel,Long> {
	
	boolean getByEmpCode(Long empCode);
	
	 List<EmpInfoModel> findByEmpCode(Long empCode);

}
