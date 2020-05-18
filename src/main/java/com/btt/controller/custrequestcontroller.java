package com.btt.controller;



import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btt.business.b_custrequest;

@RestController
@RequestMapping("/api")
public class custrequestcontroller {
	@RequestMapping(value = "/addcustrequest",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	public String postcustrequest(
			@RequestParam("custfirstname") String custfirstname,
			@RequestParam("custlastname") String custlastname,
			@RequestParam("custcontactnumber") String custcontactnumber,
			@RequestParam("custemailid") String custemailid,
			@RequestParam("custaddress") String custaddress,
			
			@RequestParam("custcityid") int custcityid,
			@RequestParam("custstateid") int custstateid,
			@RequestParam("custcountryid") int custcountryid,
			@RequestParam("custlandmark") String custlandmark,
			@RequestParam("contactpersonname") String contactpersonname,
			@RequestParam("companyname") String companyname,
			@RequestParam("companyphonenumber") String companyphonenumber,
			@RequestParam("companyaddress") String companyaddress,
			
			@RequestParam("companycityid") int companycityid,
			@RequestParam("companystateid") int companystateid,
			@RequestParam("companycountryid") int companycountryid,
			@RequestParam("gstnumber") String gstnumber,
			@RequestParam("website") String website,
			@RequestParam("maindivisionid") int maindivisionid,
			@RequestParam("divisionid") int divisionid,
			@RequestParam("createdby") String createdby,
			@RequestParam("statusid") int statusid) 
	{
		
		return  new b_custrequest().postcustrequest(
				custfirstname,
				custlastname,
				custcontactnumber,
				custemailid,
				custaddress,
				custcityid,
				custstateid,
				custcountryid,
				custlandmark,
				contactpersonname,
				companyname,
				companyphonenumber,
				companyaddress,
				companycityid,
				companystateid,
				companycountryid,
				gstnumber,
				website,
				maindivisionid,
				divisionid,
				createdby,
				statusid
				);}

}
