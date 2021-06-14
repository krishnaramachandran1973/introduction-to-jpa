package com.cts.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//@NamedQuery(name="findEmployee", "SELECT e FROM Employee e")

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	// @TableGenerator(name = "Emp_Gen", table = "ID_GEN", pkColumnName =
	// "EMP_GEN", valueColumnName = "GEN_VALUE", initialValue = 100,
	// allocationSize = 200)
	// @GeneratedValue(strategy = GenerationType.TABLE, generator = "Emp_Gen")
	// @SequenceGenerator(name = "Seq_Gen", initialValue = 100, allocationSize =
	// 100)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_ID")
	private Long id;

	@NonNull
	private String name;

	@NonNull
	@Column(name = "SAL")
	private Long salary;

	@NonNull
	@Basic(fetch = FetchType.LAZY)
	private String comments;

}