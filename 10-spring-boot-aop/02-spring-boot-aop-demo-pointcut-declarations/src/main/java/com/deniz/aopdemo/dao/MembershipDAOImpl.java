package com.deniz.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public void addAccount() {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT.\n");

    }

    @Override
    public void goToSleep() {

        System.out.println(getClass() + ": I'm going to sleep now...\n");


    }
}
