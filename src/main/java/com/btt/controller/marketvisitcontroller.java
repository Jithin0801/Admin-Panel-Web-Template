package com.btt.controller;


import com.btt.business.b_marketvisit;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class marketvisitcontroller {
    @RequestMapping(value="/marketvisits",produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    public String getAllMarketVisits() {
        return new b_marketvisit().getAllMarketVisits();
    }
    @RequestMapping(value="/marketvisitbyid",produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    public String getMarketVisitById(@RequestParam("id")int id) {
        return new b_marketvisit().getMarketVisitById(id);
    }
    @RequestMapping(value="/deletemarketvisit",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.DELETE)
    public String deleteMarketVisitById(@RequestParam("id")int id){
        return new b_marketvisit().deleteMarketVisitById(id);
    }
    @RequestMapping(value = "/insertmarketvisit",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    public String pInsertMarketVisit(
            @RequestParam("customerid")int customerid,
            @RequestParam("employeeid")int employeeid,
            @RequestParam("companyname")String companyname,
            @RequestParam("custaddress")String custaddress,
            @RequestParam("custphno")String custphno,
            @RequestParam("decisionauth")String decisionauth,
            @RequestParam("proid")int proid,
            @RequestParam("custresponseid")int custresponseid,
            @RequestParam("leadstatusid")int leadstatusid,
            @RequestParam("followupon")Date followupon,
            @RequestParam("orderid")int orderid,
            @RequestParam("createdby")String createdby,
            @RequestParam("createdat")Date createdat,
            @RequestParam("modifiedby")String modifiedby,
            @RequestParam("modifiedat")Date modifiedat,
            @RequestParam("statusid")int statusid
    ){
        return new b_marketvisit().pInsertMarketVisit(customerid,employeeid,companyname,custaddress,custphno,decisionauth,proid,custresponseid,leadstatusid,followupon,orderid,createdby,createdat,modifiedby,modifiedat,statusid);
    }
    @RequestMapping(value = "/updatemarketvisit",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    public String pUpdateMarketVisit(
            @RequestParam("id")int id,
            @RequestParam("customerid")int customerid,
            @RequestParam("employeeid")int employeeid,
            @RequestParam("companyname")String companyname,
            @RequestParam("custaddress")String custaddress,
            @RequestParam("custphno")String custphno,
            @RequestParam("decisionauth")String decisionauth,
            @RequestParam("proid")int proid,
            @RequestParam("custresponseid")int custresponseid,
            @RequestParam("leadstatusid")int leadstatusid,
            @RequestParam("followupon")Date followupon,
            @RequestParam("orderid")int orderid,
            @RequestParam("createdby")String createdby,
            @RequestParam("createdat")Date createdat,
            @RequestParam("modifiedby")String modifiedby,
            @RequestParam("modifiedat")Date modifiedat,
            @RequestParam("statusid")int statusid
    ){
        return new b_marketvisit().pUpdateMarketVisit(id,customerid,employeeid,companyname,custaddress,custphno,decisionauth,proid,custresponseid,leadstatusid,followupon,orderid,createdby,createdat,modifiedby,modifiedat,statusid);
    }
}
