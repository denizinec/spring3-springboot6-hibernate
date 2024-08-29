package com.deniz.aopdemo;

import com.deniz.aopdemo.dao.AccountDAO;
import com.deniz.aopdemo.dao.MembershipDAO;
import com.deniz.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(AopdemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,
											   MembershipDAO membershipDAO,
											   TrafficFortuneService trafficFortuneService){

		return runner -> {

			// demoTheBeforeAdvice(accountDAO, membershipDAO);
			// demoTheAfterReturningAdvice(accountDAO);
			// demoTheAfterThrowingAdvice(accountDAO);
			// demoTheAfterAdvice(accountDAO);
			// demoTheAroundAdvice(trafficFortuneService);
			// demoTheAroundAdviceHandleException(trafficFortuneService);
			demoTheAroundAdviceRethrowException(trafficFortuneService);
		};

	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {

		System.out.println("\nMain Program: demoTheAroundAdviceRethrowException");


		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("\n My Fortune is: " + data);

		System.out.println("Finished.");

	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {

		System.out.println("\nMain Program: demoTheAroundAdviceHandleException");


		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("\n My Fortune is: " + data);

		System.out.println("Finished.");

	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {

		System.out.println("\nMain Program: demoTheAroundAdvice");


		System.out.println("Calling getFortune()");

		String data = trafficFortuneService.getFortune();

		System.out.println("\nMy Fortune is: " + data);

		System.out.println("Finished.");

	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {

		List<Account> theAccounts = null;

		try {
			boolean tripWire = false;
			accountDAO.findAccounts(tripWire);

		}catch (Exception exc){
			System.out.println("\n\nMain Program: ... caught exception " + exc);

		}
		// display the accounts

		System.out.println("\n\nMain Program: demoTheAfterAdvice");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");


	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {

		List<Account> theAccounts = null;

		try {
			boolean tripWire = true;
			accountDAO.findAccounts(tripWire);

		}catch (Exception exc){
			System.out.println("\n\nMain Program: ... caught exception " + exc);

		}
		// display the accounts

		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");

	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {

		List<Account> theAccounts = accountDAO.findAccounts();

		// display the accounts

		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");

	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		// call the business method
		Account myAccount = new Account();
		myAccount.setName("deno");
		myAccount.setLevel("199");

		accountDAO.addAccount(myAccount,true);
		accountDAO.doWork();


		// call the AccountDAO getter/setter methods

		accountDAO.setName("deno");
		accountDAO.setServiceCode("123");

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();


		// call the membership one

		membershipDAO.addAccount();
		membershipDAO.goToSleep();
		/*
		// re-do
		System.out.println("\n calling the business method again\n");

		accountDAO.addAccount();
		membershipDAO.addAccount();
		*/


	}


}
