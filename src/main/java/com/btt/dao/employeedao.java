package com.btt.dao;


import java.sql.Date;
import java.util.*;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import com.btt.service.employeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("employeeService")
public class employeedao implements employeeService {

	@Autowired
	private DataSource dataSource;

	@Override
	public String getEmployeeById(int id) {
		SimpleJdbcCall simpleJdbcCall1 = new SimpleJdbcCall(dataSource);
		simpleJdbcCall1.withProcedureName("getEmployeeById");
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
	public String deleteEmployeeById(int id) {
		SimpleJdbcCall simpleJdbcCall1 = new SimpleJdbcCall(dataSource);
		simpleJdbcCall1.withProcedureName("deleteEmployeeById");
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
	public String getAllEmployees() {
		SimpleJdbcCall simpleJdbcCall1 = new SimpleJdbcCall(dataSource);
		simpleJdbcCall1.withProcedureName("getAllEmployees");
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
	public String pInsertEmployee(String employeename, Date employeedob, int employeegenderid,
			String employeecontactnumber, String employeeemail, String employeeaddress1, String employeeaddress2,
			int employeecityid, int employeestateid, String employeelandmark, Date employeedoj, int designationid,
			int maindivisionid, int divisionid, String createdby, Date createdat, String modifiedby, Date modifiedat,
			int statusid) {
		SimpleJdbcCall simpleJdbcCall1 = new SimpleJdbcCall(dataSource);
		simpleJdbcCall1.withProcedureName("pInsertEmployee");
		SqlParameterSource in = new MapSqlParameterSource()
				
				.addValue("p_employeename",employeename)
				.addValue("p_employeedob",employeedob)
				.addValue("p_employeegenderid", employeegenderid)
				.addValue("p_employeecontactnumber", employeecontactnumber)
				.addValue("p_employeeemail", employeeemail)
				.addValue("p_employeeaddress1", employeeaddress1)
				.addValue("p_employeeaddress2", employeeaddress2)
				.addValue("p_employeecityid", employeecityid)
				.addValue("p_employeestateid", employeestateid)
				.addValue("p_employeelandmark", employeelandmark)
				.addValue("p_employeedoj", employeedoj)
				.addValue("p_designationid", designationid)
				.addValue("p_maindivisionid", maindivisionid)
				.addValue("p_divisionid", divisionid)
				.addValue("p_createdby", createdby)
				.addValue("p_createdat", createdat)
				.addValue("p_modifiedby", modifiedby)
				.addValue("p_modifiedat", modifiedat)
				.addValue("p_statusid", statusid);
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
	public String pUpdateEmployee(int id, String employeename, Date employeedob, int employeegenderid,
			String employeecontactnumber, String employeeemail, String employeeaddress1, String employeeaddress2,
			int employeecityid, int employeestateid, String employeelandmark, Date employeedoj, int designationid,
			int maindivisionid, int divisionid, String createdby, Date createdat, String modifiedby, Date modifiedat,
			int statusid) {
		SimpleJdbcCall simpleJdbcCall1 = new SimpleJdbcCall(dataSource);
		simpleJdbcCall1.withProcedureName("pUpdateEmployee");
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("p_id",id)
				.addValue("p_employeename",employeename)
				.addValue("p_employeedob",employeedob)
				.addValue("p_employeegenderid", employeegenderid)
				.addValue("p_employeecontactnumber", employeecontactnumber)
				.addValue("p_employeeemail", employeeemail)
				.addValue("p_employeeaddress1", employeeaddress1)
				.addValue("p_employeeaddress2", employeeaddress2)
				.addValue("p_employeecityid", employeecityid)
				.addValue("p_employeestateid", employeestateid)
				.addValue("p_employeelandmark", employeelandmark)
				.addValue("p_employeedoj", employeedoj)
				.addValue("p_designationid", designationid)
				.addValue("p_maindivisionid", maindivisionid)
				.addValue("p_divisionid", divisionid)
				.addValue("p_createdby", createdby)
				.addValue("p_createdat", createdat)
				.addValue("p_modifiedby", modifiedby)
				.addValue("p_modifiedat", modifiedat)
				.addValue("p_statusid", statusid);
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
