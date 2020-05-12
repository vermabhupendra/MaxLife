package com.synechron.maxlife.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synechron.maxlife.model.InsurancePlan;

@Repository
public interface InsurancePlanRepo extends JpaRepository<InsurancePlan, Integer> {

	List<InsurancePlan> findByIsActive(int isActive);

	List<InsurancePlan> findByAgeAndCity(int age, String city);

}
