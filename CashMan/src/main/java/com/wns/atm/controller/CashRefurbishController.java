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

import com.wns.atm.Facade.CashRefurbishFacade;
import com.wns.atm.Model.AtmStatus;
import com.wns.atm.Model.Deposit;
import com.wns.atm.entity.CashStatus;
import com.wns.atm.populator.Populate_ATM;

@Controller
public class CashRefurbishController {

@Autowired
CashRefurbishFacade cashRefurbishFacade;

@Autowired
Populate_ATM populator;


	@RequestMapping(value="/updatestack", method=RequestMethod.GET)
	public ModelAndView current(Model model)
	{

     return new ModelAndView("refurbish","deposit",new Deposit());

	}
	
	@RequestMapping(value = "/present", method = RequestMethod.GET)
	public ModelAndView getCurrent() {
		return new ModelAndView("current","cashStatus", populator.populate(new AtmStatus()));
	}
	
	
	@RequestMapping(value="/refurbish", method=RequestMethod.POST)
	public String refurbishCash(@Valid @ModelAttribute Deposit deposit,BindingResult result,Model model)
	{

		if(result.hasErrors())
		{
			return "refurbish";
		}
		else
		{
		
		cashRefurbishFacade.depositCash(deposit);
		CashStatus cashStatus=CashStatus.getInstance();
		model.addAttribute("cashStatus", cashStatus);
		return "current";
		}
	}
	
	@RequestMapping(value="/initialize", method=RequestMethod.POST)
	public String initializeCash(@Valid @ModelAttribute Deposit deposit,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			return "refurbish";
		}
		else
		{
		cashRefurbishFacade.initialize(deposit);
		CashStatus cashStatus=CashStatus.getInstance();
		model.addAttribute("cashStatus", cashStatus);
		return "current";
		}

	}
}
