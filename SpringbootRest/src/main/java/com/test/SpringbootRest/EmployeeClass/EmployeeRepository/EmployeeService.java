package com.test.SpringbootRest.EmployeeClass.EmployeeRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.test.SpringbootRest.EmployeeClass.Employee.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repo;

	public void add(Employee employee) {
		repo.save(employee);
	}

	public void update(Employee employee) {
		repo.save(employee);
	}

	public void delete(Employee employee) {
		repo.delete(employee);
	}

	public List<Employee> getall() {
		return repo.findAll();
	}

	public Employee findById(int id) {
		if (repo.findById(id).isEmpty()) {
			return null;
		} else {
			return repo.findById(id).get();
		}

	}

	public List<Employee> getBySortOnly(String columns, Direction direction) {

		return repo.findAll(Sort.by(direction, columns));

	}

}
