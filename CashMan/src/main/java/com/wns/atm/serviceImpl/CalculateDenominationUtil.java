package com.wns.atm.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.springframework.stereotype.Component;

import com.wns.atm.Model.Currency;
import com.wns.atm.entity.CashStatus;
import com.wns.atm.entity.Transaction;

@Component
public class CalculateDenominationUtil {

	CashStatus cashstatus = CashStatus.getInstance();

	public Transaction calculate(Integer amt) {

		Transaction transaction = simpleRun(amt);

		if (!transaction.getSuccess())
			transaction = reverseRun(amt);
		if (!transaction.getSuccess())
			transaction = deepRun(amt);

        transaction.setTotalAmount();
		return transaction;

	}

	/**
	 * @param amt
	 * @return
	 */
	public Transaction simpleRun(Integer amt) {
		Transaction transaction = new Transaction();

		// parse through available denominations
		TreeSet<Integer> treeSetObj = new TreeSet<Integer>(Collections.reverseOrder());
		for (Map.Entry<Integer, Integer> entry : cashstatus.getRow().entrySet()) {
			treeSetObj.add(entry.getKey());

		}

		// Iterate through the List
		if (cashstatus.getSum() > 0) {

			for (int key : treeSetObj) {
				Integer value = cashstatus.getRow().get(key);
				Integer transaction_count = amt / key;
				if (transaction_count > value) {
					amt = amt - value * key;
					transaction_count = value;
				} else
					amt = amt % key;
				transaction.getNotes().add(new Currency(key, transaction_count));

				if (amt == 0) {
					transaction.setSuccess(true);
					break;
				}
			}
			if (amt > 0) {
				transaction.setSuccess(false);

			}
		}
		return transaction;
	}

	private Transaction reverseRun(Integer amt) {
		Transaction transaction = new Transaction();

		// parse through available denominations
		TreeSet<Integer> treeSetObj = new TreeSet<Integer>();
		for (Map.Entry<Integer, Integer> entry : cashstatus.getRow().entrySet()) {
			treeSetObj.add(entry.getKey());

		}

		// Iterate through the List
		if (cashstatus.getSum() > 0) {

			for (int key : treeSetObj) {
				Integer value = cashstatus.getRow().get(key);
				Integer transaction_count = amt / key;
				if (transaction_count > value) {
					amt = amt - value * key;
					transaction_count = value;
				} else
					amt = amt % key;
				transaction.getNotes().add(new Currency(key, transaction_count));

				if (amt == 0) {
					transaction.setSuccess(true);
					break;
				}
			}
			if (amt > 0) {
				transaction.setSuccess(false);

			}
		}
		return transaction;
	}

	/*
	 * Try combinations,i.e. x20 * y 50 =110. max multiple of x=110/20=5 or
	 * available count of denominations(if available cash notes is lesser than
	 * max multiple) max multiple of y=110/50=2 or available count of
	 * denominations(if available cash notes is lesser than max multiple) The
	 * algorithm shall iterate through various combinations until a match is
	 * found. This is programmed only for 2 Cash denominations
	 */

	private Transaction deepRun(Integer amt) {

		int max=0;
		Currency curr=null;
		int sum;
		Transaction transaction = new Transaction();
		
		// parse through available denominations
		List<Currency> newArray = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : cashstatus.getRow().entrySet()) {
            
			int value = amt / entry.getKey();
			if(entry.getKey() == 20 || entry.getKey() == 50)
				{
				if (entry.getValue() < value)
				curr=new Currency(entry.getKey(), entry.getValue());
			else
					curr=new Currency(entry.getKey(), value);
				}

			newArray.add(curr);
			if(max<curr.getCount())max=curr.getCount();

		}

		// Iterate through the Map
		int calculatedsum = 0;
		

        	for(int j=1;j<=newArray.get(0).getCount();j++) {
        	sum=0;
            sum=newArray.get(0).getDenomination()*j;
			 for(int k=1;k<=newArray.get(1).getCount();k++)
			 {
				 int newsum=sum + (newArray.get(1).getDenomination()*k);

				 if(newsum==amt)
					 {
					 newArray.get(1).setCount(k);
					 transaction.getNotes().add(newArray.get(1));

					 sum=newsum;
					 break;
					 }
				 else
					 newsum=sum;
			 }

			 if(sum==amt)
			 {newArray.get(0).setCount(j);
			 transaction.getNotes().add(newArray.get(0));

			 transaction.setSuccess(true);
			 break;
			 }
        	}
			 
	System.out.println("");

	return transaction;

}

}
