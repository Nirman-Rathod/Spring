package com.spring.hibernate.dao;

import com.spring.hibernate.model.Department;
import com.spring.hibernate.model.Employee;

public interface IEmployeeDao {
	
	void saveEmployee(Employee emp);

	Employee getEmployee(int empId);

	void updateEmployee(Employee employee, int empId);

	void deleteEmployee(int empId);

	Department getEmployeeDept(int empId, int deptId);

	void saveEmployeeDept(int empId, Department dept);

	void updateEmployeeDept(int empId, Department dept, int deptId);

	void deleteEmployeeDept(int empId, int deptId);

}
