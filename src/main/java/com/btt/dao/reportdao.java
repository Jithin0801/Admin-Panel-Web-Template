package com.btt.dao;

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

import com.btt.service.reportService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("reportService")
public class reportdao implements reportService {

	@Autowired
	private DataSource dataSource;

	@Override
	public String getAllReport() {
		SimpleJdbcCall simpleJdbcCall1 = new SimpleJdbcCall(dataSource);
		simpleJdbcCall1.withProcedureName("getAllReport");
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

	public String getReportById(int id) {
		SimpleJdbcCall simpleJdbcCall1 = new SimpleJdbcCall(dataSource);
		simpleJdbcCall1.withProcedureName("getReportById");
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
