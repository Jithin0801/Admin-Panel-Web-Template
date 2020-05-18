package com.btt.business;

import java.util.Date;

import com.btt.service.customervisithistoryService;

import com.btt.util.ApplicationContextProvider;

public class b_customervisithistory {
	public String getAllCustomerVisitHistories() {

		customervisithistoryService vs = ApplicationContextProvider.getBean("customervisithistoryService", customervisithistoryService.class);
		return vs.getAllCustomerVisitHistories();
	}
	public String getCustomerVisitHistoryById(int id) {

		customervisithistoryService vs = ApplicationContextProvider.getBean("customervisithistoryService", customervisithistoryService.class);
		return vs.getCustomerVisitHistoryById(id);
	}
	
	public String deleteCustomerVisitHistoryById(int id) {

		customervisithistoryService vs = ApplicationContextProvider.getBean("customervisithistoryService", customervisithistoryService.class);
		return vs.deleteCustomerVisitHistoryById(id);
	}
	
	public String pInsertCustomerVisitHistory(
			int customerid,
			int employeeid,
			int productid,
			String productname,
			int custresponseid,
			int leadstatusid,
			Date lastvisitdate,
			int createdby,
			Date createdat,
			String modifiedby,
			Date modifiedat,
			int status) {

		customervisithistoryService vs = ApplicationContextProvider.getBean("customervisithistoryService",customervisithistoryService.class);
		return vs.pInsertCustomerVisitHistory( 
				customerid,
				 employeeid,
				 productid,
				productname,
				custresponseid,
				leadstatusid,
				lastvisitdate,
				createdby,
				createdat,
				modifiedby,
				modifiedat,
				status);
	}
	
	public String pUpdateCustomerVisitHistory(
			int id,
			int customerid,
			int employeeid,
			int productid,
			String productname,
			int custresponseid,
			int leadstatusid,
			Date lastvisitdate,
			int createdby,
			Date createdat,
			String modifiedby,
			Date modifiedat,
			int status) {
		customervisithistoryService vs = ApplicationContextProvider.getBean("customervisithistoryService",customervisithistoryService.class);
		return vs.pUpdateCustomerVisitHistory( 
				id,
				customerid,
				 employeeid,
				 productid,
				productname,
				custresponseid,
				leadstatusid,
				lastvisitdate,
				createdby,
				createdat,
				modifiedby,
				modifiedat,
				status);
	}
	
	
	
}
