package com.btt.dao;

import com.btt.service.ordersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


@Service("ordersService")

public class ordersdao implements ordersService {

    @Autowired
    private DataSource dataSource;


    @Override
    public String getAllOrders() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
        simpleJdbcCall.withProcedureName("getAllOrders");
        Map<String, Object> out = simpleJdbcCall.execute();
        List<Map<String, Object>> result = getMapList(out);
        final ObjectMapper mapper = new ObjectMapper();
        String str = null;
        try {
            str = mapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    public String getOrderById(int id) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
        simpleJdbcCall.withProcedureName("getOrdersById");
        SqlParameterSource in = new MapSqlParameterSource().addValue("p_id", id);
        Map<String, Object> out = simpleJdbcCall.execute(in);
        List<Map<String, Object>> result = getMapList(out);
        final ObjectMapper mapper = new ObjectMapper();
        String str = null;
        try {
            str = mapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }
    @Override
    public String getOrderByStatusId(int statusid) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
        simpleJdbcCall.withProcedureName("getOrdersByStatusId");
        SqlParameterSource in = new MapSqlParameterSource().addValue("p_statusid", statusid);
        Map<String, Object> out = simpleJdbcCall.execute(in);
        List<Map<String, Object>> result = getMapList(out);
        final ObjectMapper mapper = new ObjectMapper();
        String str = null;
        try {
            str = mapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    public String deleteOrderById(int id) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
        simpleJdbcCall.withProcedureName("deleteOrderById");
        SqlParameterSource in = new MapSqlParameterSource().addValue("p_id", id);
        Map<String, Object> out = simpleJdbcCall.execute(in);
        List<Map<String, Object>> result = getMapList(out);
        final ObjectMapper mapper = new ObjectMapper();
        String str = null;
        try {
            str = mapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    public String pInsertOrder(int customerid, int employeeid, int productid, int quantity, String uom, String ordervalue, String productprice, int creditdays, String creditlimit, String createdby, Date createdat, String modifiedby, Date modifiedat, int statusid) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
        simpleJdbcCall.withProcedureName("pInsertOrder");
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_customerid", customerid)
                .addValue("p_employeeid", employeeid)
                .addValue("p_productid", productid)
                .addValue("p_quantity", quantity)
                .addValue("p_uom", uom)
                .addValue("p_ordervalue", ordervalue)
                .addValue("p_productprice", productprice)
                .addValue("p_creditdays", creditdays)
                .addValue("p_creditlimit", creditlimit)
                .addValue("p_createdby", createdby)
                .addValue("p_createdat", createdat)
                .addValue("p_modifiedby", modifiedby)
                .addValue("p_modifiedat", modifiedat)
                .addValue("p_statusid", statusid);
        Map<String, Object> out = simpleJdbcCall.execute(in);
        List<Map<String, Object>> result = getMapList(out);
        final ObjectMapper mapper = new ObjectMapper();
        String str = null;
        try {
            str = mapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }
    @Override
    public String pUpdateOrder(int id, int customerid, int employeeid, int productid, int quantity, String uom, String ordervalue, String productprice, int creditdays, String creditlimit, String createdby, Date createdat, String modifiedby, Date modifiedat, int statusid) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
        simpleJdbcCall.withProcedureName("pUpdateOrder");
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_id",id)
                .addValue("p_customerid", customerid)
                .addValue("p_employeeid", employeeid)
                .addValue("p_productid", productid)
                .addValue("p_quantity", quantity)
                .addValue("p_uom", uom)
                .addValue("p_productprice", productprice)
                .addValue("p_ordervalue", ordervalue)
                .addValue("p_creditdays", creditdays)
                .addValue("p_creditlimit", creditlimit)
                .addValue("p_createdby", createdby)
                .addValue("p_createdat", createdat)
                .addValue("p_modifiedby", modifiedby)
                .addValue("p_modifiedat", modifiedat)
                .addValue("p_statusid", statusid);
        Map<String, Object> out = simpleJdbcCall.execute(in);
        List<Map<String, Object>> result = getMapList(out);
        final ObjectMapper mapper = new ObjectMapper();
        String str = null;
        try {
            str = mapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }

    @SuppressWarnings("unchecked")
    private List<Map<String, Object>> getMapList(Map<String, Object> out) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        Iterator<Map.Entry<String, Object>> it = out.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
            if (entry.getKey().equals("#result-set-1")) {
                mapList = (List<Map<String, Object>>) entry.getValue();
                break;
            }
        }
        return mapList;
    }

}
