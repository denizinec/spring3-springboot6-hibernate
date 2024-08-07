package com.deniz.demosecurity.dao;

import com.deniz.demosecurity.entity.Role;

public interface RoleDao {

    public Role findRoleByName(String theRoleName);

}
