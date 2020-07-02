package com.ab.myonlinedairy.dao;

import com.ab.myonlinedairy.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
    
}
