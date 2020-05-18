package com.btt.controller;

import com.btt.business.b_adminlogin;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class adminlogincontroller {
    @RequestMapping(value="/adminlogin",produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String getAllAdminLogin() {
        return new b_adminlogin().getAllAdminLogin();
    }
    @RequestMapping(value="/checkcredentials",produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String getLoginByEmailAndPassword	(
            @RequestParam("email") String email,
            @RequestParam("password" ) String password)
    {
        return new b_adminlogin().getLoginByEmailAndPassword(email,password);
    }

    @RequestMapping(value="/updatepassword",produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String updatePassword	(
            @RequestParam("id") int id,
            @RequestParam("email") String email,
            @RequestParam("password" ) String password,
            @RequestParam("sessionid" ) String sessionid)
    {
        return new b_adminlogin().updatePassword(id, email,password,sessionid);
    }
}
