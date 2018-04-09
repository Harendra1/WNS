package com.wns.atm.Model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.wns.atm.entity.CashStatus;

public class AtmStatus {

	private Integer sum;

	private Map<Integer, Integer> row = new ConcurrentHashMap<>();

	private static CashStatus INSTANCE = null;

	private boolean threshhold = false;

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public Map<Integer, Integer> getRow() {
		return row;
	}

	public void setRow(Map<Integer, Integer> row) {
		this.row = row;
	}

	public static CashStatus getINSTANCE() {
		return INSTANCE;
	}

	public static void setINSTANCE(CashStatus iNSTANCE) {
		INSTANCE = iNSTANCE;
	}

	public boolean isThreshhold() {
		return threshhold;
	}

	public void setThreshhold(boolean threshhold) {
		this.threshhold = threshhold;
	}

}
