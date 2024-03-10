package com.test.SpringbootRest.EmployeeClass.EmployeeRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.SpringbootRest.EmployeeClass.Employee.Userdata;

public interface UserRepository extends JpaRepository<Userdata, Integer>{

	Optional<Userdata> findByUsername(String username);
}
