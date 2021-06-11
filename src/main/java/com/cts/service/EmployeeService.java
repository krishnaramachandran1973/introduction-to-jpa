package com.cts.service;

import com.cts.entities.Employee;

public interface EmployeeService {
	Employee createEmployee(Long id, String name, Long salary);
	
	Employee findEmployee(Long id);

	void removeEmployee(Long id);
	
	Employee raiseSalary(Long id, Long raise);

}
