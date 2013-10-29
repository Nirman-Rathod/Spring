package com.spring.hibernate.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hibernate.dao.IEmployeeDao;
import com.spring.hibernate.model.Department;
import com.spring.hibernate.model.Employee;
import com.spring.hibernate.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	private static final Logger LOG = LoggerFactory
			.getLogger(EmployeeServiceImpl.class);

	@Autowired
	IEmployeeDao employeeDao;

	@Override
	@Transactional
	public void saveEmployee(Employee employee) {
		LOG.info("In Service");
		employeeDao.saveEmployee(employee);
	}

	@Override
	@Transactional
	public void saveEmployeeDept(int empId, Department dept) {
		LOG.info("In Service");
		employeeDao.saveEmployeeDept(empId, dept);
	}

	@Override
	@Transactional
	public Employee getEmployee(int empId) {
		LOG.info("In Service");
		Employee emp = employeeDao.getEmployee(empId);
		return emp;
	}

	@Override
	@Transactional
	public Department getEmployeeDept(int empId, int deptId) {
		LOG.info("In Service");
		Department dept = employeeDao.getEmployeeDept(empId, deptId);
		return dept;
	}

	@Override
	@Transactional
	public void updateEmployee(Employee employee, int empId) {
		LOG.info("In Service");
		employeeDao.updateEmployee(employee, empId);
	}

	@Override
	@Transactional
	public void updateEmployeeDept(int empId, Department dept, int deptId) {
		LOG.info("In Service");
		employeeDao.updateEmployeeDept(empId, dept, deptId);
	}

	@Override
	@Transactional
	public void deleteEmployee(int empId) {
		LOG.info("In Service");
		employeeDao.deleteEmployee(empId);
	}

	@Override
	@Transactional
	public void deleteEmployeeDept(int empId, int deptId) {
		LOG.info("In Service");
		employeeDao.deleteEmployeeDept(empId, deptId);

	}

}
