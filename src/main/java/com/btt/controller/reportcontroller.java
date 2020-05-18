package com.btt.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btt.business.b_report;

@RestController
@RequestMapping("/api")
public class reportcontroller {
	@RequestMapping(value = "/reports", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public String getAllReport() {
		return new b_report().getAllReport();
	}

	@RequestMapping(value = "/reportbyid", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public String getReportById(@RequestParam("id") int id) {
		return new b_report().getReportById(id);
	}
}
