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

import com.btt.service.custrequestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("custService")
public class custrequestdao implements custrequestService {
	@Autowired
	private DataSource dataSource;
	@Override
	public String postcustrequest(
			String custfirstname,
			String custlastname,
			String custcontactnumber,
			String custemailid,
			String custaddress,
			int custcityid,
			int custstateid,
			int custcountryid,
			String custlandmark,
			String contactpersonname,
			String companyname,
			String companyphonenumber,
			String companyaddress,
			int companycityid,
			int companystateid,
			int companycountryid,
			String gstnumber,
			String website,
			int maindivisionid,
			int divisionid,
			String createdby,
			int statusid)
	{
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
		simpleJdbcCall.withProcedureName("pInsertCustrequest");
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("p_custfirstname", custfirstname)
				.addValue("p_custlastname", custlastname)
				.addValue("p_custcontactnumber", custcontactnumber)
				.addValue("p_custemailid", custemailid)
				.addValue("p_custaddress", custaddress)
				.addValue("p_custcityid", custcityid)
				.addValue("p_custstateid", custstateid)
				.addValue("p_custcountryid", custcountryid)
				.addValue("p_custlandmark", custlandmark)
				.addValue("p_contactpersonname", contactpersonname)
				.addValue("p_companyname", companyname)
				.addValue("p_companyphonenumber", companyphonenumber)
				.addValue("p_companyaddress", companyaddress)
				.addValue("p_companycityid", companycityid)
				.addValue("p_companystateid", companystateid)
				.addValue("p_companycountryid", companycountryid)
				.addValue("p_gstnumber", gstnumber)
				.addValue("p_website", website)
				.addValue("p_maindivisionid", maindivisionid)
				.addValue("p_divisionid", divisionid)
				.addValue("p_createdby", createdby)
				.addValue("p_statusid", statusid);
		Map<String, Object> out = simpleJdbcCall.execute(in);
		List<Map<String, Object>> putCustomerResult = getMapList(out);
		final ObjectMapper mapper = new ObjectMapper();
		String str = null;
		try {
			str = mapper.writeValueAsString(putCustomerResult);
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
