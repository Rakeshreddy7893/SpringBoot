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

import com.dao.DepartmentDao;
import com.model.Department;

@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentDao departmentDao;

	@GetMapping("getDepartments")
	public List<Department> getDepartments() {
		return departmentDao.getDepartments();
	}
	
	@GetMapping("getDepartmentById/{departmentId}")
	public Department getDepartmentById(@PathVariable int departmentId) {
		return departmentDao.getDepartmentById(departmentId);
	}
	
	@GetMapping("getDepartmentByName/{departmentName}")
	public Department getDepartmentByName(@PathVariable String departmentName) {
		return departmentDao.getDepartmentByName(departmentName);
	}
	
	@PostMapping("addDepartment")
	public Department addDepartment(@RequestBody Department department) {
		return departmentDao.addDepartment(department);
	}
	
	@PutMapping("updateDepartment")
	public Department updateDepartment(@RequestBody Department department) {
		return departmentDao.updateDepartment(department);
	}
	
	@DeleteMapping("deleteDepartmentById/{departmentId}")
	public String deleteDepartmentById(@PathVariable int departmentId) {
		departmentDao.deleteDepartmentById(departmentId);
		return "Department With DepartmentId:" + departmentId + " Deleted Successfully!!!" ;
	}
}