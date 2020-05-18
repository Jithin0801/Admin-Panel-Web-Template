package com.btt.business;


import com.btt.service.reportService;
import com.btt.util.ApplicationContextProvider;

public class b_report {
	public String getAllReport() {
		reportService ps = ApplicationContextProvider.getBean("reportService", reportService.class);
		return ps.getAllReport();
	}
	public String getReportById(int id) {
		reportService ps = ApplicationContextProvider.getBean("reportService", reportService.class);
		return ps.getReportById(id);
	}

}
