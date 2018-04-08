package com.wns.atm.Model;

import javax.validation.constraints.NotNull;

public class Currency implements Comparable<Currency>{
	
	@NotNull(message="*Cannot leave this blank")
	protected Integer denomination;

	@NotNull(message="*Cannot leave this blank")
	protected Integer count;
	
	public Currency() {
		super();
	}
	
	public Currency(@NotNull(message = "*Cannot leave this blank") Integer denomination,
			@NotNull(message = "*Cannot leave this blank") Integer count) {
		super();
		this.denomination = denomination;
		this.count = count;
	}
	
	public Integer getDenomination() {
		return denomination;
	}
	public void setDenomination(Integer denomination) {
		this.denomination = denomination;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public int compareTo(Currency o) {
		// TODO Auto-generated method stub
		return this.denomination.compareTo(o.getDenomination());
	}	

}
