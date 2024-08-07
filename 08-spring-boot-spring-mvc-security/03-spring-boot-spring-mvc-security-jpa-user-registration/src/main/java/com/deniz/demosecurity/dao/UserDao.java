package com.deniz.demosecurity.dao;

import com.deniz.demosecurity.entity.User;
import jakarta.transaction.Transactional;

public interface UserDao {

    User findByUserName(String userName);

    void save(User theUser);
}
