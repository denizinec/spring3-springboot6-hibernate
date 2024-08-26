package com.deniz.aopdemo.dao;

import com.deniz.aopdemo.Account;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;

    private String serviceCode;


    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT.\n");

    }

    @Override
    public boolean doWork() {

        System.out.println(getClass() + ": doWork(); \n");

        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName(); ");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName(); ");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode(); \n");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode(); ");
        this.serviceCode = serviceCode;
    }
}
