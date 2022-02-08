package com.springboot.first.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@SuppressWarnings("unchecked")
	@GetMapping
	public List<Employee> getAllEmployee()
	{
		return (List<Employee>) employeeService.getAllEmployees();
	}
	
	//build get employee id by REST API
	//http://localhost:8080/api/employees/1
	@GetMapping
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")long employeeId)
	{
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
	}
	
	//build update Employee REST API
	@PutMapping
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id")long id
			,@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id),HttpStatus.OK);
	}
	//build delete Employee REST API
	//http://localhost:8080/api/employees/1
	@DeleteMapping
	public  ResponseEntity<String> deleteEmployee(@PathVariable("id")long id)
	{
		//delete employee from database
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully",HttpStatus.OK);
	}
	
}
