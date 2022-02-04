package com.springboot.first.backend.service.impl;

import com.springboot.first.backend.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List getAllEmployees();

	com.springboot.first.backend.service.impl.Employee getEmployeeById();



}
