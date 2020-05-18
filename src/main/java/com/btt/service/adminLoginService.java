package com.btt.service;

public interface adminLoginService {
    String getAllAdminLogin();
    String getLoginByEmailAndPassword(String email, String password);
    String updatePassword(int id,
                          String email,
                          String password,
                          String sessionid
                          );
}
