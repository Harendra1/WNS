package com.wns.atm.populator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wns.atm.DAO.CashStatusDAO;
import com.wns.atm.Model.AtmStatus;
import com.wns.atm.entity.CashStatus;

@Component
public class Populate_ATM {
	@Autowired
	CashStatusDAO  cashStatusDAO;

	
	public AtmStatus populate(AtmStatus atm)
	{
		atm.setRow(cashStatusDAO.findRow());
		atm.setSum(cashStatusDAO.findTotalBalance());
		atm.setThreshhold(cashStatusDAO.findThreshold());
		return atm;
	}

}
