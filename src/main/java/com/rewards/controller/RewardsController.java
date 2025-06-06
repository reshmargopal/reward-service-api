package com.rewards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rewards.service.RewardService;

@RestController
@RequestMapping("/reward")
public class RewardsController {
	
	@Autowired
	RewardService rewardService;
	
	@GetMapping("/get")
	public ResponseEntity<?> getCustomerRewards(){
		return  new ResponseEntity<>(rewardService.calculateRewards(), HttpStatus.CREATED);
	}
	
	

}
