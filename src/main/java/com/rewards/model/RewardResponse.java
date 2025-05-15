package com.rewards.model;

import java.util.Map;

public class RewardResponse {
	
	
	public RewardResponse(String customerName, Map<String, Integer> monthlyPoints, int totalPoints) {
		this.customerName = customerName;
		this.monthlyPoints = monthlyPoints;
		this.totalPoints = totalPoints;
	}

	private String customerName;
	
	private Map<String,Integer> monthlyPoints;
	
	private int totalPoints;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Map<String, Integer> getMonthlyPoints() {
		return monthlyPoints;
	}

	public void setMonthlyPoints(Map<String, Integer> monthlyPoints) {
		this.monthlyPoints = monthlyPoints;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}
	
	
}
