package com.cts;

import java.util.stream.IntStream;

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

		IntStream.range(1, 10)
				.forEach(i -> employeeService.createEmployee("Krishna " + i, 10000l, "Joined as an Architect"));

		employeeService.findAllEmployees().forEach(emp1 -> System.out.println(emp1));
		transaction.commit();
	}

}
