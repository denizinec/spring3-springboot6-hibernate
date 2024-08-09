package com.deniz.cruddemo;

import com.deniz.cruddemo.dao.AppDAO;
import com.deniz.cruddemo.entity.Course;
import com.deniz.cruddemo.entity.Instructor;
import com.deniz.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
			// deleteInstructor(appDAO);
			// findInstructorDetail(appDAO);
			// deleteInstructorDetail(appDAO);
			// createInstructorWithCourses(appDAO);
			// findInstructorWithCourses(appDAO);
			// findCoursesForInstructor(appDAO);
			//findInstructorWithCoursesJoinFetch(appDAO);
			// updateInstructor(appDAO);
			updateCourse(appDAO);
		};
	}

	private void updateCourse(AppDAO appDAO) {

		int theId = 10;

		// find the instructor
		System.out.println("Finding course id: " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		// update the instructor

		System.out.println("Updating the course id: " + theId);
		tempCourse.setTitle("Enjoy the Simple Things");

		appDAO.update(tempCourse);

		System.out.println("Done!!");

	}

	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;

		// find the instructor
		System.out.println("Finding the instructor: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		// update the instructor

		System.out.println("Updating the instructor " + theId);
		tempInstructor.setLastName("TESTER");

		appDAO.update(tempInstructor);

		System.out.println("Done!!");


	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 1;

		// find the instructor

		System.out.println("Finding the instructor: " + theId);

		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!!");


	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int theId = 1;

		System.out.println("Finding Instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);

		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!!");


	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId = 1;

		System.out.println("Finding Instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);

		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!!");

	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor tempInstructor = new
				Instructor("Susan","Public","susan@luv2code.com");

		InstructorDetail tempInstructorDetail = new
				InstructorDetail("-","Video Games");


		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		System.out.println("Saving the instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done!!");

	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 6;
		System.out.println("Deleting InstructorDetail id: " + theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done!!");


	}

	private void findInstructorDetail(AppDAO appDAO) {

		int theId = 2;

		System.out.println("Finding InstructorDetail id: " + theId);

		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		System.out.println("tempInstructorDetail: " + tempInstructorDetail);
		System.out.println("the associated Instructor only: " + tempInstructorDetail.getInstructor());
		System.out.println("Done!!");

	}

	private void deleteInstructor(AppDAO appDAO) {

		int theId = 4;
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

		Instructor tempInstructor = new
				Instructor("Chad","Darby","darby@luv2code.com");

		InstructorDetail tempInstructorDetail = new
				InstructorDetail("http://www.luv2code.com/youtube","Luv2Code!!!");
		/*
		Instructor tempInstructor = new
				Instructor("Deniz","Inec","denizinec9@gmail.com");

		InstructorDetail tempInstructorDetail = new
				InstructorDetail("-","Guitar!");
		*/


		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// saving only the instructor will also save the instructor's detail because of CascadeType.ALL

		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!!!");



	}

}
