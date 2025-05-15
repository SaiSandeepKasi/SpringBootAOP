package com.AIThinkers.AOPDemo;

import com.AIThinkers.AOPDemo.DAO.AccountDAO;
import com.AIThinkers.AOPDemo.DAO.MembershipDAO;
import com.AIThinkers.AOPDemo.Service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
										MembershipDAO theMembershipDAO,
										TrafficFortuneService theTrafficFortuneService){
		return runner ->{

			//demoTheBeforeAdvice(theAccountDAO,theMembershipDAO);
			//demoTheAfterReturningAdvice(theAccountDAO);
			//demoTheAfterThrowingAdvice(theAccountDAO);
			//demoTheAfterAdvice(theAccountDAO);
			//demoTheAroundAdvice(theTrafficFortuneService);

			//demoTheAroundAdviceHandleException(theTrafficFortuneService);
			demoTheAroundAdviceRethrowException(theTrafficFortuneService);
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\n Main Program : demoTheAroundAdviceHandleException");
		
		System.out.println("calling getFortune()");

		boolean tripWire=true;
		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("Fortune is :"+data);
	}


	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\n Main Program : demoTheAroundAdviceHandleException");
		System.out.println("calling getFortune()");

		boolean tripWire=true;
		String data = theTrafficFortuneService.getFortune(tripWire);

		System.out.println("Fortune is :"+data);

	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\n Main Program : demoTheAroundAdvice");
		System.out.println("calling getFortune()");
		String data = theTrafficFortuneService.getFortune();
		System.out.println("Fortune is :"+data);

	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {

		List<Account> theAccounts = null;

		try {
			//add a boolean flag to simulate the exception
			boolean tripWire = true;
			theAccountDAO.findAccounts(tripWire);
		}
		catch (Exception e){
			System.out.println("\n\n Main program..caughrt exception : "+e);
		}
		//displays the Accounts
		System.out.println("\n\n Main Program : demoTheAfterThrowingAdvice");
		System.out.println("____----");

		System.out.println(theAccounts);
		System.out.println("\n");


	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		//call method to field accounts

		List<Account> theAccounts = null;

		try {
			//add a boolean flag to simulate the exception
			boolean tripWire = false;
			theAccountDAO.findAccounts(tripWire);
		}
		catch (Exception e){
			System.out.println("\n\n Main program..caughrt exception : "+e);
		}
		//displays the Accounts
		System.out.println("\n\n Main Program : demoTheAfterThrowingAdvice");
		System.out.println("____----");

		System.out.println(theAccounts);
		System.out.println("\n");

	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO){

		//call method to field accounts

		List<Account> theAccounts = theAccountDAO.findAccounts();

		//displays the Accounts
		System.out.println("\n\n Main Program : demoTheAfterReturningAdvice");
		System.out.println("____----");

		System.out.println(theAccounts);
		System.out.println("\n");


	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO){
		//Call  AcccountDAO business  method
		Account myAccount = new Account();
		myAccount.setName("sandeepsunny");
		myAccount.setLevel("Gold");
		theAccountDAO.addAccount(myAccount,true);
		theAccountDAO.doWork();

		//call the accountDao getter/setter method
		theAccountDAO.setName("sandeeep");
		theAccountDAO.setServiceCode("Gold");

		String name =theAccountDAO.getName();
		String code =theAccountDAO.getServiceCode();

		//call membershipDAO business method

		theMembershipDAO.addSillyMember();
		theMembershipDAO.beActive();



	}


}
