package com.employee.EmployeeDirectory.services;

import java.util.List;

import com.employee.EmployeeDirectory.model.Employee;


public interface EmployeeServices {

	public Employee saveRegistered(Employee employee);
	
	public List<Employee> employeeList();
	
	public void deleteById(int id);
	
	public Employee findById(int id);
	
	public Employee updateEmployee(Employee employee);
}
