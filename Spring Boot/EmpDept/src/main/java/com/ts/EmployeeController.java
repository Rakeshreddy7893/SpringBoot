package com.ts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.EmployeeDao;
import com.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeDao employeeDao;
	
	@GetMapping("getEmployees")
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}
	
	@GetMapping("getEmployeeById/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		return employeeDao.getEmployeeById(employeeId);
	}
	
	@GetMapping("getEmployeeByName/{employeeName}")
	public Employee getEmployeeByName(@PathVariable String employeeName) {
		return employeeDao.getEmployeeByName(employeeName);
	}
	
	@GetMapping("empLogin/{emailId}/{password}")
	public Employee employeeLogin(@PathVariable String emailId, @PathVariable String password) {
		return employeeDao.employeeLogin(emailId, password);
	}
	
	@PostMapping("addEmployee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeDao.addEmployee(employee);
	}
	
	@PutMapping("updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeDao.updateEmployee(employee);
	}
	
	@DeleteMapping("deleteEmployeeById/{employeeId}")
	public String deleteEmployeeById(@PathVariable int employeeId) {
		employeeDao.deleteEmployeeById(employeeId);
		return "Employee with empId:" + employeeId + " Deleted Successfully!!!";
	}
}