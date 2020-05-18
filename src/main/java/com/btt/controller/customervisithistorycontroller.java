package com.btt.controller;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btt.business.b_customervisithistory;


@RestController
@RequestMapping("/api")
public class customervisithistorycontroller {
	@RequestMapping(value = "/visithistory", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
		public String getAllCustomeriVsitHistories() {
			return new b_customervisithistory().getAllCustomerVisitHistories();
		}
	@RequestMapping(value = "/visithistorybyid", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public String getCustomerVisitHistoryById(@RequestParam("id") int id) {
		return new b_customervisithistory().getCustomerVisitHistoryById(id);
	}
	
	@RequestMapping(value = "/deletehistory", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	public String deleteCustomerVisitHistoryById(@RequestParam("id") int id) {
		return new b_customervisithistory().deleteCustomerVisitHistoryById(id);
	}
	
	
	@RequestMapping(value = "/addvisithistory", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public String pInsertCustomerVisitHistory(
			@RequestParam("customerid")int customerid,
			@RequestParam("employeeid")int employeeid,
			@RequestParam("productid")int productid,
			@RequestParam("productname")String productname,
			@RequestParam("custresponseid")int custresponseid,
			@RequestParam("leadstatusid")int leadstatusid,
			@RequestParam("lastvisitdate")Date lastvisitdate,
			@RequestParam("createdby")int createdby,
			@RequestParam("createdat")Date createdat,
			@RequestParam("modifiedby")String modifiedby,
			@RequestParam("modifiedat")Date modifiedat,
			@RequestParam("status")int status) 
	{
		return new b_customervisithistory().pInsertCustomerVisitHistory(customerid,
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
	
	@RequestMapping(value = "/modifyvisithistory", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public String pUpdateCustomerVisitHistory(
			@RequestParam("id")  int id,
			@RequestParam("customerid")int customerid,
			@RequestParam("employeeid")int employeeid,
			@RequestParam("productid")int productid,
			@RequestParam("productname")String productname,
			@RequestParam("custresponseid")int custresponseid,
			@RequestParam("leadstatusid")int leadstatusid,
			@RequestParam("lastvisitdate")Date lastvisitdate,
			@RequestParam("createdby")int createdby,
			@RequestParam("createdat")Date createdat,
			@RequestParam("modifiedby")String modifiedby,
			@RequestParam("modifiedat")Date modifiedat,
			@RequestParam("status")int status) 
	{
		return new b_customervisithistory().pUpdateCustomerVisitHistory(
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
