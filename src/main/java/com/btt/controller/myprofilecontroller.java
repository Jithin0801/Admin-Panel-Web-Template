package com.btt.controller;


import com.btt.business.b_myprofile;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class myprofilecontroller {
    @RequestMapping(value="/myprofilebyid",produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String getMyProfileById(
            @RequestParam("id") int id
    ) {
        return new b_myprofile().getMyProfileById(id);
    }
    @RequestMapping(value="/myprofile",produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    @CrossOrigin(origins = "*", allowedHeaders = "*")

    public String postMyProfile	(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("age" ) int age,
            @RequestParam("gender") String gender,
            @RequestParam("phonenumber") String phonenumber,
            @RequestParam("sessionid") String sessionid
    )
    {
        return new b_myprofile().postMyProfile(name,email,age,gender,phonenumber,sessionid );
    }

    @RequestMapping(value="/updatemyprofile",produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String updateMyProfile	(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("age" ) int age,
            @RequestParam("gender") String gender,
            @RequestParam("phonenumber") String phonenumber,
            @RequestParam("sessionid") String sessionid

    )
    {
        return new b_myprofile().updateMyProfile(id,name,email,age,gender,phonenumber,sessionid);
    }

    @RequestMapping(value="/getmyprofilebysessionid",produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String getMyProfileBySessionId	(
            @RequestParam("sessionid") String sessionid
    )
    {
        return new b_myprofile().getMyProfileBySessionId(sessionid);
    }
}
