package com.btt.service;


import java.sql.Date;

public interface employeeService {
	String getAllEmployees();

	String getEmployeeById(int id);
	String deleteEmployeeById(int id);

	String pInsertEmployee(
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
			);
	String pUpdateEmployee(int id,
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
			);
}

