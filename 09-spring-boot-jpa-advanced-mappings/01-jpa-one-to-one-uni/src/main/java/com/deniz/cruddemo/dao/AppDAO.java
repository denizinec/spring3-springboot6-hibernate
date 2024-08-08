package com.deniz.cruddemo.dao;

import com.deniz.cruddemo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

}
