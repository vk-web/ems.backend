package com.springjava.ems.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjava.ems.backend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
