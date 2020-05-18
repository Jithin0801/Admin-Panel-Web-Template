package com.btt.business;

import com.btt.service.marketvisitService;
import com.btt.util.ApplicationContextProvider;

import java.util.Date;

public class b_marketvisit {
    public String getAllMarketVisits(){
        marketvisitService cs = ApplicationContextProvider.getBean("marketvisitService", marketvisitService.class);
        return cs.getAllMarketVisits();
    }
    public String getMarketVisitById(int id){
        marketvisitService cs = ApplicationContextProvider.getBean("marketvisitService", marketvisitService.class);
        return cs.getMarketVisitById(id);
    }
    public String deleteMarketVisitById(int id){
        marketvisitService cs = ApplicationContextProvider.getBean("marketvisitService", marketvisitService.class);
        return cs.deleteMarketVisitById(id);
    }
    public String pInsertMarketVisit(   int customerid,
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
                                        int statusid){
        marketvisitService cs = ApplicationContextProvider.getBean("marketvisitService", marketvisitService.class);
        return  cs.pInsertMarketVisit(customerid,employeeid,companyname,custaddress,custphno,decisionauth,proid,custresponseid,leadstatusid,followupon,orderid,createdby,createdat,modifiedby,modifiedat,statusid);
    }
    public String pUpdateMarketVisit(
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
            int statusid){
        marketvisitService cs = ApplicationContextProvider.getBean("marketvisitService", marketvisitService.class);
        return  cs.pUpdateMarketVisit(id,customerid,employeeid,companyname,custaddress,custphno,decisionauth,proid,custresponseid,leadstatusid,followupon,orderid,createdby,createdat,modifiedby,modifiedat,statusid);
    }
}
