package com.btt.business;

import java.sql.Date;

import com.btt.service.employeeService;
import com.btt.util.ApplicationContextProvider;

public class b_employee {

	public String getAllEmployees() {

		employeeService es = ApplicationContextProvider.getBean("employeeService", employeeService.class);
		return es.getAllEmployees();
	}

	public String getEmployeeById(int id) {

		employeeService es = ApplicationContextProvider.getBean("employeeService", employeeService.class);
		return es.getEmployeeById(id);
	}
	
	public String deleteEmployeeById(int id) {

		employeeService es = ApplicationContextProvider.getBean("employeeService", employeeService.class);
		return es.deleteEmployeeById(id);
	}
	
	public String pInsertEmployee(
			String employeename,
			Date employeedob,
			int employeegenderid,
			String employeecontactnumber,
			String employeeemail,
			String employeeaddress1,
			String employeeaddress2,
			int employeecityid,
			int employeestateid,
			String employeelandmark,
			Date employeedoj,
			int designationid,
			int maindivisionid,
			int divisionid,
			String createdby,
			Date createdat,
			String modifiedby,
			Date modifiedat,
			int statusid
			) {

		employeeService es = ApplicationContextProvider.getBean("employeeService", employeeService.class);
		return es.pInsertEmployee(
				employeename,
				employeedob,
				employeegenderid,
				employeecontactnumber,
				employeeemail,
				employeeaddress1,
				employeeaddress2,
				employeecityid,
				employeestateid,
				employeelandmark,
				employeedoj,
				designationid,
				maindivisionid,
				divisionid,
				createdby,
				createdat,
				modifiedby,
				modifiedat,
				statusid
				);
	}
	public String pUpdateEmployee(
			int id,
			String employeename,
			Date employeedob,
			int employeegenderid,
			String employeecontactnumber,
			String employeeemail,
			String employeeaddress1,
			String employeeaddress2,
			int employeecityid,
			int employeestateid,
			String employeelandmark,
			Date employeedoj,
			int designationid,
			int maindivisionid,
			int divisionid,
			String createdby,
			Date createdat,
			String modifiedby,
			Date modifiedat,
			int statusid
			) {
		employeeService es = ApplicationContextProvider.getBean("employeeService", employeeService.class);
		return es.pUpdateEmployee(
				id,
				employeename,
				employeedob,
				employeegenderid,
				employeecontactnumber,
				employeeemail,
				employeeaddress1,
				employeeaddress2,
				employeecityid,
				employeestateid,
				employeelandmark,
				employeedoj,
				designationid,
				maindivisionid,
				divisionid,
				createdby,
				createdat,
				modifiedby,
				modifiedat,
				statusid
				);
	}
}
