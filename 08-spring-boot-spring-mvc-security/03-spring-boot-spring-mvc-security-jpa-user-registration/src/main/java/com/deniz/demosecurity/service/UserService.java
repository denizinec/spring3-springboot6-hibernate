package com.deniz.demosecurity.service;


import com.deniz.demosecurity.entity.User;
import com.deniz.demosecurity.user.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.UserDetailsManager;

public interface UserService extends UserDetailsService {

    public User findByUserName(String userName);

    void save(WebUser webUser);

}
