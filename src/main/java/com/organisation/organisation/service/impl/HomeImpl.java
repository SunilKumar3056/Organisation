package com.organisation.organisation.service.impl;

import com.organisation.organisation.Dao.HomeDb;
import com.organisation.organisation.models.Students;
import com.organisation.organisation.service.Home;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class HomeImpl implements Home {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    private HomeDb homeDb;

    @Autowired
    public HomeImpl(HomeDb db){
        this.homeDb=db;
    }
    @Override
    public List<Students> getStudentInfo(){
        logger.info("get all students from db");
        return this.homeDb.findAllWithCollation();
    }
    @Override
    public List<Students> getStudent(int id){
        logger.info("get all students from db");
        return this.homeDb.findById(id).stream().toList();
    }
    @Override
    public List<Students> getStudent(String name) {
        logger.info("get all students from db");
        // If no students are found, return an empty list
        List<Students> students = this.homeDb.findByName(name);
        return students;
    }
    @Override
    public Students addStudent(Students student) {
        // The save method will insert the student into MongoDB
        return homeDb.save(student);
    }
}
