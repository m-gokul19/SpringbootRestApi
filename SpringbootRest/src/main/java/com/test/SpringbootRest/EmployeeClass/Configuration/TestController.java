package com.test.SpringbootRest.EmployeeClass.Configuration;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.SpringbootRest.EmployeeClass.Employee.Employee;
import com.test.SpringbootRest.EmployeeClass.EmployeeRepository.EmployeeService;
import com.test.SpringbootRest.EmployeeClass.EmployeeRepository.UserdataService;

@RestController
public class TestController {
	
	@Autowired
	EmployeeService empservice;
	
	@Autowired
	UserdataService userservice;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/view")
	public List<Employee> view(Authentication authentication,SecurityContextHolder auth) {
		 
		String acceptablerole="user";
		boolean rolefound=false;
		
		System.out.println("current login:"+authentication.getName());
		
		Collection<?extends GrantedAuthority> grantedroles=auth.getContext().getAuthentication().getAuthorities();
		
		for(GrantedAuthority temp:grantedroles) {
			String role =temp.toString();
			System.out.println("my role------------"+role);
			
			if(role.equalsIgnoreCase(acceptablerole)) {
				rolefound=true;
			}
			
		}
		if(rolefound) {
			List<Employee> listemp=empservice.getall();
			return listemp;
		}
		else {
			return null;
		}
	}
	
	@PostMapping("/add")
	public String add(@RequestParam int id,@RequestParam String name,@RequestParam String jobRole,@RequestParam int phNumber,Authentication authentication,SecurityContextHolder auth) {
		 
		String acceptablerole="admin";
		boolean rolefound=false;
		
		System.out.println("current login:"+authentication.getName());
		
		Collection<?extends GrantedAuthority> grantedroles=auth.getContext().getAuthentication().getAuthorities();
		
		for(GrantedAuthority temp:grantedroles) {
			String role =temp.toString();
			System.out.println("my role------------"+role);
			
			if(role.equalsIgnoreCase(acceptablerole)) {
				rolefound=true;
			}
		}
		if(rolefound) {
			
			Employee emp1=new Employee(id,name,jobRole,phNumber);
			empservice.add(emp1);
			return "Employee Added";
		}
		else {
			return "Access Denaid";
		}
	}
	
	
	@PutMapping("/update")
	public String update(@RequestParam int id,@RequestParam String name,@RequestParam String jobRole,@RequestParam int phNumber,Authentication authentication,SecurityContextHolder auth) {
		 
		String acceptablerole="admin";
		boolean rolefound=false;
		
		System.out.println("current login:"+authentication.getName());
		
		Collection<?extends GrantedAuthority> grantedroles=auth.getContext().getAuthentication().getAuthorities();
		
		for(GrantedAuthority temp:grantedroles) {
			String role =temp.toString();
			System.out.println("my role------------"+role);
			
			if(role.equalsIgnoreCase(acceptablerole)) {
				rolefound=true;
			}
			
		}
		if(rolefound) {
			Employee emp=new Employee(id,name,jobRole,phNumber);
			empservice.update(emp	);
			return "Update the Employee";
		}
		else {
			return "Access Denaid";
		}
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestParam int id,Authentication authentication,SecurityContextHolder auth) {
		 
		String acceptablerole="admin";
		boolean rolefound=false;
		
		System.out.println("current login:"+authentication.getName());
		
		Collection<?extends GrantedAuthority> grantedroles=auth.getContext().getAuthentication().getAuthorities();
		
		for(GrantedAuthority temp:grantedroles) {
			String role =temp.toString();
			System.out.println("my role------------"+role);
			
			if(role.equalsIgnoreCase(acceptablerole)) {
				rolefound=true;
			}
			
		}
		if(rolefound) {
			Employee emp4=new Employee(id,"","",0);
			empservice.delete(emp4);
			return "Delete the Employee";
		}
		else {
			return "Access Denaid";
		}
	}
	
	@GetMapping("/sort")
	public List<Employee> sort(@RequestParam String columns,@RequestParam Direction direction,Authentication authentication,SecurityContextHolder auth) {
		 
		String acceptablerole="admin";
		boolean rolefound=false;
		
		System.out.println("current login:"+authentication.getName());
		
		Collection<?extends GrantedAuthority> grantedroles=auth.getContext().getAuthentication().getAuthorities();
		
		for(GrantedAuthority temp:grantedroles) {
			String role =temp.toString();
			System.out.println("my role------------"+role);
			
			if(role.equalsIgnoreCase(acceptablerole)) {
				rolefound=true;
			}
		}
		if(rolefound) {
			
			return empservice.getBySortOnly(columns, direction);
		}
		else {
			return null;
		}
	}
	
	@GetMapping("/search")
	public Employee search(@RequestParam int id,Authentication authentication,SecurityContextHolder auth) {
		 
		String acceptablerole="user";
		boolean rolefound=false;
		
		System.out.println("current login:"+authentication.getName());
		
		Collection<?extends GrantedAuthority> grantedroles=auth.getContext().getAuthentication().getAuthorities();
		
		for(GrantedAuthority temp:grantedroles) {
			String role =temp.toString();
			System.out.println("my role------------"+role);
			
			if(role.equalsIgnoreCase(acceptablerole)) {
				rolefound=true;
			}
		}
		if(rolefound) {
			
			return empservice.findById(id);
		}
		else {
			return null;
		}
	}
	
}

