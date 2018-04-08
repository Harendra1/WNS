package com.wns.atm.entity;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.wns.atm.Model.Currency;

public class Transaction {
	private String cardNumber;
	private Set<Currency> notes = new TreeSet<>();
	private Integer totalAmount;
	private LocalDateTime date=LocalDateTime.now();
	private Boolean success=false;
	private String failure_message;


	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Set<Currency> getNotes() {
		return notes;
	}

	public void setNotes(Set<Currency> notes) {
		this.notes = notes;
	}

	public Integer getTotalAmount() {
		
		return totalAmount;
	}

	public void setTotalAmount() {
		
		int sum = 0;
		for(Currency currency : this.notes){
			sum=sum + (currency.getCount() * currency.getDenomination());
			System.out.println("Sum = " + sum + "  Denomination= " + currency.getDenomination() + "   Count=" + currency.getCount());
			};
			
			System.out.println("Total sum for transaction is -- " + sum);
		this.totalAmount = sum;
	}
	


	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	
	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		
		String present = "\n*********\n";
		
		for (Currency currency : this.notes) {
			present = present + currency.getDenomination() + "->" + currency.getCount() + "\n" ;

		}
		return (present + "Sum total is --> " + this.getTotalAmount() + "\n ***********");
	}

	public String getFailure_message() {
		return failure_message;
	}

	public void setFailure_message(String failure_message) {
		this.failure_message = failure_message;
	}


}
