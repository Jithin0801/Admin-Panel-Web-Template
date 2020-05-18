package com.btt.controller;

import com.btt.business.b_announcement;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping("/api")
public class announcementcontroller {

    @RequestMapping(value="/announcementbystatus",produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String getAnnouncementByStatus(String announcementstatus) {
        return new b_announcement().getAnnouncementByStatus(announcementstatus);
    }


    @RequestMapping(value="/addnewannouncement",produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    String postAnnouncement(
            String announcementtitle,
            String announcementbody,
            Date createdat,
            String createdby,
            String announcementstatus
    ){
        return new b_announcement().postAnnouncement(announcementtitle,announcementbody,createdat,createdby,announcementstatus);
    }


    @RequestMapping(value="/postdraft",produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    String postDraft(
            String announcementtitle,
            String announcementbody,
            Date createdat,
            String createdby,
            String announcementstatus
    ){
        return new b_announcement().postDraft(announcementtitle,announcementbody,createdat,createdby,announcementstatus);
    }

    @RequestMapping(value="/announcementbyid",produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    String getAnnouncementById(
            int  id
    ){
        return new b_announcement().getAnnouncementById(id);
    }

    @RequestMapping(value="/deleteannouncement",produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.DELETE)
    @CrossOrigin(origins = "http://localhost")
    String deleteAnnouncementById(
            int id
    ){
        return new b_announcement().deleteAnnouncementById(id);
    }
}
