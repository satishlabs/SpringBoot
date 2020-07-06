package com.satish;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BooksController {

	@GetMapping("/showBooks")
	public String getBooks(HttpSession session) {
		System.out.println("BooksController --- getBooks()");

		List<Book> blist = new ArrayList<>();
		Book mybook1 = new Book(1, "JAVA", "Satish", new BigDecimal(10000.0), "INS");
		Book mybook2=new Book(102,"Master MicroServices","Srinivas Dande",BigDecimal.valueOf(10000.0),"JLC");
		Book mybook3=new Book(103,"Master Angular","Srinivas Dande",BigDecimal.valueOf(10000.0),"JLC");
		Book mybook4=new Book(104,"Master React ","Srinivas Dande",BigDecimal.valueOf(10000.0),"JLC");
		Book mybook5=new Book(105,"Master Java Full Stack","Srinivas Dande",BigDecimal.valueOf(10000.0),"JLC");

		blist.add(mybook1);
		blist.add(mybook2); 
		blist.add(mybook3);
		blist.add(mybook4); 
		blist.add(mybook5); 

		
		System.out.println(blist.size());

		session.setAttribute("MyBooks", blist);
		return "booksList";
	}
}
