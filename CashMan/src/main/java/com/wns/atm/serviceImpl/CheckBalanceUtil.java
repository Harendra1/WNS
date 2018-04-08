package com.wns.atm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.wns.atm.DAO.CashStatusDAO;
import com.wns.atm.entity.CashStatus;
import com.wns.atm.entity.Transaction;

import ch.qos.logback.classic.Logger;

@Component("balanceservice")
public class CheckBalanceUtil {

	CashStatus cashStatus = CashStatus.getInstance();
	@Value("${min.threshhold}")
	String minThreshhold;

	@Autowired
	CashStatusDAO cashStatusDAO;

	public boolean isbalanceAvailable() {

		return (cashStatus.getSum() > 0);
	}

	public Transaction issufficientbalanceAvailable(Transaction t, Integer amount) {
		if (cashStatus.getSum() >= amount)
			t.setSuccess(true);
		else
			t.setSuccess(false);

		return t;
	}

	public boolean isdenominationAvailable(Transaction t) {
		return t.getSuccess();
	}

	public boolean isBalanceBelowThreshold() {

		if (cashStatusDAO.findTotalBalance() <= Integer.parseInt(minThreshhold))
			return true;
		else
			return false;
	}

}
