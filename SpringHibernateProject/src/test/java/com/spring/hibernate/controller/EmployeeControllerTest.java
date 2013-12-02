package com.spring.hibernate.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import com.spring.hibernate.dao.impl.EmployeeDaoImpl;
import com.spring.hibernate.model.Department;
import com.spring.hibernate.model.Employee;
import com.spring.hibernate.service.impl.EmployeeServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:WebContent/WEB-INF/spring-servlet.xml")
public class EmployeeControllerTest {

	@Mock
	EmployeeDaoImpl mockDao;

	@Autowired
	EmployeeController employeeController; 
	
	@InjectMocks
	EmployeeServiceImpl employeeService;
	
	private Employee employee;

	private Department department;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Before
	public void setup() {
		employeeController.setEmployeeService(employeeService);
		
		employee = new Employee();
		setEmployee();
		department = new Department();
		setDept();
	}

	void setEmployee() {
		employee.setEmpId(1);
		employee.setfName("John");
		employee.setlName("Doe");
	}

	void setDept() {
		department.setDeptId(1);
		department.setDeptName("IDM");
		department.setLocation("india");
	}

	@Test
	public void getEmployeeTest() throws Exception {
		when(mockDao.getEmployee(1)).thenReturn(employee);
		Employee emp1 = employeeController.getEmployee(1);
		assertEquals(employee, emp1);
	}

	@Test(expected = Exception.class)
	public void getEmployeeFailureTest() throws Exception {
		when(mockDao.getEmployee(10)).thenReturn(null);
		Employee emp = employeeController.getEmployee(10);
	}

	@Test
	public void getEmployeeDeptTest() throws Exception {
		when(mockDao.getEmployeeDept(1, 1)).thenReturn(department);
		Department dept1 = employeeController.getEmployeeDepartment(1, 1);
		assertEquals(department, dept1);
	}

	@Test(expected = Exception.class)
	public void getEmployeeDeptFailureTest() throws Exception {
		when(mockDao.getEmployeeDept(1, 10)).thenReturn(null);
		Department dept = employeeController.getEmployeeDepartment(1, 10);
	}

	@Test
	public void saveEmployeeTest() {
		employeeController.saveEmployee(employee);
		verify(mockDao).saveEmployee(employee);
	}

	@Test
	public void saveEmployeeDeptTest() {
		employeeController.saveEmployeeDepartment(department, 1);
		verify(mockDao).saveEmployeeDept(1, department);
	}

	@Test
	public void updateEmployeeTest() {
		employeeController.updateEmployee(employee, 1);
		verify(mockDao).updateEmployee(employee, 1);
	}

	@Test
	public void updateEmployeeDeptTest() {
		employeeController.updateEmployeeDepartment(department, 1, 1);
		verify(mockDao).updateEmployeeDept(1, department, 1);
	}

	@Test
	public void deleteEmployeeTest() {
		employeeController.deleteEmployee(1);
		verify(mockDao).deleteEmployee(1);
	}

	@Test
	public void deleteEmployeeDeptTest() {
		employeeController.deleteEmployeeDept(1, 1);
		verify(mockDao).deleteEmployeeDept(1, 1);
	}

	@Test
	public void gettregisterEmployeePageTest() {
		String response = employeeController.getregisterEmployeePage();
		assertEquals("home", response);
	}

	@Test
	public void getemployeeDetailsPageTest() {
		String response = employeeController.getemployeeDetailsPage();
		assertEquals("empdetails", response);
	}

	@Test
	public void getaddEmployeeDeptPageTest() {
		String response = employeeController.getaddEmployeeDeptPage();
		assertEquals("addDept", response);
	}

	@Test
	public void getdeptDetailsPageTest() {
		String response = employeeController.getdeptDetailsPage();
		assertEquals("deptdetails", response);
	}

	@Test
	public void getempDetailsUpdatePageTest() {
		String response = employeeController.getempDetailsUpdatePage();
		assertEquals("empUpdtDetails", response);
	}
}
