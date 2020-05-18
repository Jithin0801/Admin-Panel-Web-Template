package com.btt.dao;

import com.btt.service.marketvisitService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import javax.sql.DataSource;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class marketvisitdao implements marketvisitService {

    @Autowired
    private DataSource dataSource;


    @Override
    public String getAllMarketVisits() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
        simpleJdbcCall.withProcedureName("getAllMarketVisits");
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
    public String getMarketVisitById(int id) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
        simpleJdbcCall.withProcedureName("getMarketVisitById");
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
    public String deleteMarketVisitById(int id) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
        simpleJdbcCall.withProcedureName("deleteMarketVisitById");
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
    public String pInsertMarketVisit(
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
    ) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
        simpleJdbcCall.withProcedureName("pInsertOrder");
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_customerid", customerid)
                .addValue("p_employeeid", employeeid)
                .addValue("p_companyname", companyname)
                .addValue("p_custaddress", custaddress)
                .addValue("p_custphno", custphno)
                .addValue("p_decisionauth", decisionauth)
                .addValue("p_proid", proid)
                .addValue("p_custresponseid", custresponseid)
                .addValue("p_leadstatusid", leadstatusid)
                .addValue("p_followupon", followupon)
                .addValue("p_orderid", orderid)
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
            int statusid
    ) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
        simpleJdbcCall.withProcedureName("pUpdateOrder");
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_id",id)
                .addValue("p_customerid", customerid)
                .addValue("p_employeeid", employeeid)
                .addValue("p_companyname", companyname)
                .addValue("p_custaddress", custaddress)
                .addValue("p_custphno", custphno)
                .addValue("p_decisionauth", decisionauth)
                .addValue("p_proid", proid)
                .addValue("p_custresponseid", custresponseid)
                .addValue("p_leadstatusid", leadstatusid)
                .addValue("p_followupon", followupon)
                .addValue("p_orderid", orderid)
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
