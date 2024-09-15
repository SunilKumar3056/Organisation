package com.organisation.organisation.service.impl;

import com.organisation.organisation.Dao.TeacherDb;
import com.organisation.organisation.models.Teachers;
import com.organisation.organisation.service.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherImpl implements Teacher {

    private TeacherDb teacherDb;

    @Autowired
    TeacherImpl(TeacherDb db){
        this.teacherDb=db;
    }
    @Override
    public List<Teachers> getTeachersInfo() {
        return teacherDb.findAllWithCollation();
    }
    @Override
    public Teachers addTeacher(Teachers teachers){
        return teacherDb.save(teachers);
    }
}
