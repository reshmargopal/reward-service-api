package com.rewards.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rewards.model.Customer;
import com.rewards.model.RewardResponse;
import com.rewards.model.Transaction;
import com.rewards.repository.CustomerRepository;
import com.rewards.repository.TransactionRepository;

@Service
public class RewardService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	TransactionRepository transactionRepository;

	public List<RewardResponse> calculateRewards() {

		List<Customer> customers = customerRepository.findAll();
		List<RewardResponse> rewardResponse = new ArrayList<>();
		System.out.println("reward:::"+customers);

		for(Customer customer: customers) {
			Map<String, Integer> monthlyPoints = new HashMap<>();
			
			int totalPoints = 0;
			
			
			for (Transaction transaction : customer.getTransactions()) {
				int points = calculatePoint(transaction.getAmount());

				String month = transaction.getTransactionDate().getMonth().name();
				monthlyPoints.put(month, monthlyPoints.getOrDefault(month, 0)+points);
				totalPoints += points;
				System.out.println("reward:::"+totalPoints);
			}
			 
			
			rewardResponse.add(new RewardResponse(customer.getName(),monthlyPoints,totalPoints));
			
		}

		return rewardResponse;
	}

	private int calculatePoint(double amount) {
		
		int reward = 0;
		if (amount > 100) {
			reward += (amount - 100) * 2;
			reward += 50;
		} else if (amount > 50) {
			reward += amount - 50;
		}
		System.out.println("reward:::"+reward);
		return reward;
	}

}
