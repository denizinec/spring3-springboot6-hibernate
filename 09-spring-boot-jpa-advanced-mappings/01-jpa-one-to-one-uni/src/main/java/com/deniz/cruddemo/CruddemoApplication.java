package com.deniz.cruddemo;

import com.deniz.cruddemo.dao.AppDAO;
import com.deniz.cruddemo.entity.Instructor;
import com.deniz.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner -> {

			// createInstructor(appDAO);
			// findInstructorById(appDAO);
			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Done!!");


	}

	private void findInstructorById(AppDAO appDAO) {

		int theId = 2;

		System.out.println("Finding Instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated InstructorDetail only: " + tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {

		/* Instructor tempInstructor = new
				Instructor("Chad","Darby","darby@luv2code.com");

		InstructorDetail tempInstructorDetail = new
				InstructorDetail("http://www.luv2code.com/youtube","Luv2Code!!!");
		*/
		Instructor tempInstructor = new
				Instructor("Deniz","Inec","denizinec9 @gmail.com");

		InstructorDetail tempInstructorDetail = new
				InstructorDetail("-","Guitar!");



		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// saving only the instructor will also save the instructor's detail because of CascadeType.ALL

		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!!!");



	}

}
