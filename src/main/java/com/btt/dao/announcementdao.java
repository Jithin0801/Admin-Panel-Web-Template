package com.btt.dao;

import com.btt.service.announcementService;
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


@Service("announcementService")

public class announcementdao implements announcementService{

    @Autowired
    private DataSource dataSource;

    @Override
    public String getAnnouncementByStatus(String announcementstatus) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
        simpleJdbcCall.withProcedureName("getAnnouncementByStatus");
        SqlParameterSource in = new MapSqlParameterSource().addValue("p_announcementstatus", announcementstatus);
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
    public String postAnnouncement(
            String announcementtitle,
            String announcementbody,
            Date createdat,
            String createdby,
            String announcementstatus
    ) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
        simpleJdbcCall.withProcedureName("postAnnouncement");
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_announcementtitle", announcementtitle)
                .addValue("p_announcementbody", announcementbody)
                .addValue("p_createdat", createdat)
                .addValue("p_createdby", createdby)
                .addValue("p_announcementstatus", announcementstatus);
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
    public String postDraft(String announcementtitle, String announcementbody, Date createdat, String createdby, String announcementstatus) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
        simpleJdbcCall.withProcedureName("postDraft");
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("p_announcementtitle", announcementtitle)
                .addValue("p_announcementbody", announcementbody)
                .addValue("p_createdat", createdat)
                .addValue("p_createdby", createdby)
                .addValue("p_announcementstatus", announcementstatus);
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
    public String getAnnouncementById(int id) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
        simpleJdbcCall.withProcedureName("getAnnouncementById");
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
    public String deleteAnnouncementById(int id) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
        simpleJdbcCall.withProcedureName("deleteAnnouncementById");
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
        return str;    }

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
