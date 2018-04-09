package com.wns.atm.populator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wns.atm.DAO.CashStatusDAO;
import com.wns.atm.Model.AtmStatus;
import com.wns.atm.entity.CashStatus;

@Component
public class Populate_ATM {
	
	CashStatus cashStatus=CashStatus.getInstance();
	
	public AtmStatus populate(AtmStatus atm)
	{
		atm.setRow(cashStatus.getRow());
		atm.setSum(cashStatus.getSum());
		atm.setThreshhold(cashStatus.isThreshhold());
		return atm;
	}

}
