package com.emp.org.model;
import java.time.LocalDate;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="TravelTable")
@Data
public class TravelModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long autoNum;

	@Column
	private Long claimNum;
	
	@Column
	private LocalDate date;
	
	@Column
	private String expMode;
	
	@Column
	private String fromLocation;
	
	@Column
	private String toLocation;
	
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
