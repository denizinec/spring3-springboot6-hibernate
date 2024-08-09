package com.deniz.cruddemo.dao;

import com.deniz.cruddemo.entity.Course;
import com.deniz.cruddemo.entity.Instructor;
import com.deniz.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

}
