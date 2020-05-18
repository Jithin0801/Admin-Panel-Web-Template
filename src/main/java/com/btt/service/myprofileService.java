package com.btt.service;

public interface myprofileService {
    String getMyProfileById (int id);
    String postMyProfile(String name,
                         String email,
                         int age,
                         String gender,
                         String phonenumber,
                         String sessionid);
    String updateMyProfile(int id,
                           String name,
                           String email,
                           int age,
                           String gender,
                           String phonenumber,
                           String sessionid);
    String getMyProfileBySessionId(String sessionid);
}
