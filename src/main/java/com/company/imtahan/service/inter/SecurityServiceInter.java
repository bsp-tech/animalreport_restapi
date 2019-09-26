package com.company.imtahan.service.inter;

import com.company.imtahan.bean.CustomUserDetail;

public interface SecurityServiceInter {

     CustomUserDetail getLoggedInUserDetails();

     void reloadRoles();
}
