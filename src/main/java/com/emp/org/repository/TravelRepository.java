package com.emp.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.org.model.TravelModel;

public interface TravelRepository extends JpaRepository<TravelModel,Long>{

}
