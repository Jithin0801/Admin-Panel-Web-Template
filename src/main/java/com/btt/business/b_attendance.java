package com.btt.business;

import com.btt.service.attendanceService;
import com.btt.util.ApplicationContextProvider;

public class b_attendance {
	public String getAllAttendance() {
		attendanceService cs = ApplicationContextProvider.getBean("attendanceService", attendanceService.class);
		return cs.getAllAttendance();
	}
	public String getAttendanceById(int id) {
		attendanceService cs = ApplicationContextProvider.getBean("attendanceService", attendanceService.class);
		return cs.getAttendanceById(id);
	}
	public String getAttendancebyAttendanceStatus(String attendancestatus) {
		attendanceService cs = ApplicationContextProvider.getBean("attendanceService", attendanceService.class);
		return cs.getAttendancebyAttendanceStatus(attendancestatus);
	}
}
