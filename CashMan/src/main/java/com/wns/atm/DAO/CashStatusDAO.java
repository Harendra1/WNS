package com.wns.atm.DAO;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wns.atm.Model.Currency;
import com.wns.atm.entity.CashStatus;
import com.wns.atm.entity.Transaction;

@Repository
public class CashStatusDAO {

	CashStatus cashStatus = CashStatus.getInstance();

	public boolean updateCashStaus(Transaction withdraw_transaction) {

		try {

			for (Currency currency : withdraw_transaction.getNotes()) {
				cashStatus.getRow().computeIfPresent(currency.getDenomination(), (k, v) -> (v - currency.getCount()));
			}
			cashStatus.setSum();

			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	public boolean insertCashStaus(Transaction deposit_transaction) {

		try {
			for (Currency currency : deposit_transaction.getNotes()) {
				cashStatus.getRow().put(currency.getDenomination(), currency.getCount());
			}

			cashStatus.setSum();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	public boolean deleteAll() {

		try {
			cashStatus.getRow().clear();
			cashStatus.setSum();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	public Integer findTotalBalance() {
		cashStatus.setSum();
			return cashStatus.getSum();

	}
	
	public Map<Integer, Integer> findRow() {
				return cashStatus.getRow();

	}
	
	public Boolean findThreshold() {
		return cashStatus.isThreshhold();

}
	
	
	public boolean updateThreshold(Boolean threshold) {

		try {

			cashStatus.setThreshhold(threshold);

			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	
}
