package com.btt.service;

import java.sql.Date;

public interface ordersService {
    String getAllOrders();
    String getOrderById(int id);
    String getOrderByStatusId(int statusid);
    String deleteOrderById(int id);
    String pInsertOrder(
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
            int statusid
    );
    String pUpdateOrder(
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
            int statusid
    );
}
