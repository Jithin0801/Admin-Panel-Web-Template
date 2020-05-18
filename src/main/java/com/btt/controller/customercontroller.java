package com.btt.controller;



import java.sql.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.btt.business.b_customer;



@RestController
@RequestMapping("/api")
public class   customercontroller {

	@RequestMapping(value="/customers",produces = MediaType.APPLICATION_JSON_VALUE,
		    method = RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	public String getAllCustomer() {		
		return new b_customer().getAllCustomer();
	}
	@RequestMapping(value="/customerbyid",produces = MediaType.APPLICATION_JSON_VALUE,
		    method = RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	public String getCustomerById(@RequestParam("id")int id ) {		
		return new b_customer().getCustomerById(id);
	}
	@RequestMapping(value="/customerbystatuid",produces = MediaType.APPLICATION_JSON_VALUE,
		    method = RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	public String getCustomerByStatusId(@RequestParam("statusid")int statusid ) {		
		return new b_customer().getCustomerByStatusId(statusid);
	}
	@RequestMapping(value="/deletecustomer",produces = MediaType.APPLICATION_JSON_VALUE,
		    method = RequestMethod.DELETE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	public String deleteCustomerById(@RequestParam("id")int id ) {		
		return new b_customer().deleteCustomerById(id);
	}
	@RequestMapping(value = "/modifycustomer",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.PUT)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	public String updateCustomer(
			@RequestParam("id") int id,
			@RequestParam("customerfirstname") String customerfirstname,
			@RequestParam("customerlastname") String customerlastname,
			@RequestParam("customercontactnumber") String customercontactnumber,
			@RequestParam("customeremailid") String customeremailid,
			@RequestParam("customeraddress1") String customeraddress1,
			@RequestParam("customeraddress2") String customeraddress2,
			@RequestParam("customercityid") int customercityid,
			@RequestParam("customerstateid") int customerstateid,
			@RequestParam("customercountryid") int customercountryid,
			@RequestParam("customerlandmark") String customerlandmark,
			@RequestParam("contactpersonname") String contactpersonname,
			@RequestParam("companyname") String companyname,
			@RequestParam("companyphonenumber") String companyphonenumber,
			@RequestParam("companyaddress1") String companyaddress1,
			@RequestParam("companyaddress2") String companyaddress2,
			@RequestParam("companycityid") int companycityid,
			@RequestParam("companystateid") int companystateid,
			@RequestParam("companycountryid") int companycountryid,
			@RequestParam("gstnumber") String gstnumber,
			@RequestParam("website") String website,
			@RequestParam("maindivisionid") int maindivisionid,
			@RequestParam("divisionid") int divisionid,
			@RequestParam("createdby") String createdby,
			@RequestParam("createdat") Date createdat,
			@RequestParam("modifiedby") String modifiedby,
			@RequestParam("modifiedat") Date modifiedat,
			@RequestParam("statusid") int statusid,
			@RequestParam("statusid") int employeeid)
	{
		return new b_customer().updateCustomer(
				id,
				customerfirstname,
				customerlastname,
				customercontactnumber,
				customeremailid,
				customeraddress1,
				customeraddress2,
				customercityid,
				customerstateid,
				customercountryid,
				customerlandmark,
				contactpersonname,
				companyname,
				companyphonenumber,
				companyaddress1,
				companyaddress2,
				companycityid,
				companystateid,
				companycountryid,
				gstnumber,
				website,
				maindivisionid,
				divisionid,
				createdby,
				createdat,
				modifiedby,
				modifiedat,
				statusid,
				employeeid
				);}


	@RequestMapping(value = "/addcustomer",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	public String postCustomer(
			@RequestParam("customerfirstname") String customerfirstname,
			@RequestParam("customerlastname") String customerlastname,
			@RequestParam("customercontactnumber") String customercontactnumber,
			@RequestParam("customeremailid") String customeremailid,
			@RequestParam("customeraddress1") String customeraddress1,
			@RequestParam("customeraddress2") String customeraddress2,
			@RequestParam("customercityid") int customercityid,
			@RequestParam("customerstateid") int customerstateid,
			@RequestParam("customercountryid") int customercountryid,
			@RequestParam("customerlandmark") String customerlandmark,
			@RequestParam("contactpersonname") String contactpersonname,
			@RequestParam("companyname") String companyname,
			@RequestParam("companyphonenumber") String companyphonenumber,
			@RequestParam("companyaddress1") String companyaddress1,
			@RequestParam("companyaddress2") String companyaddress2,
			@RequestParam("companycityid") int companycityid,
			@RequestParam("companystateid") int companystateid,
			@RequestParam("companycountryid") int companycountryid,
			@RequestParam("gstnumber") String gstnumber,
			@RequestParam("website") String website,
			@RequestParam("maindivisionid") int maindivisionid,
			@RequestParam("divisionid") int divisionid,
			@RequestParam("createdby") String createdby,
			@RequestParam("createdat") Date createdat,
			@RequestParam("modifiedby") String modifiedby,
			@RequestParam("modifiedat") Date modifiedat,
			@RequestParam("statusid") int statusid,
			@RequestParam("statusid") int employeeid

			) 
	{
		
		return  new b_customer().postCustomer(
				customerfirstname,
				customerlastname,
				customercontactnumber,
				customeremailid,
				customeraddress1,
				customeraddress2,
				customercityid,
				customerstateid,
				customercountryid,
				customerlandmark,
				contactpersonname,
				companyname,
				companyphonenumber,
				companyaddress1,
				companyaddress2,
				companycityid,
				companystateid,
				companycountryid,
				gstnumber,
				website,
				maindivisionid,
				divisionid,
				createdby,
				createdat,
				modifiedby,
				modifiedat,
				statusid,
				employeeid
				);}

	@RequestMapping(value = "/addcustomerrequest",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	public String postCustomerRequest(
			@RequestParam("customerfirstname") String customerfirstname,
			@RequestParam("customerlastname") String customerlastname,
			@RequestParam("customercontactnumber") String customercontactnumber,
			@RequestParam("customeremailid") String customeremailid,
			@RequestParam("customeraddress1") String customeraddress1,
			@RequestParam("customeraddress2") String customeraddress2,
			@RequestParam("customercityid") int customercityid,
			@RequestParam("customerstateid") int customerstateid,
			@RequestParam("customercountryid") int customercountryid,
			@RequestParam("customerlandmark") String customerlandmark,
			@RequestParam("contactpersonname") String contactpersonname,
			@RequestParam("companyname") String companyname,
			@RequestParam("companyphonenumber") String companyphonenumber,
			@RequestParam("companyaddress1") String companyaddress1,
			@RequestParam("companyaddress2") String companyaddress2,
			@RequestParam("companycityid") int companycityid,
			@RequestParam("companystateid") int companystateid,
			@RequestParam("companycountryid") int companycountryid,
			@RequestParam("gstnumber") String gstnumber,
			@RequestParam("website") String website,
			@RequestParam("maindivisionid") int maindivisionid,
			@RequestParam("divisionid") int divisionid,
			@RequestParam("createdby") String createdby,
			@RequestParam("createdat") Date createdat,
			@RequestParam("modifiedby") String modifiedby,
			@RequestParam("modifiedat") Date modifiedat,
			@RequestParam("statusid") int statusid,
			@RequestParam("statusid") int employeeid)

	{
		
		return  new b_customer().postCustomerRequest(
				customerfirstname,
				customerlastname,
				customercontactnumber,
				customeremailid,
				customeraddress1,
				customeraddress2,
				customercityid,
				customerstateid,
				customercountryid,
				customerlandmark,
				contactpersonname,
				companyname,
				companyphonenumber,
				companyaddress1,
				companyaddress2,
				companycityid,
				companystateid,
				companycountryid,
				gstnumber,
				website,
				maindivisionid,
				divisionid,
				createdby,
				createdat,
				modifiedby,
				modifiedat,
				statusid,
				employeeid
				);}
}
