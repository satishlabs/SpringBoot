package com.coursecube.springboot;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class Lab1 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JLCConfig.class);
        CustomerDAO cdao = (CustomerDAO)ctx.getBean("custDAO");
        
        //1. Add Customer
        Customer cust1 = new Customer(214, "sd", "sd@jlc", 9999, "Blore"); 
        cdao.addCustomer(cust1);
        
     // 2. getAllCustomers 
        System.out.println("getAllCustomers"); 
        List<Customer> list=cdao.getAllCustomer(); 
        list.forEach( cust -> System.out.println(cust) ); 
    }
}
