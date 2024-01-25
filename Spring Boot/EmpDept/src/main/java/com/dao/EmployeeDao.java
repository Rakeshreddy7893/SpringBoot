package com.dao;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Employee;

@Service
public class EmployeeDao {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmployeeById(int employeeId) {
		return employeeRepository.findById(employeeId).orElse(null);
	}

	public Employee getEmployeeByName(String employeeName) {
		return employeeRepository.findByName(employeeName);
	}

	public Employee employeeLogin(String emailId, String password) {
		Employee employee = employeeRepository.findByEmailId(emailId);
		
	    if (employee != null && BCrypt.checkpw(password, employee.getPassword())) {
	        return employee;
	    } else {
	        return null;
	    }
	}

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteEmployeeById(int employeeId) {
		employeeRepository.deleteById(employeeId);
	}
	
}