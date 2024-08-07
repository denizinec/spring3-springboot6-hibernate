package com.deniz.demosecurity.dao;

import com.deniz.demosecurity.entity.User;

public interface UserDao {

    User findByUserName(String userName);


}
