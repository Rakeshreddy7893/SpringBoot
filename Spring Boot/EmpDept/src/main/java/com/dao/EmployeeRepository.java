package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("from Employee where empName = :employeeName")
	Employee findByName(@Param("employeeName") String employeeName);

	@Query("from Employee where emailId = :emailId and password = :password")
	Employee employeeLogin(@Param("emailId") String emailId, @Param("password") String password);
	
    @Query("from Employee where emailId = :emailId")
    Employee findByEmailId(@Param("emailId") String emailId);

}