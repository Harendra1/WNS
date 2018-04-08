package com.wns.atm.facade;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wns.atm.DAO.CashStatusDAO;
import com.wns.atm.Facade.CashRefurbishFacade;
import com.wns.atm.Facade.CashWithDrawalFacade;
import com.wns.atm.Model.Currency;
import com.wns.atm.Model.Withdrawal;
import com.wns.atm.entity.CashStatus;
import com.wns.atm.entity.Transaction;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CashWithdrawFacadeTest {

	@Autowired
	private CashWithDrawalFacade withdrawfacade;
	@Autowired
	private CashRefurbishFacade refurbishfacade;
	@Autowired
	private CashStatusDAO cashStatusDAO;

	CashStatus cashstatus=CashStatus.getInstance();

	@Before
	public void contextLoads() {

		refurbishfacade.initialize();

	}

	@Test
	public void CashWithDrawalFacadeTest_20()
	{
		Transaction test = withdrawfacade.withdrawCash(new Withdrawal("1234567",140));
		Assert.assertEquals(test.getTotalAmount(), new Integer(140));
		for(Currency curr : test.getNotes())
		{
			if(curr.getDenomination()==50) Assert.assertEquals(curr.getCount(),new Integer(2));
			if(curr.getDenomination()==20) Assert.assertEquals(curr.getCount(),new Integer(2));
		}
		
	}
	
	@Test
	public void CashWithDrawalFacadeTest_40()
	{
		Transaction test = withdrawfacade.withdrawCash(new Withdrawal("1234567",40));
		

		Assert.assertEquals(test.getTotalAmount(), new Integer(40));
		for(Currency curr : test.getNotes())
		{
			if(curr.getDenomination()==50) Assert.assertEquals(curr.getCount(),new Integer(0));
			if(curr.getDenomination()==20) Assert.assertEquals(curr.getCount(),new Integer(2));
		}
		
	}
	
	@Test
	public void CashWithDrawalFacadeTest_50()
	{
		Transaction test = withdrawfacade.withdrawCash(new Withdrawal("1234567",50));
		
		Assert.assertEquals(test.getTotalAmount(), new Integer(50));
		for(Currency curr : test.getNotes())
		{
			if(curr.getDenomination()==50) Assert.assertEquals(curr.getCount(),new Integer(1));
			if(curr.getDenomination()==20) Assert.assertEquals(curr.getCount(),new Integer(0));
		}
		
	}
	
	@Test
	public void CashWithDrawalFacadeTest_70()
	{
		Transaction test = withdrawfacade.withdrawCash(new Withdrawal("1234567",70));
		

		Assert.assertEquals(test.getTotalAmount(), new Integer(70));
		for(Currency curr : test.getNotes())
		{
			if(curr.getDenomination()==50) Assert.assertEquals(curr.getCount(),new Integer(1));
			if(curr.getDenomination()==20) Assert.assertEquals(curr.getCount(),new Integer(1));
		}
		
	}
	
	@Test
	public void CashWithDrawalFacadeTest_100()
	{
		Transaction test = withdrawfacade.withdrawCash(new Withdrawal("1234567",20));
		

		Assert.assertEquals(test.getTotalAmount(), new Integer(20));
		for(Currency curr : test.getNotes())
		{
			if(curr.getDenomination()==50) Assert.assertEquals(curr.getCount(),new Integer(0));
			if(curr.getDenomination()==20) Assert.assertEquals(curr.getCount(),new Integer(1));
		}
		
	}
	@Test
	public void CashWithDrawalFacadeTest_150()
	{
		Transaction test = withdrawfacade.withdrawCash(new Withdrawal("1234567",150));
		
		Assert.assertEquals(test.getTotalAmount(), new Integer(150));
		for(Currency curr : test.getNotes())
		{
			if(curr.getDenomination()==50) Assert.assertEquals(curr.getCount(),new Integer(3));
			if(curr.getDenomination()==20) Assert.assertEquals(curr.getCount(),new Integer(0));
		}
		
	}
	@Test
	public void CashWithDrawalFacadeTest_60()
	{
		Transaction test = withdrawfacade.withdrawCash(new Withdrawal("1234567",60));
		

		Assert.assertEquals(test.getTotalAmount(), new Integer(60));
		for(Currency curr : test.getNotes())
		{
			if(curr.getDenomination()==50) Assert.assertEquals(curr.getCount(),new Integer(0));
			if(curr.getDenomination()==20) Assert.assertEquals(curr.getCount(),new Integer(3));
		}
		
	}
	
	@Test
	public void CashWithDrawalFacadeTest_110()
	{
		Transaction test = withdrawfacade.withdrawCash(new Withdrawal("1234567",110));
		

		Assert.assertEquals(test.getTotalAmount(), new Integer(110));
		for(Currency curr : test.getNotes())
		{
			if(curr.getDenomination()==50) Assert.assertEquals(curr.getCount(),new Integer(1));
			if(curr.getDenomination()==20) Assert.assertEquals(curr.getCount(),new Integer(3));
		}
		
	}
	

	public void CashWithDrawalFacadeTest_200()
	{
		Transaction test = withdrawfacade.withdrawCash(new Withdrawal("1234567",200));
		

		Assert.assertEquals(test.getTotalAmount(), new Integer(200));
		for(Currency curr : test.getNotes())
		{
			if(curr.getDenomination()==50) Assert.assertEquals(curr.getCount(),new Integer(4));
			if(curr.getDenomination()==20) Assert.assertEquals(curr.getCount(),new Integer(0));
		}
		
	}

}
