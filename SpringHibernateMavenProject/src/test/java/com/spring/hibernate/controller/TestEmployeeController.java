package com.spring.hibernate.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.spring.hibernate.model.Employee;
import com.spring.hibernate.service.impl.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestEmployeeController {

	@Mock
	EmployeeServiceImpl mockService;

	@InjectMocks
	EmployeeController employeeController;

	private Employee employee;

	@Before
	public void setup() {
		employee = new Employee();
		setEmployee();
	}

	void setEmployee() {
		employee.setEmpId(1);
		employee.setfName("John");
		employee.setlName("Doe");
	}

	@Test
	public void getEmployeeTest() throws Exception {
		when(mockService.getEmployee(1)).thenReturn(employee);
		Employee emp = mockService.getEmployee(1);
		System.out.println("EmpId:" + emp.getEmpId());
		System.out.println("Emp Name:" + emp.getfName() +  " " + emp.getlName());
		
		verify(mockService).getEmployee(1);
		assertEquals("John",emp.getfName());
	}
	
	@Test(expected=Exception.class)
	public void getEmployeeFailureTest() throws Exception {
		when(mockService.getEmployee(10)).thenReturn(null);
		Employee emp = employeeController.getEmployee(10);
	}
}
