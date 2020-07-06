package com.satish;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/viewBooks")
	public String showViewBooks() {
		System.out.println("***ShowViewBooksPage***");
		return "viewBooks";
	}
	
	@GetMapping("/addBook")
	public String addBooks() {
		System.out.println("***AddBooksPage***");
		return "addBook";
	}
	@GetMapping("/editBook")
	public String editBook() {
		System.out.println("***EditBookPage***");
		return "editBook";
	}
	
	@GetMapping("/deleteBook")
	public String deleteBook() {
		System.out.println("***DeleteBooksPages***");
		return "deleteBook";
	}
	
	@GetMapping("/placeOrder")
	public String placeOrder() {
		System.out.println("***PlaceOrderPage***");
		return "placeOrder";
	}
}
