package com.btt.business;

import com.btt.service.ordersService;
import com.btt.util.ApplicationContextProvider;

import java.sql.Date;

public class b_orders {
    public String getAllOrders(){
        ordersService cs = ApplicationContextProvider.getBean("ordersService", ordersService.class);
        return cs.getAllOrders();
    }
    public String getOrderById(int id){
        ordersService cs = ApplicationContextProvider.getBean("ordersService",ordersService.class);
        return cs.getOrderById(id);
    }
    public String getOrderByStatusId(int statusid){
        ordersService cs = ApplicationContextProvider.getBean("ordersService",ordersService.class);
        return cs.getOrderByStatusId(statusid);
    }
    public String deleteOrderById(int id){
        ordersService cs = ApplicationContextProvider.getBean("ordersService",ordersService.class);
        return  cs.deleteOrderById(id);
    }
    public String pInsertOrder( int customerid,
                                int employeeid,
                                int productid,
                                int quantity,
                                String uom,
                                String ordervalue,
                                String productprice,
                                int creditdays,
                                String creditlimit,
                                String createdby,
                                Date createdat,
                                String modifiedby,
                                Date modifiedat,
                                int statusid){
        ordersService cs = ApplicationContextProvider.getBean("ordersService",ordersService.class);
        return  cs.pInsertOrder(customerid,employeeid,productid,quantity,uom,ordervalue,productprice,creditdays,creditlimit,createdby,createdat,modifiedby,modifiedat,statusid);
    }
    public String pUpdateOrder(
                                int id,
                                int customerid,
                                int employeeid,
                                int productid,
                                int quantity,
                                String uom,
                                String ordervalue,
                                String productprice,
                                int creditdays,
                                String creditlimit,
                                String createdby,
                                Date createdat,
                                String modifiedby,
                                Date modifiedat,
                                int statusid){
        ordersService cs = ApplicationContextProvider.getBean("ordersService",ordersService.class);
        return  cs.pUpdateOrder(id,customerid,employeeid,productid,quantity,uom,ordervalue,productprice,creditdays,creditlimit,createdby,createdat,modifiedby,modifiedat,statusid);
    }
}
