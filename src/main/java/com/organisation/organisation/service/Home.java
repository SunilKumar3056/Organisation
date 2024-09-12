package com.organisation.organisation.service;

import com.organisation.organisation.models.Students;
import org.springframework.stereotype.Service;

import java.util.List;

public interface Home {
    List<Students> getStudentInfo();
    Students addStudent(Students student);
    List<Students> getStudent(int id);
    List<Students> getStudent(String name);
}
