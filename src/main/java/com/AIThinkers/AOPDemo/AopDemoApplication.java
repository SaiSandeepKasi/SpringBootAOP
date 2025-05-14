package com.AIThinkers.AOPDemo;

import com.AIThinkers.AOPDemo.DAO.AccountDAO;
import com.AIThinkers.AOPDemo.DAO.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,MembershipDAO theMembershipDAO){
		return runner ->{

			demoTheBeforeAdvice(theAccountDAO,theMembershipDAO);

		};
	}


	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO){
		//Call business model method
		theAccountDAO.addAccount();

		//call membership business method

		theMembershipDAO.addSillyMember();



	}


}
