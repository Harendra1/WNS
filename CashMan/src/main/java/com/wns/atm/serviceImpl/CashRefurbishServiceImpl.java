package com.wns.atm.serviceImpl;

import org.apache.logging.slf4j.SLF4JLogger;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wns.atm.DAO.CashStatusDAO;
import com.wns.atm.Model.Currency;
import com.wns.atm.Model.Deposit;
import com.wns.atm.entity.Transaction;
import com.wns.atm.service.CashRefurbishService;

@Service
public class CashRefurbishServiceImpl implements CashRefurbishService {
	
	private static Logger logger=Logger.getLogger(CashRefurbishServiceImpl.class);

	@Autowired
	private CashStatusDAO cashStatusDAO;

	Transaction transaction = new Transaction();

	@Override
	public Transaction depositCash(Integer denomination, Integer count) {
		
		logger.info("Depositing Cash....");

		transaction.getNotes().add(new Currency(denomination, count));

		transaction.setSuccess(cashStatusDAO.insertCashStaus(transaction));

		logger.info("Cash deposited successfully");
		return transaction;

	}
	
	public Transaction initialize(Integer denomination, Integer count)
	{
		logger.info("Initializing Cash machine with value....");
		cashStatusDAO.deleteAll();
		transaction.getNotes().add(new Currency(denomination, count));

		transaction.setSuccess(cashStatusDAO.insertCashStaus(transaction));
		logger.info("ATM Machine initialized....");
		return transaction;
		
	}

	
	public Transaction initialize()
	{
		cashStatusDAO.deleteAll();
		transaction.getNotes().add(new Currency(20, 20));
		transaction.getNotes().add(new Currency(50, 20));
		transaction.setSuccess(cashStatusDAO.insertCashStaus(transaction));

		return transaction;
		
	}
}
