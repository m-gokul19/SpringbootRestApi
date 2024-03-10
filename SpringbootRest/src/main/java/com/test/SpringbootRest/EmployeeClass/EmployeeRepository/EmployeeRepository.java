package com.test.SpringbootRest.EmployeeClass.EmployeeRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.SpringbootRest.EmployeeClass.Employee.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{	

}
