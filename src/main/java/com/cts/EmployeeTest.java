package com.cts;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cts.entities.Employee;
import com.cts.service.EmployeeService;
import com.cts.service.impl.EmployeeServiceImpl;

public class EmployeeTest {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
		EntityManager em = emf.createEntityManager();

		EntityTransaction transaction = em.getTransaction();

		EmployeeService employeeService = new EmployeeServiceImpl(em);

		transaction.begin();

		employeeService.createEmployee(1L, "Krishna", 10000L);
		System.out.println(employeeService.findEmployee(1L));
		
		Employee emp = employeeService.raiseSalary(1L, 1000L);
		System.out.println(emp);

		// employeeService.removeEmployee(1L);
		transaction.commit();
	}

}
