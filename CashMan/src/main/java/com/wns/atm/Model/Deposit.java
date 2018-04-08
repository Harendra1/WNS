package com.wns.atm.Model;

import java.util.ArrayList;
import java.util.List;

public class Deposit extends Currency{

	private Integer depositedAmount;
	
	public Integer getDepositedAmount() {
		return (denomination*count);
	}
	public void setDepositedAmount(Integer depositedAmount) {
		this.depositedAmount = depositedAmount;
	}
	public Integer getDenomination() {
		return denomination;
	}
	public void setDenomination(Integer denomination) {
		this.denomination = denomination;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Deposit(Integer denomination, Integer count) {
		super(denomination,count);
	}
	public Deposit() {
		super();
		// TODO Auto-generated constructor stub
	}


}
