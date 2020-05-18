package com.btt.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btt.business.b_attendance;

@RestController
@RequestMapping("/api")
public class attendancecontroller {
	@RequestMapping(value="/attendance",produces = MediaType.APPLICATION_JSON_VALUE,
		    method = RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	public String getAllAttendance() {		
		return new b_attendance().getAllAttendance();
	}
	@RequestMapping(value="/attendancebyid",produces = MediaType.APPLICATION_JSON_VALUE,
		    method = RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	public String getAttendanceById(@RequestParam("id")int id ) {		
		return new b_attendance().getAttendanceById(id);
	}
	@RequestMapping(value="/attendancebyattendacestatus",produces = MediaType.APPLICATION_JSON_VALUE,
		    method = RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
	public String getAttendancebyAttendanceStatus(@RequestParam("attendacestatus")String attendacestatus ) {		
		return new b_attendance().getAttendancebyAttendanceStatus(attendacestatus);
	}
}
