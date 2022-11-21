package com.Employee;

import com.Employee.entity.User;
import com.Employee.reprository.UserReprository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class EmployeeApplicationTests {

	@Autowired
	private UserReprository userReprository;
	@Test
	void contextLoads() {

		User user =new User();
		String password="shubham";
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String encode = bCryptPasswordEncoder.encode(password);

		        user.setEmail("codecprogramming@gmail.com");
				user.setFirstName("shubham");
				user.setLastName("shrivastwa");
		        user.setPassword(encode);
				user.setRole("ROLE_ADMIN");
				user.setAbout("admin of this api");

	this.userReprository.save(user);



	}

}
