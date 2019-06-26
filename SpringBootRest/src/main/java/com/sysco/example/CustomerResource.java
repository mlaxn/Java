package com.sysco.example;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerResource {
	
	
	@RequestMapping("home")
	public String home() {
		
		
		return"home.jsp";
		
	}
	
	@RequestMapping("customer")
	public List<Customer> getCustomer(){
		
		List<Customer> customer = new ArrayList<>();
		Customer c1 = new Customer();
		c1.setId(1);
		c1.setName("Roberto");
		c1.setPosition("Manger");
		
		Customer c2 = new Customer();
		c2.setId(2);
		c2.setName("Shilpa");
		c2.setPosition("Tech Lead");
		
		customer.add(c1);
		customer.add(c2);

		
		return customer;
		
	}
	
	

}
