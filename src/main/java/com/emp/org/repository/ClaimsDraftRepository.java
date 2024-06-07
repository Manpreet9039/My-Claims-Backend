package com.emp.org.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.org.model.ClaimsDraftModel;


public interface ClaimsDraftRepository extends JpaRepository<ClaimsDraftModel,Long> {

	
	 

	 
	 boolean existsByExpenseType(String expenseType);
	 
	 void deleteByExpenseType(String expenseType);
	 
	 void deleteByEmpCode(Long empCode);
	 
	 void deleteByExpenseTypeAndEmpCodeAndWbsId(String expenseType, Long empCode, String wbsId); // Add this method declaration

	 boolean existsByEmpCode(Long empCode);
	 
	 List<ClaimsDraftModel> findByEmpCodeAndWbsIdAndExpenseType(Long empCode,String wbsId,String expenseType);
	
}




