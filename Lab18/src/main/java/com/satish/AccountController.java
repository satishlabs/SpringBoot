package com.satish;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	@GetMapping(value = "/mybal/{accno}")
	public double getBalance(@PathVariable("accno")String accno) {
		System.out.println("AC-getBalace()"+accno);
		return 25000;
	}
	/*
	 * Two same endpoinst can not be possible
	@GetMapping(value = "/mybal/{accno}")
	public double getBalance2(@PathVariable("accno")String accno) {
		System.out.println("AC-getBalace()"+accno);
		return 25000;
	}
	*/

	@GetMapping("/myaccount/{accno}")
	public Account getAccountByAccno(@PathVariable("accno")int accno) {
		System.out.println("AC-getAccountByAccno()"+accno);
		Account acc = new Account(accno, "SA", "B99", 30000.0);
		return acc;
	}
	
	
	@GetMapping("/myaccount")
	public List<Account> getAllAccounts(){
		System.out.println("Get- AllAccounts()");
		
		List<Account> accList = new ArrayList<Account>();
		accList.add(new Account(101, "FD", "F001", 50000.0));
		accList.add(new Account(102, "SA", "S001", 5000.0));
		accList.add(new Account(103, "PA", "P003", 150000.0));
		accList.add(new Account(104, "MA", "M001", 30000.0));
		accList.add(new Account(105, "LA", "L005", 50000.0));
		return accList;
	}
}
