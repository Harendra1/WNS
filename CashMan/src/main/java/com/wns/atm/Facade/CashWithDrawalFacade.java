package com.wns.atm.Facade;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wns.atm.Model.Withdrawal;
import com.wns.atm.entity.Transaction;
import com.wns.atm.service.CashWithdrawService;

@Service
public class CashWithDrawalFacade {

	@Autowired
	private CashWithdrawService cashWithdrawService;

	private static Logger logger=Logger.getLogger(CashWithDrawalFacade.class);
	
	public Transaction withdrawCash(Withdrawal withdraw) {
		logger.debug("withdrawCash module with parameter -- > " + withdraw);
		return cashWithdrawService.withdrawCash(withdraw.getCardNumber(), withdraw.getWithdrawalAmount());

	}

}
