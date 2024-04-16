package com.springjava.ems.backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springjava.ems.backend.dto.EmployeeDto;
import com.springjava.ems.backend.service.EmployeeService;
import com.springjava.ems.backend.service.EmployeeServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto empDto) {
		try {
		return new ResponseEntity<>(employeeService.createEmployee(empDto), HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id){
		
		return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
		
		}
	
	@GetMapping("/employee")
	public ResponseEntity<List<EmployeeDto>> getEmployee(){
		
		return new ResponseEntity<>(employeeService.getAllEmp(), HttpStatus.OK);
		
		}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long empId, 
			@RequestBody EmployeeDto empDto){
		return new ResponseEntity<>(employeeService.updateEmployee(empId, empDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long empId){
		employeeService.deleteEmployee(empId);
		return new ResponseEntity<>("Employee deleted successfully...!", HttpStatus.OK);
	}
}
