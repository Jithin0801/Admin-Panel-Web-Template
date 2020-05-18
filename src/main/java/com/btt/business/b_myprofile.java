package com.btt.business;

import com.btt.service.myprofileService;
import com.btt.util.ApplicationContextProvider;

public class b_myprofile {
    public String getMyProfileById(int id) {
        myprofileService cs = ApplicationContextProvider.getBean("myprofileService", myprofileService.class);
        return cs.getMyProfileById( id);
    }
    public String postMyProfile(String name,
                                String email,
                                int age,
                                String gender,
                                String phonenumber,
                                String sessionid) {
        myprofileService cs = ApplicationContextProvider.getBean("myprofileService", myprofileService.class);
        return cs.postMyProfile(name,email,age,gender,phonenumber,sessionid);
    }
    public String updateMyProfile(int id,String name,
                                  String email,
                                  int age,
                                  String gender,
                                  String phonenumber,
                                  String sessionid) {
        myprofileService cs = ApplicationContextProvider.getBean("myprofileService", myprofileService.class);
        return cs.updateMyProfile(id,name,email,age,gender,phonenumber,sessionid);
    }
    public String getMyProfileBySessionId(String sessionid) {
        myprofileService cs = ApplicationContextProvider.getBean("myprofileService", myprofileService.class);
        return cs.getMyProfileBySessionId( sessionid);
    }
}
