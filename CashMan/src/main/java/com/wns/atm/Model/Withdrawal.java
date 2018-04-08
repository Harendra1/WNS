package com.wns.atm.Model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Withdrawal {
	
	@NotBlank(message="Card Number cannot be left blank")
	private String cardNumber;
	
	@NotNull(message="Withdrawal amount cannot be left blank")
	@Max(value=1000, message="Sorry you can only withdraw a maximum of 1000 from your account")
	@Min(value=20, message="Sorry the machine cannot tender such a small amount.Try value above")
	
	
	private Integer withdrawalAmount;
	
	
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Integer getWithdrawalAmount() {
		return withdrawalAmount;
	}
	public void setWithdrawalAmount(Integer withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}
	public Withdrawal(@NotBlank(message = "Card Number cannot be left blank") String cardNumber,
			@NotNull(message = "Withdrawal amount cannot be left blank") @Max(value = 1000, message = "Sorry you can only withdraw a maximum of 1000 from your account") @Min(value = 10, message = "Sorry the machine cannot tender such a small amount.Try value above") Integer withdrawalAmount) {
		super();
		this.cardNumber = cardNumber;
		this.withdrawalAmount = withdrawalAmount;
	}
	public Withdrawal() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
