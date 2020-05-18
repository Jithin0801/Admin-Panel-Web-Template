package com.btt.business;

import com.btt.service.adminLoginService;
import com.btt.util.ApplicationContextProvider;

public class b_adminlogin {
    public String getAllAdminLogin() {
        adminLoginService cs = ApplicationContextProvider.getBean("adminLoginService", adminLoginService.class);
        return cs.getAllAdminLogin();
    }
    public String getLoginByEmailAndPassword(String email, String password) {
        adminLoginService cs = ApplicationContextProvider.getBean("adminLoginService", adminLoginService.class);
        return cs.getLoginByEmailAndPassword(email,password);
    }
    public String updatePassword(int id, String email, String password, String sessionid) {
        adminLoginService cs = ApplicationContextProvider.getBean("adminLoginService", adminLoginService.class);
        return cs.updatePassword(id,email,password,sessionid);
    }

}