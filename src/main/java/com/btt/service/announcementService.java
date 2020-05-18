package com.btt.service;

import java.sql.Date;

public interface announcementService {
    String getAnnouncementByStatus(String announcementstatus);
    String postAnnouncement(
            String announcementtitle,
            String announcementbody,
            Date createdat,
            String createdby,
            String announcementstatus
    );
    String postDraft(
            String announcementtitle,
            String announcementbody,
            Date createdat,
            String createdby,
            String announcementstatus
    );
    String getAnnouncementById(
            int  id
    );
    String deleteAnnouncementById(
            int id
    );

}
