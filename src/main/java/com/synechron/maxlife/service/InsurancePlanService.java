package com.synechron.maxlife.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synechron.maxlife.model.InsurancePlan;
import com.synechron.maxlife.repository.InsurancePlanRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InsurancePlanService {

	@Autowired
	private InsurancePlanRepo insurancePlanRepo;

	public List<InsurancePlan> getAllActivePlans(int isActive) {
		return insurancePlanRepo.findByIsActive(isActive);
	}

	public List<InsurancePlan> getPlansByAgeAndCity(int age, String city) {
		return insurancePlanRepo.findByAgeAndCity(age, city);
	}

	public InsurancePlan checkForHealthPlan(int planId) {
		log.debug("Plan id:" + planId);
		Optional<InsurancePlan> planObj = insurancePlanRepo.findById(planId);
		return planObj.isPresent() ? planObj.get() : null;

	}
}
