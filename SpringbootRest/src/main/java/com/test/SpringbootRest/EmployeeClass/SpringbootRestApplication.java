package com.test.SpringbootRest.EmployeeClass;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.test.SpringbootRest.EmployeeClass.Employee.Userdata;
import com.test.SpringbootRest.EmployeeClass.EmployeeRepository.UserdataService;

@SpringBootApplication
public class SpringbootRestApplication implements CommandLineRunner{

	@Autowired
	UserdataService userdataservice;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Set<String> authadmin=new HashSet();
		authadmin.add("admin");
		
		Set<String> authuser=new HashSet();
		authuser.add("user");
		
		PasswordEncoder en=new BCryptPasswordEncoder();
		
		Userdata useradmin=new Userdata(1,"admin",en.encode("adminpassword"),authadmin);
		userdataservice.add(useradmin);
		
		Userdata user=new Userdata(2,"user",en.encode("userpassword"),authuser);
		userdataservice.add(user);
	}

}

