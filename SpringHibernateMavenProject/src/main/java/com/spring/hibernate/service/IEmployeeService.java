package com.spring.hibernate.service;

import com.spring.hibernate.model.Department;
import com.spring.hibernate.model.Employee;

public interface IEmployeeService {

	void saveEmployee(Employee employee);

	void saveEmployeeDept(int empId, Department dept);

	Employee getEmployee(int empId);

	Department getEmployeeDept(int empId, int deptId);

	void updateEmployee(Employee employee, int empId);

	void updateEmployeeDept(int empId, Department dept, int deptId);

	void deleteEmployee(int empId);

	void deleteEmployeeDept(int empId, int deptId);
	
}
