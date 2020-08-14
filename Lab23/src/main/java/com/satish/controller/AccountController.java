package com.satish.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.satish.entity.Account;

import io.swagger.annotations.ApiOperation;

@RestController
public class AccountController {

	@ApiOperation( value = " get the Balance", response = double.class,
			notes = "Gives Balance of Customer with Accno" )
	@GetMapping("/mybal/{accno}") 
	public double getBalance(@PathVariable("accno")String accno) {
		System.out.println("AC-getBalance()" + accno);
		return 25000; 
	}

	@ApiOperation(value = " get the Account Information",response = Account.class,
			notes = "Gives Complete Account Information with Accno" )
	@GetMapping("/myaccount/{accno}")
	public Account getAccountByAccno(@PathVariable("accno") int accno) {
		System.out.println("AC-getAccountByAccno()" + accno);
		Account acc=new Account(accno,"SA","B99",29000.0);
		return acc;
	}

	@ApiOperation(value = " get All Accounts Information",response = List.class,notes = "Gives All the Accounts Information" )
	@GetMapping("/myaccounts")
	public List<Account> getAllCounts(){
		System.out.println("AC-getAllCounts()");
		List<Account> accList=new ArrayList<>();
		accList.add(new Account(101,"SA","B99",19000.0));
		accList.add(new Account(102,"SA","B99",29000.0));
		accList.add(new Account(103,"SA","B99",29000.0));
		accList.add(new Account(104,"SA","B99",39000.0));
		accList.add(new Account(105,"SA","B99",49000.0));
		return accList;
	} 

	@ApiOperation(value = " Adds Account Info",response = Account.class,notes = "Adds Accounts Information" ) 
	@PostMapping(value = "/addccount")
	public Account addAccount(@RequestBody Account acc) {
		System.out.println("AC - addAccount()");
		acc.setAccno(123);
		return acc;
	}

	@ApiOperation(value = " Updates Account Info",response = String.class,
			notes = "Updates Accounts Information" )
	@PutMapping(value="/updateAccount")
	public String updateAccount(@RequestBody Account acc) {
		System.out.println("AC-updateAccount()");
		String msg="Account Updated Successfully";
		return msg;
	}
	@ApiOperation(value = " Delete Account Info",response = String.class,
			notes = "Delete Accounts Information" )
	@DeleteMapping(value="/deleteAccount/{myaccno}")
	public String deleteAccount(@PathVariable("myaccno") String accno) {
		System.out.println("AC-deleteAccount()");
		String msg="Account Deleted Successfully";
		return msg;
	}
}
