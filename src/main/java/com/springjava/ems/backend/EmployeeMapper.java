package com.springjava.ems.backend;

import com.springjava.ems.backend.dto.EmployeeDto;
import com.springjava.ems.backend.entity.Employee;

public class EmployeeMapper {
	
	public static EmployeeDto mapToEmployeeDto(Employee emp) {
		return new EmployeeDto(
				emp.getId(),
				emp.getFirstName(),
				emp.getLastName(),
				emp.getEmail());
	}
	
	public static Employee mapToEmployee(EmployeeDto empDto) {
		return new Employee(
				empDto.getId(),
				empDto.getFirstName(),
				empDto.getLastName(),
				empDto.getEmail());
	}

}
