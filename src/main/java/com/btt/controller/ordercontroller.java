package com.btt.controller;


import com.btt.business.b_orders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping("/api")
public class ordercontroller {
    @RequestMapping(value="/orders",produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String getAllOrders() {
        return new b_orders().getAllOrders();
    }
    @RequestMapping(value="/orderbyid",produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String getOrdersById(@RequestParam("id")int id) {
        return new b_orders().getOrderById(id);
    }
    @RequestMapping(value="/orderbystatusid",produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String getOrderByStatusId(@RequestParam("statusid")int statusid) {
        return new b_orders().getOrderByStatusId(statusid);
    }
    @RequestMapping(value="/deleteorder",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.DELETE)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String deleteOrderById(@RequestParam("id")int id){
        return new b_orders().deleteOrderById(id);
    }
    @RequestMapping(value = "/insertorder",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String pInsertOrder(
                        @RequestParam("customerid")int customerid,
                        @RequestParam("employeeid")int employeeid,
                        @RequestParam("productid")int productid,
                        @RequestParam("quantity")int quantity,
                        @RequestParam("uom")String uom,
                        @RequestParam("ordervalue")String ordervalue,
                        @RequestParam("productprice")String  productprice,
                        @RequestParam("creditdays")int creditdays,
                        @RequestParam("creditlimit")String creditlimit,
                        @RequestParam("createdby")String createdby,
                        @RequestParam("createdat")Date createdat,
                        @RequestParam("modifiedby")String modifiedby,
                        @RequestParam("modifiedat")Date modifiedat,
                        @RequestParam("statusid")int statusid
    ){
        return new b_orders().pInsertOrder(customerid,employeeid,productid,quantity,uom,ordervalue,productprice,creditdays,creditlimit,createdby,createdat,modifiedby,modifiedat,statusid);
    }
    @RequestMapping(value = "/updateorder",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.PUT)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String pUpdateOrder(
            @RequestParam("id")int id,
            @RequestParam("customerid")int customerid,
            @RequestParam("employeeid")int employeeid,
            @RequestParam("productid")int productid,
            @RequestParam("quantity")int quantity,
            @RequestParam("uom")String uom,
            @RequestParam("ordervalue")String ordervalue,
            @RequestParam("productprice")String  productprice,
            @RequestParam("creditdays")int creditdays,
            @RequestParam("creditlimit")String creditlimit,
            @RequestParam("createdby")String createdby,
            @RequestParam("createdat")Date createdat,
            @RequestParam("modifiedby")String modifiedby,
            @RequestParam("modifiedat")Date modifiedat,
            @RequestParam("statusid")int statusid
    ){
        return new b_orders().pUpdateOrder(id,customerid,employeeid,productid,quantity,uom,ordervalue,productprice,creditdays,creditlimit,createdby,createdat,modifiedby,modifiedat,statusid);
    }
}
