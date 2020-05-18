package com.btt.dao;

import com.btt.service.adminLoginService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
@Service("adminLoginService")
public class adminlogindao implements adminLoginService {

    @Autowired
    private DataSource dataSource;


    @Override
    public String getAllAdminLogin() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
        simpleJdbcCall.withProcedureName("getAllLoginInfo");
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
    public String getLoginByEmailAndPassword(String email, String password) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
        simpleJdbcCall.withProcedureName("getLoginByEmailAndPassword");
        SqlParameterSource in = new MapSqlParameterSource()
        	    .addValue("p_email", email)
                .addValue("p_password", password);
        Map<String, Object> out = simpleJdbcCall.execute(in);
        List<Map<String, Object>> result = getMapList(out);
        final ObjectMapper mapper = new ObjectMapper();
        String str = null;
        try {
            str = mapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return  str;
    }

    @Override
    public String updatePassword(int id, String email, String password, String sessionid) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
        simpleJdbcCall.withProcedureName("updatePassword");
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_id", id)
                .addValue("p_email", email)
                .addValue("p_password", password)
                .addValue("p_sessionid", sessionid);
    Map<String, Object> out = simpleJdbcCall.execute(in);
    List<Map<String, Object>> result = getMapList(out);
    final ObjectMapper mapper = new ObjectMapper();
    String str = null;
        try {
        str = mapper.writeValueAsString(result);
    } catch (JsonProcessingException e) {
        e.printStackTrace();
    }
        return  str;
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
