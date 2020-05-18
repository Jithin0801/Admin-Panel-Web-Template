package com.btt.service;

import java.util.Date;

public interface marketvisitService {
    String getAllMarketVisits();
    String getMarketVisitById(int id);
    String deleteMarketVisitById(int id);
    String pInsertMarketVisit(
            int customerid,
            int employeeid,
            String companyname,
            String custaddress,
            String custphno,
            String decisionauth,
            int proid,
            int custresponseid,
            int leadstatusid,
            Date followupon,
            int orderid,
            String createdby,
            Date createdat,
            String modifiedby,
            Date modifiedat,
            int statusid
    );
    String pUpdateMarketVisit(
            int id,
            int customerid,
            int employeeid,
            String companyname,
            String custaddress,
            String custphno,
            String decisionauth,
            int proid,
            int custresponseid,
            int leadstatusid,
            Date followupon,
            int orderid,
            String createdby,
            Date createdat,
            String modifiedby,
            Date modifiedat,
            int statusid
    );
}
