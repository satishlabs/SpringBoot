package com.satish.entity;

import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Customer contains cid,Cname,email,phone,city ")
@XmlRootElement 
public class Customer {
	@ApiModelProperty(value="Contains Cust Id") 
	private int cid;
	
	@ApiModelProperty(value="Contains Cust Name") 
	private String cname;
	
	@ApiModelProperty(value="Contains Email") 
	private String email; 
	
	@ApiModelProperty(value="Contains Phone") 
	private long phone;
	
	@ApiModelProperty(value="Contains City") 
	private String city; 
	public Customer() {}
	public Customer(int cid, String cname, String email, long phone, String city) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.email = email;
		this.phone = phone;
		this.city = city;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", email=" + email + ", phone=" + phone + ", city=" + city
				+ "]";
	} 
	
}
