package com.btt.dao;

import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.btt.service.customervisithistoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("customervisithistoryService")

public class customervisithistorydao implements customervisithistoryService {
	
	@Autowired
	private DataSource dataSource;

	@Override
	public String getAllCustomerVisitHistories() {
		SimpleJdbcCall simpleJdbcCall1 = new SimpleJdbcCall(dataSource);
		simpleJdbcCall1.withProcedureName("getAllCustomerVisitHistories");
		// SqlParameterSource in = new MapSqlParameterSource().addValue("p_StateId",
		// id);
		Map<String, Object> out = simpleJdbcCall1.execute();
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
	public String getCustomerVisitHistoryById(int id) {
		SimpleJdbcCall simpleJdbcCall1 = new SimpleJdbcCall(dataSource);
		simpleJdbcCall1.withProcedureName("getCustomerVisitHistoryById");
		SqlParameterSource in = new MapSqlParameterSource().addValue("p_id", id);
		Map<String, Object> out = simpleJdbcCall1.execute(in);
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
	public String deleteCustomerVisitHistoryById(int id) {
		SimpleJdbcCall simpleJdbcCall1 = new SimpleJdbcCall(dataSource);
		simpleJdbcCall1.withProcedureName("deleteCustomerVisitHistoryById");
		SqlParameterSource in = new MapSqlParameterSource().addValue("d_id", id);
		Map<String, Object> out = simpleJdbcCall1.execute(in);
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
	public String pInsertCustomerVisitHistory(
			int customerid,
			int employeeid,
			int productid,
			String productname,
			int custresponseid,
			int leadstatusid,
			Date lastvisitdate,
			int createdby,
			Date createdat,
			String modifiedby,
			Date modifiedat,
			int status)
	{
		SimpleJdbcCall simpleJdbcCall1 = new SimpleJdbcCall(dataSource);
		simpleJdbcCall1.withProcedureName("pInsertCustomerVisitHistory");
		SqlParameterSource in = new MapSqlParameterSource()
				
				.addValue("p_customerid",customerid)
				.addValue("p_employeeid",employeeid)
				.addValue("p_productid",productid)
				.addValue("p_productname",productname)
				.addValue("p_custresponseid",custresponseid)
				.addValue("p_leadstatusid",leadstatusid)
				.addValue("p_lastvisitdate",lastvisitdate)
				.addValue("p_createdby",createdby)
				.addValue("p_createdat",createdat)
				.addValue("p_modifiedby",modifiedby)
				.addValue("p_modifiedat",modifiedat)
				.addValue("p_status",status);
				
		Map<String, Object> out = simpleJdbcCall1.execute(in);
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
	public String pUpdateCustomerVisitHistory(
			int id,
			int customerid,
			int employeeid,
			int productid,
			String productname,
			int custresponseid,
			int leadstatusid,
			Date lastvisitdate,
			int createdby,
			Date createdat,
			String modifiedby,
			Date modifiedat,
			int status)
	{
		SimpleJdbcCall simpleJdbcCall1 = new SimpleJdbcCall(dataSource);
		simpleJdbcCall1.withProcedureName("pUpdateCustomerVisitHistory");
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("p_id",id)
				.addValue("p_customerid",customerid)
				.addValue("p_employeeid",employeeid)
				.addValue("p_productid",productid)
				.addValue("p_productname",productname)
				.addValue("p_custresponseid",custresponseid)
				.addValue("p_leadstatusid",leadstatusid)
				.addValue("p_lastvisitdate",lastvisitdate)
				.addValue("p_createdby",createdby)
				.addValue("p_createdat",createdat)
				.addValue("p_modifiedby",modifiedby)
				.addValue("p_modifiedat",modifiedat)
				.addValue("p_status",status);
		Map<String, Object> out = simpleJdbcCall1.execute(in);
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
		Iterator<Entry<String, Object>> it = out.entrySet().iterator();
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
