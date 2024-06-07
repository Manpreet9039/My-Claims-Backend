//package com.emp.org.model;
//
//import java.sql.Date;
//import java.time.LocalDate;
//
//import org.hibernate.annotations.CreationTimestamp;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.Data;
//
//@Entity
//@Table(name="advance_table")
//@Data
//public class AdvClaimModel {
//	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long id;
//
//	
//
//
//	
//	@Column
//	private LocalDate toDate;
//	
//
//	@Column
//	private String purpose;
//	
//	@Column
//	private String expenseType;
//	
//
//	
//	@Column
//	private Long amount;
//	
//
//	@Column
//	private String currency;
//	
//	@CreationTimestamp()
//	private LocalDate createdDate;
//	
//	@Column(name="file_name")
//	private String fileName;
//	
//	
//	 @Column(name = "file_path")
//	    private String filePath;
//	 
//	
//	
//	
//
//}