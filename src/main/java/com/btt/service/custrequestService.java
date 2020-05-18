package com.btt.service;

public interface custrequestService {
	public String postcustrequest(
			String custfirstname,
			String custlastname,
			String custcontactnumber,
			String custemailid,
			String custaddress,
			int custcityid,
			int custstateid,
			int custcountryid,
			String custlandmark,
			String contactpersonname,
			String companyname,
			String companyphonenumber,
			String companyaddress,
			int companycityid,
			int companystateid,
			int companycountryid,
			String gstnumber,
			String website,
			int maindivisionid,
			int divisionid,
			String createdby,
			int statusid);
}
