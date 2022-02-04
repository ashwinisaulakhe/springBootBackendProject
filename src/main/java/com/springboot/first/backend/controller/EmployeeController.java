package com.springboot.first.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.first.backend.model.Employee;
import com.springboot.first.backend.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	//build create employee REST API
	@PostMapping
	public ResponseEntity <Employee> saveEmployee(@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee> (employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Employee> getAllEmployee()
	{
		return (List<Employee>) employeeService.getAllEmployees();
	}
	
	//build get employee id by REST API
	@GetMapping
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")long employeeId)
	{
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
	}
	
}
