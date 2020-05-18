package com.btt.business;

import java.sql.Date;

import com.btt.service.customerService;
import com.btt.util.ApplicationContextProvider;

public class b_customer {

	public String getAllCustomer() {
		customerService cs = ApplicationContextProvider.getBean("customerService", customerService.class);
		return cs.getAllCustomer();
	}
	public String getCustomerById(int id) {
		customerService cs = ApplicationContextProvider.getBean("customerService", customerService.class);
		return cs.getCustomerById(id);
	}
	public String getCustomerByStatusId(int statusid) {
		customerService cs = ApplicationContextProvider.getBean("customerService", customerService.class);
		return cs.getCustomerByStatusId(statusid);
	}
	public String deleteCustomerById(int id) {
		customerService cs = ApplicationContextProvider.getBean("customerService", customerService.class);
		return cs.deleteCustomerById(id);
	}
	public String updateCustomer(
			int id, 
			String customerfirstname,
			String customerlastname, 
			String customercontactnumber,
			String customeremailid,
			String customeraddress1,
			String customeraddress2,
			int customercityid, 
			int customerstateid,
			int customercountryid, 
			String customerlandmark, 
			String contactpersonname, 
			String companyname,
			String companyphonenumber, 
			String companyaddress1,
			String companyaddress2, 
			int companycityid, 
			int companystateid,
			int companycountryid, 
			String gstnumber, 
			String website, 
			int maindivisionid, 
			int divisionid,
			String createdby, 
			Date createdat, 
			String modifiedby,
			Date modifiedat,
			int statusid,
			int employeeid
			){
		customerService cs = ApplicationContextProvider.getBean("customerService", customerService.class);
		return cs.updateCustomer(
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
				);
	}
	public String postCustomer(
			String customerfirstname,
			String customerlastname,
			String customercontactnumber,
			String customeremailid,
			String customeraddress1,
			String customeraddress2,
			int customercityid,
			int customerstateid,
			int customercountryid,
			String customerlandmark,
			String contactpersonname,
			String companyname,
			String companyphonenumber,
			String companyaddress1,
			String companyaddress2,
			int companycityid,
			int companystateid,
			int companycountryid,
			String gstnumber,
			String website,
			int maindivisionid,
			int divisionid,
			String createdby,
			Date createdat,
			String modifiedby,
			Date modifiedat,
			int statusid,
			int employeeid) {
		customerService cs = ApplicationContextProvider.getBean("customerService", customerService.class);
		return cs.postCustomer(
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
				);
	}
	public String postCustomerRequest(
			String customerfirstname,
			String customerlastname,
			String customercontactnumber,
			String customeremailid,
			String customeraddress1,
			String customeraddress2,
			int customercityid,
			int customerstateid,
			int customercountryid,
			String customerlandmark,
			String contactpersonname,
			String companyname,
			String companyphonenumber,
			String companyaddress1,
			String companyaddress2,
			int companycityid,
			int companystateid,
			int companycountryid,
			String gstnumber,
			String website,
			int maindivisionid,
			int divisionid,
			String createdby,
			Date createdat,
			String modifiedby,
			Date modifiedat,
			int statusid,
			int employeeid
			)
	{
		customerService cs = ApplicationContextProvider.getBean("customerService", customerService.class);
		return cs.postCustomerRequest(
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
				);
	
	}

}
