package com.service;

import com.model.Student;

/**
 * @author:San Jinhong
 * @create:2018-09-19 16:48:09
 **/

public interface StudentService {

    void addStudent(Student student);

    void removeStudent(Integer sno);

    void modifyStudent(Student student);

    void findStudentBySno(Integer sno);

    void findAllStudent();

}
