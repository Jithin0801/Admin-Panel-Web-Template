package com.btt.business;

import com.btt.service.custrequestService;
import com.btt.util.ApplicationContextProvider;

public class b_custrequest {
	
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
			int statusid) {
		custrequestService cs = ApplicationContextProvider.getBean("custrequestService", custrequestService.class);
		return cs.postcustrequest(
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
				);
	}

}
