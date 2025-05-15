package com.AIThinkers.AOPDemo.DAO;

import com.AIThinkers.AOPDemo.Account;

import java.util.List;

public interface AccountDAO {

    //add a new method:findAccounts() used @AfterReturn

    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);

    void addAccount(Account theAccount,boolean vipFlag);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);


}
