package com.emp.org.model;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ClaimsDraft")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimsDraftModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long autoNum;

	@Column
	private Long claimNum;
		
	@Column
	private LocalDate date;
	
	@Column
	private String fromLocation;
	
	@Column
	private String toLocation;
	
	@Column
	private String fromTime;
	
	@Column
	private String toTime;
	
	@Column
	private String purpose;
	
	@Column
	private String modeOfTravel;
	
	@Column
	private String expMode;
	
	@Column
	private Long distance;
	
	@Column
	private String expenseType;
	
	@Column
	private String currency;
	
	@Column
	private Long amount;
	
	@Column
	private String status;
	
	@CreationTimestamp()
	private LocalDate createdDate;
	
	@Column(name="documents")
	private String fileName;
	
	@Column(name = "file_path")
	private String filePath;

	@Column
	private Long empCode;
	
	@Column
	private String wbsId;
}











