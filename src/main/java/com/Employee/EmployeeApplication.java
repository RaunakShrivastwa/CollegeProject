package com.Employee;

import com.Employee.entity.User;
import com.Employee.reprository.UserReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EmployeeApplication {

	@Autowired
	UserReprository userReprository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
		System.out.println("Project gonna started...");
	}

}
