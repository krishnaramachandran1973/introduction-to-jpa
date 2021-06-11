package com.cts.service.impl;

import javax.persistence.EntityManager;

import com.cts.entities.Employee;
import com.cts.service.EmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager em;

	@Override
	public Employee createEmployee(Long id, String name, Long salary) {

		Employee employee = Employee.builder().id(id).name(name).salary(salary).build();
		em.persist(employee);
		return employee;
	}

	@Override
	public void removeEmployee(Long id) {
		Employee employee = em.find(Employee.class, id);
		if (employee != null) {
			em.remove(employee);
		}
	}

	@Override
	public Employee raiseSalary(Long id, Long raise) {
		Employee employee = em.find(Employee.class, id);
		if (employee != null) {
			employee.setSalary(employee.getSalary() + raise);
		}
		return employee;
	}

	@Override
	public Employee findEmployee(Long id) {
		return em.find(Employee.class, id);
	}

}
