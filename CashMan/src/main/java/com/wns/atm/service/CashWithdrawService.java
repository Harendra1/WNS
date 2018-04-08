package com.wns.atm.service;

import com.wns.atm.entity.Transaction;

public interface CashWithdrawService {

	Transaction withdrawCash(String cardNumber, Integer amount);

}