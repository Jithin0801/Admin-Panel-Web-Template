package com.btt.business;

import com.btt.service.announcementService;
import com.btt.util.ApplicationContextProvider;

import java.sql.Date;

public class b_announcement {
    public String getAnnouncementByStatus(String announcementstatus){
        announcementService cs =  ApplicationContextProvider.getBean("announcementService", announcementService.class);
        return cs.getAnnouncementByStatus(announcementstatus);
    }
    public String postAnnouncement(
            String announcementtitle,
            String announcementbody,
            Date createdat,
            String createdby,
            String announcementstatus
    ){
        announcementService cs =  ApplicationContextProvider.getBean("announcementService", announcementService.class);
        return cs.postAnnouncement(announcementtitle,announcementbody,createdat,createdby,announcementstatus);
    }
    public String postDraft(
            String announcementtitle,
            String announcementbody,
            Date createdat,
            String createdby,
            String announcementstatus
    ){
        announcementService cs =  ApplicationContextProvider.getBean("announcementService", announcementService.class);
        return cs.postDraft(announcementtitle,announcementbody,createdat,createdby,announcementstatus);
    }
    public String getAnnouncementById(
            int  id
    ){
        announcementService cs =  ApplicationContextProvider.getBean("announcementService", announcementService.class);
        return cs.getAnnouncementById(id);
    }
    public String deleteAnnouncementById(
            int id
    ){
        announcementService cs =  ApplicationContextProvider.getBean("announcementService", announcementService.class);
        return cs.deleteAnnouncementById(id);
    }

}
