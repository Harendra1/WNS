package com.wns.atm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wns.atm.Facade.CashWithDrawalFacade;
import com.wns.atm.Model.Withdrawal;
import com.wns.atm.entity.Transaction;

@Controller
public class CashWithdrawController {

	@Autowired
	CashWithDrawalFacade cashWithDrawalFacade;

	@RequestMapping(value = "/withdraw", method = RequestMethod.GET)
	public ModelAndView withdrawCash(Model model) {
		ModelAndView mnv = new ModelAndView("withdrawalForm");
		mnv.addObject("withdrawal", new Withdrawal());
		return mnv;
	}

	@RequestMapping(value = "/statement", method = RequestMethod.POST)
	public String getStatement(@Valid @ModelAttribute Withdrawal withdrawal, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "withdrawalForm";
		} else {
			
			System.out.println("getting into pass");
			Transaction transaction = cashWithDrawalFacade.withdrawCash(withdrawal);
            if(!transaction.getSuccess())
            	{
            	model.addAttribute("mesage", transaction.getFailure_message());
            	return "withdrawalForm";
            	}
			model.addAttribute("transaction", transaction);
			return "statement";
		}
	}
}
