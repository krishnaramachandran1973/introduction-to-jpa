package com.cts.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cts.entities.Employee;
import com.cts.service.EmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EntityManager em;

	@Override
	public Employee createEmployee(String name, Long salary, String comments) {

		Employee employee = Employee.builder().name(name).salary(salary).comments(comments).build();
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

	@Override
	public List<Employee> findAllEmployees() {
		TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e", Employee.class);
		return query.getResultList();
	}

}
