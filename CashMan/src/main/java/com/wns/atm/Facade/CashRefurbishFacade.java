package com.wns.atm.Facade;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wns.atm.Model.Deposit;
import com.wns.atm.Model.Withdrawal;
import com.wns.atm.entity.Transaction;
import com.wns.atm.service.CashRefurbishService;
import com.wns.atm.service.CashWithdrawService;
import com.wns.atm.serviceImpl.CashRefurbishServiceImpl;

@Component
public class CashRefurbishFacade {
	
	private static Logger logger=Logger.getLogger(CashRefurbishFacade.class);
	
	@Autowired
	private CashRefurbishService cashRefurbishService;
	


	public void depositCash(Deposit deposit) {
		
		logger.debug("depositCash module with parameter -- > " + deposit);
		
		cashRefurbishService.depositCash(deposit.getDenomination(),deposit.getCount());

	}
	
	public void initialize(Deposit deposit) {
		
		logger.debug("initialize module with parameter -- > " + deposit);
		
		cashRefurbishService.initialize(deposit.getDenomination(),deposit.getCount());

	}
	
	public void initialize() {
		
		logger.debug("initialize module without parameter");
		
		cashRefurbishService.initialize();

	}

}
