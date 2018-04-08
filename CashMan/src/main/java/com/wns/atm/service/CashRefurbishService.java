package com.wns.atm.service;

import com.wns.atm.Model.Deposit;
import com.wns.atm.entity.Transaction;

public interface CashRefurbishService {

	Transaction depositCash(Integer denomination, Integer count);

	Transaction initialize(Integer denomination, Integer count);

	Transaction initialize();
}