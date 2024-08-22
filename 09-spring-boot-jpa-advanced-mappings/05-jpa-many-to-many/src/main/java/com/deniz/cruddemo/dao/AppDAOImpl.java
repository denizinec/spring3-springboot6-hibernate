package com.deniz.cruddemo.dao;

import com.deniz.cruddemo.entity.Course;
import com.deniz.cruddemo.entity.Instructor;
import com.deniz.cruddemo.entity.InstructorDetail;
import com.deniz.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{

    // define field for entity manager

    private EntityManager entityManager;

    // inject entity manager using constructor injection

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {

        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {

        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {


        // retrieve the instructor

        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        // get the courses

        List<Course> courses = tempInstructor.getCourses();

        // break association of all courses for the instructor

        for(Course tempCourse : courses){

            tempCourse.setInstructor(null);

        }

        // delete the instructor

        entityManager.remove(tempInstructor);


    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {


        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        // remove the associated object reference
        // break bi-directional link
        //
        tempInstructorDetail.getInstructor().setInstructorDetail(null);


        // delete the instructor detail

        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {

        TypedQuery<Course> query =  entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data",theId);

        List<Course> courses = query.getResultList();

        return courses;
    }


    // join fetch approach
    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {

        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i " +
                "JOIN FETCH i.courses " +
                "where i.id = :data", Instructor.class);
        query.setParameter("data",theId);

        Instructor instructor = query.getSingleResult();



        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {

        entityManager.merge(tempInstructor);


    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);    }

    @Override
    @Transactional
    public void update(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {

        Course tempCourse = entityManager.find(Course.class, theId);

        entityManager.remove(tempCourse);

    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {

        // create query
        TypedQuery<Course>  query = entityManager.createQuery("select c from Course c " + "JOIN FETCH c.reviews " + "" +
                "where c.id = :data", Course.class);
        query.setParameter("data", theId);
        // execute query

        Course course = query.getSingleResult();

        return course;
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int theId) {

        // create query
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "
                        + "JOIN FETCH c.students "
                        + "where c.id = :data", Course.class);
        query.setParameter("data", theId);
        // execute query

        Course course = query.getSingleResult();

        return course;
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int theId) {

        // create query
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s "
                        + "JOIN FETCH s.courses "
                        + "where s.id = :data", Student.class);
        query.setParameter("data", theId);
        // execute query

        Student student = query.getSingleResult();

        return student;
    }

    @Override
    @Transactional
    public void update(Student tempStudent) {
        entityManager.merge(tempStudent);
    }

    @Override
    @Transactional
    public void deleteStudentById(int theId) {

        Student tempStudent = entityManager.find(Student.class, theId);

        entityManager.remove(tempStudent);


    }
}
