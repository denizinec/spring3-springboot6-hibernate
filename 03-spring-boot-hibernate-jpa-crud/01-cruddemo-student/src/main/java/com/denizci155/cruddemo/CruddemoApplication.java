package com.denizci155.cruddemo;

import com.denizci155.cruddemo.dao.StudentDAO;
import com.denizci155.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner ->
		{
			// createStudent(studentDAO);

			createMultipleStudent(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);

			// deleteAllStudents(studentDAO);
		};

	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 5;
		Student studentToDelete = studentDAO.findById(studentId);

		System.out.println(String.format("Deleting the student: %s, id: %d", studentToDelete.getFirstName(), studentId));
		System.out.println("Done.");
		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on id: primary key
		int studentId = 3;
		System.out.println("Get student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		// change the first name to "Deniz"

		System.out.println("Updating student ...");
		myStudent.setFirstName("George");

		// update the student

		studentDAO.update(myStudent);

		// display the upgraded student

		System.out.println("Upgraded Student: " + myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {


		// get a list of students

		List<Student> theStudents = studentDAO.findByLastName("Starr");


		// display list of students
		for (Student tempStudent : theStudents) {

			System.out.println(tempStudent);

		}


	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students

		List<Student> theStudents = studentDAO.findAll();

		// display list of students

		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}


	private void readStudent(StudentDAO studentDAO) {

		// create a student object

		System.out.println("Creating the new student object ...");
		Student tempStudent = new Student("Eric","Clapton","claptoneric@gmail.com");

		// save the student

		studentDAO.save(tempStudent);


		// display id of the saved student


		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);


		// retrieve student based on the id: primary key

		System.out.println("Retrieve student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student

		System.out.println("Found the student: " + myStudent);


	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating the 4 new student objects ...");
		Student tempStudent1 = new Student("John","Lennon","lennonjohn@gmail.com");
		Student tempStudent2 = new Student("Paul","McCartney","mccartneypaul@gmail.com");
		Student tempStudent3 = new Student("George","Harrison","harrisongeorge@gmail.com");
		Student tempStudent4 = new Student("Ringo","Starr","starrringo@gmail.com");


		// save the student objects
		System.out.println("Saving the new students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);

		// display all info of new students
		System.out.println("First saved student: " + tempStudent1.getFirstName() + " " + tempStudent1.getLastName());
		System.out.println("Second saved student: " + tempStudent2.getFirstName() + " " + tempStudent2.getLastName());
		System.out.println("Third saved student: " + tempStudent3.getFirstName() + " " + tempStudent3.getLastName());
		System.out.println("Fourth saved student: " + tempStudent4.getFirstName() + " " + tempStudent4.getLastName());


	}

	private void createStudent(StudentDAO studentDAO){

		// create the student object
		System.out.println("Creating the new student object ...");
		Student tempStudent = new Student("Deniz","Inec","denizinec9@gmail.com");
		// save the student object
		System.out.println("Saving the new student ...");
		studentDAO.save(tempStudent);
		// display id of the saved student
		System.out.println("Saved student's Generated id: " + tempStudent.getId());
	}

}
