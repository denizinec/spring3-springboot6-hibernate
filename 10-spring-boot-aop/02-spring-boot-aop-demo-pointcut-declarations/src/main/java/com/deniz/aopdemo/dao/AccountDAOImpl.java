package com.deniz.aopdemo.dao;

import com.deniz.aopdemo.Account;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;

    private String serviceCode;


    @Override
    public List<Account> findAccounts() {

        return findAccounts(false);

    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        List<Account> myAccounts = new ArrayList<>();

        // simulating an exception

        if (tripWire){

            throw new RuntimeException("Failed. This is an exception!!");

        }

        // sample accounts

        Account temp1 = new Account("Deniz","Gold");
        Account temp2 = new Account("George","Platinum");
        Account temp3 = new Account("Ringo","Silver");
        Account temp4 = new Account("John","Gold");
        Account temp5 = new Account("Paul","Gold");

        // add them to our accounts list

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);
        myAccounts.add(temp4);
        myAccounts.add(temp5);

        return myAccounts;
    }

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
