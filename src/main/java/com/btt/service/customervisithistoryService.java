package com.btt.service;

import java.util.Date;

public interface customervisithistoryService {

	String getAllCustomerVisitHistories();
	String getCustomerVisitHistoryById(int id);
	String pInsertCustomerVisitHistory(
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
			int status);
	
		String pUpdateCustomerVisitHistory(
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
			int status);

	String deleteCustomerVisitHistoryById(int id);
}


