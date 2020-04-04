package com.coursecube.springboot;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customerstb")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cid")
	private int cid;
	
	@Column(name="cname")
	private String cname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private int phone;
	
	@Column(name="city")
	private String city;
	
	@Column(name="createdDate")
	private Date createdDate;
	
	@Column(name="lastModifiedDate")
	private Date lastModifiedDate;
	
	@Column(name="createdBy")
	private String createdBy;
	
	public Customer(){}
	
	public Customer( String cname, String email, int phone, String city, Date createdDate,
			Date lastModifiedDate, String createdBy) {
		this.cname = cname;
		this.email = email;
		this.phone = phone;
		this.city = city;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.createdBy = createdBy;
	}
	public Customer(int cid, String cname, String email, int phone, String city, Date createdDate,
			Date lastModifiedDate, String createdBy) {
		this.cid = cid;
		this.cname = cname;
		this.email = email;
		this.phone = phone;
		this.city = city;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.createdBy = createdBy;
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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", email=" + email + ", phone=" + phone + ", city=" + city
				+ ", createdDate=" + createdDate + ", lastModifiedDate=" + lastModifiedDate + ", createdBy=" + createdBy
				+ "]";
	}
	
	
	
}
