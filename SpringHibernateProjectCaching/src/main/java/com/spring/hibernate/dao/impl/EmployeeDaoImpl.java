package com.spring.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.hibernate.dao.IEmployeeDao;
import com.spring.hibernate.model.Department;
import com.spring.hibernate.model.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

	private static final Logger LOG = LoggerFactory
			.getLogger(EmployeeDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveEmployee(Employee emp) {
		LOG.info("In Dao, request to add new employee details into the database empName:{}",emp.getfName());
		sessionFactory.getCurrentSession().save(emp);
		LOG.info("Employee Details saved successfully in DB");
	}

	@Override
	public Employee getEmployee(int empId) {
		LOG.info("In Dao, request to fetch employee details for employee Id:{}",empId);
		Employee emp = (Employee) sessionFactory.getCurrentSession().get(Employee.class, empId);
		List<Department> depts = new ArrayList<Department>();
		int size = emp.getListOfDepts().size();
		for(int i=0;i<size;i++){
			depts.add(emp.getListOfDepts().get(i));
		}
		emp.setListOfDepts(depts);
		LOG.info("Employee Details retrieved successfully from DB");
		return emp;
	}


	@Override
	public void updateEmployee(Employee employee, int empId) {
		LOG.info("In Dao, reequest to update employee details Id: {}",empId);
		Employee emp = (Employee)sessionFactory.getCurrentSession().get(Employee.class, empId);
		emp.setfName(employee.getfName());
		emp.setlName(employee.getlName());
		LOG.debug("Employee Details updated successfully from DB");
	}

	@Override
	public void deleteEmployee(int empId) {
		LOG.info("In Dao, reequest to delete employee details Id: {}",empId);
		Session session = sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.get(Employee.class, empId);
		session.delete(emp);
		LOG.debug("Employee Details deleted successfully from DB");
	}

	@Override
	public Department getEmployeeDept(int empId,int deptId) {
		LOG.info("In Dao, Request to fetch Dept details deptId:{} for employee Id:{}",deptId,empId);
		Employee emp = (Employee) sessionFactory.getCurrentSession().get(Employee.class, empId);
		List<Department> depts = emp.getListOfDepts();
		Department dept = depts.get(deptId-1);
		LOG.debug("Employee Details retrieved successfully from DB");
		return dept;
	}

	@Override
	public void saveEmployeeDept(int empId, Department dept) {
		LOG.info("In Dao, Request to save new Department de");
		Session session = sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.get(Employee.class, empId);
		List<Department> depts = emp.getListOfDepts();
		session.save(dept);
		depts.add(dept);
		LOG.info("Deparment Details successfully added into DB");
	}

	
	@Override
	public void updateEmployeeDept(int empId, Department dept,int deptId) {
		LOG.info("In Dao, Request to update Dept details deptId:{} for employee Id:{}",deptId,empId);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee emp = (Employee) session.get(Employee.class, empId);
		session.save(dept);
		emp.getListOfDepts().set(deptId-1, dept);
		LOG.info("Department Details updated successfully in DB");
	}

	@Override
	public void deleteEmployeeDept(int empId, int deptId) {
		LOG.info("In Dao, Request to delete Dept details deptId:{} for employee Id:{}",deptId,empId);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee emp = (Employee) session.get(Employee.class, empId);
		session.delete(emp.getListOfDepts().remove(deptId-1));
		LOG.info("Department Details deleted successfully from DB");
	}

}
