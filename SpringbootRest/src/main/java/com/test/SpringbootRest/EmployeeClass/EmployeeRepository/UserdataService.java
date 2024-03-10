package com.test.SpringbootRest.EmployeeClass.EmployeeRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.SpringbootRest.EmployeeClass.Employee.Userdata;

@Service
public class UserdataService implements UserDetailsService{
	
	@Autowired
	UserRepository repo;
	
	public void add(Userdata userdata) {
		repo.save(userdata);
	}
	public List<Userdata> getall() {
		return repo.findAll();
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Userdata> userdata=repo.findByUsername(username);
		
		Set<GrantedAuthority> grantedAuthorities=new HashSet<GrantedAuthority>();
		for(String temp:userdata.get().getAuthoritiesRoles()) {
			GrantedAuthority ga=new SimpleGrantedAuthority(temp);
			grantedAuthorities.add(ga);
		}
		User user=new User(username,userdata.get().getPassword(),grantedAuthorities);
		
		return user;
	}
	
	
}
