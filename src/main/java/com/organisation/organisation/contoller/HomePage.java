package com.organisation.organisation.contoller;


import com.organisation.organisation.models.Students;
import com.organisation.organisation.service.Home;
import com.organisation.organisation.service.impl.HomeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomePage {

    private Home home;

    @Autowired
    public HomePage(Home home){
        this.home=home;
    }

    @GetMapping("/student")
    public ResponseEntity<List<Students>> getStudentInfo(){
        return ResponseEntity.ok(home.getStudentInfo());
    }

    @GetMapping("/studentId")
    public ResponseEntity<List<Students>> getStudentInfoById(@RequestParam String id){
        return ResponseEntity.ok(home.getStudent(id));
    }

    @GetMapping("/studentName")
    public ResponseEntity<List<Students>> getStudentInfoByName(@RequestParam String name){
        return ResponseEntity.ok(home.getStudent(name));
    }

    @PostMapping("/student")
    public ResponseEntity<Students> addStudentInfo(@RequestBody Students student){
        return ResponseEntity.ok(home.addStudent(student));
    }

    @PostMapping("/add")
    public Students addStudent(@RequestBody Students student) {
        return home.addStudent(student);
    }
}
