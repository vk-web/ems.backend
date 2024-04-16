package com.springjava.ems.backend.service;

import java.util.List;

import com.springjava.ems.backend.dto.EmployeeDto;

public interface EmployeeService {
	
	EmployeeDto createEmployee(EmployeeDto empDto);
	
	EmployeeDto getEmployeeById(Long empId);
	
	List<EmployeeDto> getAllEmp();
	
	EmployeeDto updateEmployee(Long empId, EmployeeDto empDto);
	
	void deleteEmployee(Long empId);

}
