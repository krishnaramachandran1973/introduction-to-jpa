package com.cts.service;

import java.util.List;

import com.cts.entities.Employee;

public interface EmployeeService {
	Employee createEmployee(String name, Long salary, String comments);

	Employee findEmployee(Long id);

	void removeEmployee(Long id);

	Employee raiseSalary(Long id, Long raise);

	List<Employee> findAllEmployees();

}
