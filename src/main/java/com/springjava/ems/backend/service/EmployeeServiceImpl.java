 package com.springjava.ems.backend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springjava.ems.backend.EmployeeMapper;
import com.springjava.ems.backend.dto.EmployeeDto;
import com.springjava.ems.backend.entity.Employee;
import com.springjava.ems.backend.exception.ResourceNotFoundException;
import com.springjava.ems.backend.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDto createEmployee(EmployeeDto empDto) {
		Employee emp = EmployeeMapper.mapToEmployee(empDto);
		Employee savedEmp = employeeRepository.save(emp);
		return EmployeeMapper.mapToEmployeeDto(savedEmp);
	}

	@Override
	public EmployeeDto getEmployeeById(Long empId) {
		Employee emp = employeeRepository.findById(empId)
				.orElseThrow(() -> 
				new ResourceNotFoundException("Employee does not exist with given id : "+empId));
					
		return EmployeeMapper.mapToEmployeeDto(emp);
	}

	@Override
	public List<EmployeeDto> getAllEmp() {
		List<Employee> allEmp = employeeRepository.findAll();
		return allEmp.stream().map((e)-> EmployeeMapper.mapToEmployeeDto(e))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long empId, EmployeeDto empDto) {
		Employee emp = employeeRepository.findById(empId)
								.orElseThrow(()-> 
							new ResourceNotFoundException("Employee does not exist with given id : "+empId));
		emp.setFirstName(empDto.getFirstName());
		emp.setLastName(empDto.getLastName());
		emp.setEmail(empDto.getEmail());
		Employee updtedEmp=employeeRepository.save(emp);
		
		return EmployeeMapper.mapToEmployeeDto(updtedEmp);
	}

	@Override
	public void deleteEmployee(Long empId) {
		Employee emp = employeeRepository.findById(empId)
					.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with given id : "+empId));
		employeeRepository.deleteById(empId);
	}

}
