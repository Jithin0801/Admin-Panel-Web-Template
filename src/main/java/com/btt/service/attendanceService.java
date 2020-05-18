package com.btt.service;

public interface attendanceService {
	String getAllAttendance();
	String getAttendanceById(int id);
	String getAttendancebyAttendanceStatus(String attendancestatus);
}
