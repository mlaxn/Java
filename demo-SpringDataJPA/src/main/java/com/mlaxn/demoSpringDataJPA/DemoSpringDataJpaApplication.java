package com.mlaxn.demoSpringDataJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.mlaxn.demoSpringDataJPA"})
public class DemoSpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringDataJpaApplication.class, args);
		System.out.println("Dog Sprint Boot Started ...");
	}

}
