package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Department;

@Service
public class DepartmentDao {

	@Autowired
	DepartmentRepository departmentRepository;

	public List<Department> getDepartments() {
		return departmentRepository.findAll();
	}

	public Department getDepartmentById(int departmentId) {
		return departmentRepository.findById(departmentId).orElse(null);
	}

	public Department getDepartmentByName(String departmentName) {
		return departmentRepository.findByName(departmentName);
	}

	public Department addDepartment(Department department) {
		return departmentRepository.save(department);
	}

	public Department updateDepartment(Department department) {
		return departmentRepository.save(department);
	}

	public void deleteDepartmentById(int departmentId) {
		departmentRepository.deleteById(departmentId);
	}
	
	
}