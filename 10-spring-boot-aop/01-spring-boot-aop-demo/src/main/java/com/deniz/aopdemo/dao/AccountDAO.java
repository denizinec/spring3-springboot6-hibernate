package com.deniz.aopdemo.dao;

import com.deniz.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();

}
