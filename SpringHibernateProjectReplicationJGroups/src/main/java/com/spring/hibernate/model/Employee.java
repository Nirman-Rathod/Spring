package com.spring.hibernate.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int empId;
	private String fName;
	private String lName;
	
	@OneToMany
	@ElementCollection(fetch=FetchType.EAGER)
	private List<Department> listOfDepts;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public List<Department> getListOfDepts() {
		return listOfDepts;
	}

	public void setListOfDepts(List<Department> listOfDepts) {
		this.listOfDepts = listOfDepts;
	}

}
