package com.dao;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.model.Employee;
import com.ts.config.TwilioConfig;

@Service
public class EmployeeDao {

	@Autowired
	EmployeeRepository employeeRepository;


    @Autowired
    private TwilioConfig twilioConfig;
	
	@Autowired
	private JavaMailSender mailSender;

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
		return employeeRepository.employeeLogin(emailId, password);
	}

	public Employee addEmployee(Employee employee) {
		String otp = generateOtp();
        employee.setOtp(otp);

		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encryptedPwd = bcrypt.encode(employee.getPassword());
		employee.setPassword(encryptedPwd);

		// Save the employee
		Employee savedEmployee = employeeRepository.save(employee);

		// Send a welcome email
		sendWelcomeEmail(savedEmployee);
		
		// Send OTP via Twilio
		sendOtpViaTwilio(savedEmployee);

		return savedEmployee;
	}

	private void sendWelcomeEmail(Employee employee) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(employee.getEmailId());
		message.setSubject("Welcome to our website");
		message.setText("Dear " + employee.getEmpName() + ",\n\n"
				+ "Thank you for registering ");

		mailSender.send(message);
	}

	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteEmployeeById(int employeeId) {
		employeeRepository.deleteById(employeeId);
	}
	
    private void sendOtpViaTwilio(Employee employee) {
        String phoneNumber = employee.getPhoneNumber();
        twilioConfig.sendOtp(phoneNumber, employee.getOtp());
    }

    private String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

}