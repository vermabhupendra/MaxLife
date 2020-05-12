package com.synechron.maxlife.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.synechron.maxlife.constants.Constants;
import com.synechron.maxlife.model.InsurancePlan;
import com.synechron.maxlife.restutil.Response;
import com.synechron.maxlife.service.InsurancePlanService;

@RestController
public class InsurancePlanController {

	@Autowired
	private InsurancePlanService insurancePlanService;

	/**
	 * Method to get all active health plans
	 * 
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:8096")
	@GetMapping("/plan/getAll")
	public List<InsurancePlan> getAllActivePlans() {
		return insurancePlanService.getAllActivePlans(Constants.ACTIVE);

//		List<InsurancePlan> listOfAllActivePlans = insurancePlanService.getAllActivePlans(Constants.ACTIVE);
//		if (listOfAllActivePlans.size() != 0) {
//			return new ResponseEntity<Response>(new Response("All active health plan list", listOfAllActivePlans),
//					HttpStatus.OK);
//		} else {
//			return new ResponseEntity<Response>(new Response("No health plans found.", null), HttpStatus.NOT_FOUND);
//		}
	}

	/**
	 * Method to get Plans on the basis of Age and City
	 * 
	 * @param age
	 * @param city
	 * @return
	 */
	@PostMapping("/plan/getAllPlansByAgeAndCity")
	public ResponseEntity<Response> getPlansByAgeAndCity(@RequestParam(value = "age", required = true) int age,
			@RequestParam(value = "city", required = true) String city) {
		List<InsurancePlan> listOfPlansByAgeAndCity = insurancePlanService.getPlansByAgeAndCity(age, city);

		if (listOfPlansByAgeAndCity.size() != 0) {
			return new ResponseEntity<Response>(
					new Response("Health plan list as per age and city", listOfPlansByAgeAndCity), HttpStatus.OK);
		} else {
			return new ResponseEntity<Response>(new Response("No health plans found.", null), HttpStatus.NOT_FOUND);
		}
	}
}
