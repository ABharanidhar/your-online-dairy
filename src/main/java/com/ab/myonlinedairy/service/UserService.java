package com.ab.myonlinedairy.service;

import com.ab.myonlinedairy.entity.User;
import com.ab.myonlinedairy.user.CrmUser;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);
}
