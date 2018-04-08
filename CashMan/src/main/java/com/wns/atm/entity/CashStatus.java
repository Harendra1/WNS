package com.wns.atm.entity;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Value;

public class CashStatus {

	private Integer sum;

	private Map<Integer, Integer> row = new ConcurrentHashMap<>();

	private static CashStatus INSTANCE = null;
	
	private boolean threshhold=false;

	public static CashStatus getInstance() {
		if (INSTANCE == null) {
			synchronized (CashStatus.class) {
				if (INSTANCE == null) {
					INSTANCE = new CashStatus();
				}
			}
		}

		return INSTANCE;
	}
	
	
	private CashStatus() {
		super();

		row.put(50, 20);
		row.put(20, 20);

		sum = calculateSum();
	}

	public Integer getSum() {
		this.sum=calculateSum();
		return sum;
	}

	
	public boolean isThreshhold() {
		return threshhold;
	}


	public void setThreshhold(boolean threshhold) {
		this.threshhold = threshhold;
	}


	private Integer calculateSum() {
		int sum = 0;
		for (Map.Entry<Integer, Integer> entry : this.row.entrySet()) {
			Integer key = entry.getKey();
			Integer value = entry.getValue();
			sum = sum + (key * value);
			
		}

		return sum;
	}

	public void setSum() {
		this.sum = calculateSum();
	}

	public Map<Integer, Integer> getRow() {
		return row;
	}

	public void setRow(Map<Integer, Integer> row) {
		this.row = row;
	}

	@Override
	public String toString() {
		
		String present = "\n*********\n";
		
		for (Map.Entry<Integer, Integer> entry : this.row.entrySet()) {
			present = present + entry.getKey() + "->" + entry.getValue() + "\n" ;

		}
		return (present + "Sum total is --> " + this.getSum() + "\n ***********");
	}
	
	

}
