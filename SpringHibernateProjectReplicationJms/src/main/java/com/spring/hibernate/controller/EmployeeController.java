package com.spring.hibernate.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.hibernate.model.Department;
import com.spring.hibernate.model.Employee;
import com.spring.hibernate.service.IEmployeeService;

@Controller
public class EmployeeController {
	private static final Logger LOG = LoggerFactory
			.getLogger(EmployeeController.class);

	@Autowired
	IEmployeeService employeeService;

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	@ResponseBody
	String saveEmployee(@RequestBody Employee employee,
			HttpServletResponse response) {
		LOG.info("Request to save new employee empName:" + employee.getfName());
		employeeService.saveEmployee(employee);
		return "{\"data\":\"Employee saved successfully\"}";
	}

	@RequestMapping(value = "/employee/{empId}/dept", method = RequestMethod.POST)
	@ResponseBody
	String saveEmployeeDepartment(@RequestBody Department dept,
			@PathVariable("empId") int empId) {
		LOG.info("Request to save department for employee Id:" + empId);
		employeeService.saveEmployeeDept(empId, dept);
		return "Department Details saved successfully";
	}

	@RequestMapping(value = "/employee/{empId}", method = RequestMethod.GET)
	@ResponseBody
	Employee getEmployee(@PathVariable("empId") int empId) {
		LOG.info("Request to get employee by ID:" + empId);
		Employee emp = employeeService.getEmployee(empId);
		return emp;
	}

	@RequestMapping(value = "/employee/{empId}/dept/{deptId}", method = RequestMethod.GET)
	@ResponseBody
	Department getEmployeeDepartment(@PathVariable("empId") int empId,
			@PathVariable("deptId") int deptId) {
		LOG.info("Request to get employee by ID:" + empId);
		Department dept = employeeService.getEmployeeDept(empId, deptId);
		return dept;
	}

	@RequestMapping(value = "/employee/{empId}", method = RequestMethod.POST)
	@ResponseBody
	String updateEmployee(@RequestBody Employee employee,
			@PathVariable("empId") int empId) {
		employeeService.updateEmployee(employee, empId);
		LOG.info(
				"Request to update employee by ID: {} New Employee request details: empName: {}",
				empId, employee.getfName());
		return "Employee Details updated successfully";
	}

	@RequestMapping(value = "/employee/{empId}/dept/{deptId}", method = RequestMethod.POST)
	@ResponseBody
	String updateEmployeeDepartment(@RequestBody Department dept,
			@PathVariable("empId") int empId, @PathVariable("deptId") int deptId) {
		employeeService.updateEmployeeDept(empId, dept, deptId);
		LOG.info(
				"Request to update Department details for employee ID:{} New Department request details: deptName:{}",
				empId, dept.getDeptName());
		return "Department Details updated successfully";
	}

	@RequestMapping(value = "/employee/{empId}", method = RequestMethod.DELETE)
	@ResponseBody
	String deleteEmployee(@PathVariable("empId") int empId) {
		LOG.info("Request to delete employee by ID: {} ", empId);
		employeeService.deleteEmployee(empId);
		return "Employee " + empId + " deleted Successfully";
	}

	@RequestMapping(value = "/employee/{empId}/dept/{deptId}", method = RequestMethod.DELETE)
	@ResponseBody
	String deleteEmployeeDept(@PathVariable("empId") int empId,
			@PathVariable("deptId") int deptId) {
		LOG.info("Request to delete department details for employee ID:{}",
				empId);
		employeeService.deleteEmployeeDept(empId, deptId);
		return "Department details for Employee " + empId
				+ " deleted Successfully";
	}

	@RequestMapping(value = "registerEmployeePage", method = RequestMethod.GET)
	String getregisterEmployeePage() {
		return "home";
	}

	@RequestMapping(value = "employeeDetailsPage", method = RequestMethod.GET)
	String getemployeeDetailsPage() {
		return "empdetails";
	}

	@RequestMapping(value = "addEmployeeDeptPage", method = RequestMethod.GET)
	String getaddEmployeeDeptPage() {
		return "addDept";
	}

	@RequestMapping(value = "deptDetailsPage", method = RequestMethod.GET)
	String getdeptDetailsPage() {
		return "deptdetails";
	}

	@RequestMapping(value = "empDetailsUpdatePage", method = RequestMethod.GET)
	String getempDetailsUpdatePage() {
		return "empUpdtDetails";
	}
}
