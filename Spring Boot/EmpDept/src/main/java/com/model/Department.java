package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Department {
	
	@Id
	private int deptId;			
	private String deptName;	
	private String location;
	
	//Implementing Mapping Between Department and Employee
	@JsonIgnore	//UnComment this later on
	@OneToMany(mappedBy="department")
	List<Employee> empList = new ArrayList<Employee>();
	
	public Department() {
	}

	public Department(int deptId, String deptName, String location) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.location = location;
	}
	
	//Generating Getter for empList Variable
	public List<Employee> getEmpList() {
		return empList;
	}

	//Generating Setter for empList Variable
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}