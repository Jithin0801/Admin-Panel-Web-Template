package com.btt.dao;


import java.util.*;
import java.util.Map.Entry;
import java.sql.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.btt.service.customerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("customerService")
public class customerdao implements customerService {

	@Autowired
	private DataSource dataSource;

	@Override
	public String getAllCustomer() {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
		simpleJdbcCall.withProcedureName("getAllCustomers");
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
	public String postCustomer(
			String customerfirstname,
			String customerlastname,
			String customercontactnumber,			
			String customeremailid,
			String customeraddress1,
			String customeraddress2,
			int customercityid,
			int customerstateid,
			int customercountryid,
			String customerlandmark,
			String contactpersonname,
			String companyname,
			String companyphonenumber,
			String companyaddress1,
			String companyaddress2,
			int companycityid,
			int companystateid,
			int companycountryid,
			String gstnumber,
			String website,
			int maindivisionid,
			int divisionid,
			String createdby,
			Date createdat,
			String modifiedby,
			Date modifiedat,
			int statusid,
			int employeeid
			){
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
		simpleJdbcCall.withProcedureName("pInsertCustomer");
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("p_customerfirstname", customerfirstname)
				.addValue("p_customerlastname", customerlastname)
				.addValue("p_customercontactnumber", customercontactnumber)
				.addValue("p_customeremailid", customeremailid)
				.addValue("p_customeraddress1", customeraddress1)
				.addValue("p_customeraddress2", customeraddress2)
				.addValue("p_customercityid", customercityid)
				.addValue("p_customerstateid", customerstateid)
				.addValue("p_customercountryid", customercountryid)
				.addValue("p_customerlandmark", customerlandmark)
				.addValue("p_contactpersonname", contactpersonname)
				.addValue("p_companyname", companyname)
				.addValue("p_companyphonenumber", companyphonenumber)
				.addValue("p_companyaddress1", companyaddress1)
				.addValue("p_companyaddress2", companyaddress2)
				.addValue("p_companycityid", companycityid)
				.addValue("p_companystateid", companystateid)
				.addValue("p_companycountryid", companycountryid)
				.addValue("p_gstnumber", gstnumber)
				.addValue("p_website", website)
				.addValue("p_maindivisionid", maindivisionid)
				.addValue("p_divisionid", divisionid)
				.addValue("p_createdby", createdby)
				.addValue("p_createdat", createdat)
				.addValue("p_modifiedby", modifiedby)
				.addValue("p_modifiedat", modifiedat)
				.addValue("p_statusid", statusid)
				.addValue("p_employeeid", employeeid);
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
	
	@Override
	public String postCustomerRequest(
			String customerfirstname,
			String customerlastname,
			String customercontactnumber,			
			String customeremailid,
			String customeraddress1,
			String customeraddress2,
			int customercityid,
			int customerstateid,
			int customercountryid,
			String customerlandmark,
			String contactpersonname,
			String companyname,
			String companyphonenumber,
			String companyaddress1,
			String companyaddress2,
			int companycityid,
			int companystateid,
			int companycountryid,
			String gstnumber,
			String website,
			int maindivisionid,
			int divisionid,
			String createdby,
			Date createdat,
			String modifiedby,
			Date modifiedat,
			int statusid,
			int employeeid
			){
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
		simpleJdbcCall.withProcedureName("pInsertCustomer");
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("p_customerfirstname", customerfirstname)
				.addValue("p_customerlastname", customerlastname)
				.addValue("p_customercontactnumber", customercontactnumber)
				.addValue("p_customeremailid", customeremailid)
				.addValue("p_customeraddress1", customeraddress1)
				.addValue("p_customeraddress2", customeraddress2)
				.addValue("p_customercityid", customercityid)
				.addValue("p_customerstateid", customerstateid)
				.addValue("p_customercountryid", customercountryid)
				.addValue("p_customerlandmark", customerlandmark)
				.addValue("p_contactpersonname", contactpersonname)
				.addValue("p_companyname", companyname)
				.addValue("p_companyphonenumber", companyphonenumber)
				.addValue("p_companyaddress1", companyaddress1)
				.addValue("p_companyaddress2", companyaddress2)
				.addValue("p_companycityid", companycityid)
				.addValue("p_companystateid", companystateid)
				.addValue("p_companycountryid", companycountryid)
				.addValue("p_gstnumber", gstnumber)
				.addValue("p_website", website)
				.addValue("p_maindivisionid", maindivisionid)
				.addValue("p_divisionid", divisionid)
				.addValue("p_createdby", createdby)
				.addValue("p_createdat", createdat)
				.addValue("p_modifiedby", modifiedby)
				.addValue("p_modifiedat", modifiedat)
				.addValue("p_statusid", statusid)
				.addValue("p_employeeid", employeeid);

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
	
	@Override
	public String getCustomerById(int id) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
		simpleJdbcCall.withProcedureName("getCustomerById");
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
	public String getCustomerByStatusId(int statusid) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
		simpleJdbcCall.withProcedureName("getCustomerByStatusId");
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
	public String updateCustomer(
			int id,
			String customerfirstname,
			String customerlastname,
			String customercontactnumber,
			String customeremailid,
			String customeraddress1,
			String customeraddress2,
			int customercityid,
			int customerstateid,
			int customercountryid,
			String customerlandmark,
			String contactpersonname,
			String companyname,
			String companyphonenumber,
			String companyaddress1,
			String companyaddress2,
			int companycityid,
			int companystateid,
			int companycountryid,
			String gstnumber,
			String website,
			int maindivisionid,
			int divisionid,
			String createdby,
			Date createdat,
			String modifiedby,
			Date modifiedat,
			int statusid,
			int employeeid
			){
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
		simpleJdbcCall.withProcedureName("pUpdateCustomer");
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("p_id", id)
				.addValue("p_customerfirstname", customerfirstname)
				.addValue("p_customerlastname", customerlastname)
				.addValue("p_customercontactnumber", customercontactnumber)
				.addValue("p_customeremailid", customeremailid)
				.addValue("p_customeraddress1", customeraddress1)
				.addValue("p_customeraddress2", customeraddress2)
				.addValue("p_customercityid", customercityid)
				.addValue("p_customerstateid", customerstateid)
				.addValue("p_customercountryid", customercountryid)
				.addValue("p_customerlandmark", customerlandmark)
				.addValue("p_contactpersonname", contactpersonname)
				.addValue("p_companyname", companyname)
				.addValue("p_companyphonenumber", companyphonenumber)
				.addValue("p_companyaddress1", companyaddress1)
				.addValue("p_companyaddress2", companyaddress2)
				.addValue("p_companycityid", companycityid)
				.addValue("p_companystateid", companystateid)
				.addValue("p_companycountryid", companycountryid)
				.addValue("p_gstnumber", gstnumber)
				.addValue("p_website", website)
				.addValue("p_maindivisionid", maindivisionid)
				.addValue("p_divisionid", divisionid)
				.addValue("p_createdby", createdby)
				.addValue("p_createdat", createdat)
				.addValue("p_modifiedby", modifiedby)
				.addValue("p_modifiedat", modifiedat)
				.addValue("p_statusid", statusid)
				.addValue("p_employeeid", employeeid);

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

	
	@Override
	public String deleteCustomerById(int id) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
		simpleJdbcCall.withProcedureName("deleteCustomerById");
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
