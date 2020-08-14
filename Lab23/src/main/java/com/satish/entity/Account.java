package com.satish.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Account contains Accno,AccType,BranchCoe,balance ") 
public class Account {
	@ApiModelProperty(value="Contains Acc Number") 
	private int accno; 

	@ApiModelProperty(value="Contains Acc Type") 
	private String atype; 

	@ApiModelProperty(value="Contains Branch") 
	private String bcode;

	@ApiModelProperty(value="Contains Acc Balance") 
	private double balance; 

	public Account() {}
	public Account(int accno, String atype, String bcode, double balance) {
		super();
		this.accno = accno;
		this.atype = atype;
		this.bcode = bcode;
		this.balance = balance;
	}

	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getAtype() {
		return atype;
	}
	public void setAtype(String atype) {
		this.atype = atype;
	}
	public String getBcode() {
		return bcode;
	}
	public void setBcode(String bcode) {
		this.bcode = bcode;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accno=" + accno + ", atype=" + atype + ", bcode=" + bcode + ", balance=" + balance + "]";
	} 


}
