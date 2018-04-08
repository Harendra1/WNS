package com.wns.atm.serviceImpl;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wns.atm.DAO.CashStatusDAO;
import com.wns.atm.entity.Transaction;
import com.wns.atm.service.CashWithdrawService;

@Service
public class CashWithdrawServiceImpl implements CashWithdrawService {

	@Autowired
	private CashStatusDAO cashStatusDAO;

	@Autowired
	private CheckBalanceUtil checkBalance;

	@Autowired
	private CalculateDenominationUtil calDenomination;

	private static Logger logger = Logger.getLogger(CashWithdrawServiceImpl.class);

	@Override
	public Transaction withdrawCash(String cardNumber, Integer amount) {

		logger.info("Cash Withdrawal in progress....");

		Transaction transaction = new Transaction();

		// Validate sufficient cash is present & create transaction

		if(!checkBalance.isbalanceAvailable())
		{
			transaction.setSuccess(false);
			transaction.setFailure_message("Sorry,but we can't cater your request as the ATM is running out of cash!!!");
			return transaction;
		}
		
		if (checkBalance.issufficientbalanceAvailable(transaction, amount).getSuccess()) {

			transaction = calDenomination.calculate(amount);
			transaction.setCardNumber(cardNumber);
		} else {
			transaction.setSuccess(false);
			transaction.setFailure_message("Unfortunately we are not able to serve you with this amount.Try smaller value");
			return transaction;
		}

		if (transaction.getSuccess()) {
			transaction.setSuccess(cashStatusDAO.updateCashStaus(transaction));
		}

		if (checkBalance.isBalanceBelowThreshold()) {
			raiseAlert();
		}
		logger.info("Cash Withdrawal completed..");
		logger.debug("Transaction values after Cash Withdrawal -> " + transaction);

		return transaction;
	}

	private void raiseAlert() {
		logger.info("Cash in ATM below threshold.Take action immediately.");
		cashStatusDAO.updateThreshold(true);
	}

}
