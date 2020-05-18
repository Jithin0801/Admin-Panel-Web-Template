package com.btt.controller;


import java.sql.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btt.business.b_employee;

@RestController
@RequestMapping("/api")
public class employeecontroller {
	
	@RequestMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	public String getAllEmployees() {
		return new b_employee().getAllEmployees();
	}
	
	@RequestMapping(value = "/employeebyid", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	public String getEmployeeById(@RequestParam("id") int id) {
		return new b_employee().getEmployeeById(id);
	}
	
	@RequestMapping(value = "/deleteemployee", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	public String deleteEmployeeById(@RequestParam("id") int id) {
		return new b_employee().deleteEmployeeById(id);
	}
	
	
	@RequestMapping(value = "/addemployee", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	public String pInsertEmployee(
			@RequestParam("employeename")  String employeename,
			@RequestParam("employeedob")  Date employeedob,
			@RequestParam("employeegenderid")  int employeegenderid,
			@RequestParam("employeecontactnumber")  String employeecontactnumber, 
			@RequestParam("employeeemail")  String employeeemail,
			@RequestParam("employeeaddress1")  String employeeaddress1,
			@RequestParam("employeeaddress2")  String employeeaddress2,
			@RequestParam("employeecityid")  int employeecityid,
			@RequestParam("employeestateid")  int employeestateid,
			@RequestParam("employeelandmark")  String employeelandmark,
			@RequestParam("employeedoj")  Date employeedoj,
			@RequestParam("designationid")  int designationid,
			@RequestParam("maindivisionid")  int maindivisionid,
			@RequestParam("divisionid")  int divisionid,
			@RequestParam("createdby")  String createdby,
			@RequestParam("createdat")  Date createdat,
			@RequestParam("modifiedby")  String modifiedby,
			@RequestParam("modifiedat")  Date modifiedat,
			@RequestParam("statusid")  int statusid
			)
	{
		return new b_employee().pInsertEmployee(
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
	
	@RequestMapping(value = "/modifyemployee", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	public String pUpdateEmployee(
			@RequestParam("id")  int id,
			@RequestParam("employeename")  String employeename,
			@RequestParam("employeedob")  Date employeedob,
			@RequestParam("employeegenderid")  int employeegenderid,
			@RequestParam("employeecontactnumber")  String employeecontactnumber, 
			@RequestParam("employeeemail")  String employeeemail,
			@RequestParam("employeeaddress1")  String employeeaddress1,
			@RequestParam("employeeaddress2")  String employeeaddress2,
			@RequestParam("employeecityid")  int employeecityid,
			@RequestParam("employeestateid")  int employeestateid,
			@RequestParam("employeelandmark")  String employeelandmark,
			@RequestParam("employeedoj")  Date employeedoj,
			@RequestParam("designationid")  int designationid,
			@RequestParam("maindivisionid")  int maindivisionid,
			@RequestParam("divisionid")  int divisionid,
			@RequestParam("createdby")  String createdby,
			@RequestParam("createdat")  Date createdat,
			@RequestParam("modifiedby")  String modifiedby,
			@RequestParam("modifiedat")  Date modifiedat,
			@RequestParam("statusid")  int statusid
			) 
	{
		return new b_employee().pUpdateEmployee(
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
