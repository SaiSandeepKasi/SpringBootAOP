package com.AIThinkers.AOPDemo.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public boolean addSillyMember() {
        System.out.println(getClass()+": DOING MY DB WORK :ADDING A MEMBERSHIP ACCOUNT");

        return true;
    }

    @Override
    public void beActive() {
        System.out.println(getClass()+": Be Active Don't go to sleep");
    }
}
