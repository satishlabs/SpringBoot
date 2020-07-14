package com.satish;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Account {
	private int accno;
	private String atype;
	private String bcode;
	private double balance;
	
	public Account() {}

	public Account(int accno, String atype, String bcode, double balance) {
		this.accno = accno;
		this.atype = atype;
		this.bcode = bcode;
		this.balance = balance;
	}
	
	
}
