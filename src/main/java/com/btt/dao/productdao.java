package com.btt.dao;

import java.sql.Date;
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

import com.btt.service.productService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("productService")
public class productdao implements productService {
	@Autowired
	private DataSource dataSource;
	@Override
	public String getAllProducts() {
		SimpleJdbcCall simpleJdbcCall1 = new SimpleJdbcCall(dataSource);
		simpleJdbcCall1.withProcedureName("getAllProducts");
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
	public String getProductById(int id) {
		SimpleJdbcCall simpleJdbcCall1 = new SimpleJdbcCall(dataSource);
		simpleJdbcCall1.withProcedureName("getProductById");
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

	@Override
	public String pInsertProduct(
			String productname,
			String productcode,
			int maindivisionid,
			int divisionid,
			int categoryid,
			String productapplicationarea,
			String productspecification,
			String productvideourl,
			String productfileurl,
			String createdby,
			Date createdat,
			String modifiedby,
			Date modifiedat,
			int statusid
	) {
		SimpleJdbcCall simpleJdbcCall1 = new SimpleJdbcCall(dataSource);
		simpleJdbcCall1.withProcedureName("pInsertProduct");
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("p_productname",productname)
				.addValue("p_productcode",productcode)
				.addValue("p_maindivisionid",maindivisionid )
				.addValue("p_divisionid",divisionid)
				.addValue("p_categoryid",categoryid)
				.addValue("p_productapplicationarea",productapplicationarea)
				.addValue("p_productspecification",productspecification)
				.addValue("p_productvideourl",productvideourl)
				.addValue("p_productfileurl",productfileurl)
				.addValue("p_createdby",createdby )
				.addValue("p_createdat",createdat)
				.addValue("p_modifiedby",modifiedby )
				.addValue("p_modifiedat",modifiedat)
				.addValue("p_statusid",statusid
				);
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
	public String pUpdateProduct(
			int id,
			String productname,
			String productcode,
			int  maindivisionid,
			int divisionid,
			int categoryid,
			String productapplicationarea,
			String productspecification,
			String productvideourl,
			String productfileurl,
			String createdby,
			Date createdat,
			String modifiedby,
			Date modifiedat,
			int statusid
	) {
		SimpleJdbcCall simpleJdbcCall1 = new SimpleJdbcCall(dataSource);
		simpleJdbcCall1.withProcedureName("pUpdateProduct");
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("p_id",id)
				.addValue("p_productname",productname)
				.addValue("p_productcode",productcode)
				.addValue("p_maindivisionid",maindivisionid )
				.addValue("p_divisionid",divisionid)
				.addValue("p_categoryid",categoryid)
				.addValue("p_productapplicationarea",productapplicationarea)
				.addValue("p_productspecification",productspecification)
				.addValue("p_productvideourl",productvideourl)
				.addValue("p_productfileurl",productfileurl)
				.addValue("p_createdby",createdby )
				.addValue("p_createdat",createdat)
				.addValue("p_modifiedby",modifiedby )
				.addValue("p_modifiedat",modifiedat)
				.addValue("p_statusid",statusid
				);
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
	public String deleteProductById(int id) {
		SimpleJdbcCall simpleJdbcCall1 = new SimpleJdbcCall(dataSource);
		simpleJdbcCall1.withProcedureName("deleteProductById");
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
}
