package com.deniz.cruddemo;

import com.deniz.cruddemo.dao.AppDAO;
import com.deniz.cruddemo.entity.*;
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

				//findCourseAndStudents(appDAO);
				//findStudentAndCourses(appDAO);
				//addMoreCoursesForStudent(appDAO);
				//deleteCourse(appDAO);
				deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {

		int theId = 5;
		System.out.println("Deleting the student: " + theId);

		appDAO.deleteStudentById(theId);
		System.out.println("Done!!!");

	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {

		int theId = 5;

		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		// create more courses

		Course tempCourse1 = new Course("Rubik's Cube - How to Speed Cube");
		Course tempCourse2 = new Course("Atari 2600 - Game Development");

		// add courses to student

		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);

		System.out.println("Updating the student: " + tempStudent);

		System.out.println("Courses: " + tempStudent.getCourses());

		appDAO.update(tempStudent);

		System.out.println("Done!!");


	}

	private void findStudentAndCourses(AppDAO appDAO) {


		int theId = 5;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		System.out.println("Loading student: " + tempStudent);

		System.out.println("Courses: " + tempStudent.getCourses());

		System.out.println("Done!!!");


	}

	private void findCourseAndStudents(AppDAO appDAO) {

		int theId = 14;

		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);

		System.out.println("Loaded course: " + tempCourse);
		System.out.println("Students: " + tempCourse.getStudents());

		System.out.println("Done!!!");

	}

	private void createCourseAndStudents(AppDAO appDAO) {

		// course creating
		Course tempCourse = new Course("Hello World in Assembly Language!");
		// student creating
		Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
		// add student to the course
		tempCourse.addStudents(tempStudent1);
		tempCourse.addStudents(tempStudent2);
		// save the course and associated students
		System.out.println("Saving the course: " + tempCourse);
		System.out.println("Associated Students: " + tempCourse.getStudents());

		appDAO.save(tempCourse);

		System.out.println("Done!!!");


	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int theId = 10;

		System.out.println("Deleting the course id: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done!! ");



	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		// get the course and reviews

		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		// print the course

		System.out.println(tempCourse);

		// print the associated reviews

		System.out.println(tempCourse.getReviews());

		System.out.println("Done!!");

	}

	private void createCourseAndReviews(AppDAO appDAO) {

		// create a course

		Course tempCourse = new Course("Pacman - How To Score One Million");

		// add some reviews

		tempCourse.addReview(new Review("Hey, great course... loved it!!"));
		tempCourse.addReview(new Review("Cool course, job well done!!"));
		tempCourse.addReview(new Review("Finally managed to get 1m score... LOL!!"));
		tempCourse.addReview(new Review("What a dumb course... Will refund."));

		// save the course ... and leverage the cascade all

		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);

		System.out.println("Done!!");

	}

	private void deleteCourse(AppDAO appDAO) {

		int theId = 14;
		System.out.println("Deleting the course id: " + theId);
		appDAO.deleteCourseById(theId);

		System.out.println("Done!!");


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
