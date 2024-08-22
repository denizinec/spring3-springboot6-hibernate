package com.deniz.aopdemo;

import com.deniz.aopdemo.dao.AccountDAO;
import com.deniz.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(AopdemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){

		return runner -> {

			demoTheBeforeAdvice(accountDAO, membershipDAO);

		};

	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {

		// call the business method
		accountDAO.addAccount();

		// call the membership one

		membershipDAO.addAccount();

		/*
		// re-do
		System.out.println("\n calling the business method again\n");

		accountDAO.addAccount();
		membershipDAO.addAccount();
		*/


	}


}
