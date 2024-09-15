package com.organisation.organisation.contoller;


import com.organisation.organisation.models.Students;
import com.organisation.organisation.models.Teachers;
import com.organisation.organisation.service.Home;
import com.organisation.organisation.service.Teacher;
import com.organisation.organisation.service.impl.HomeImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomePage {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Home home;
    private Teacher teacher;

    @Autowired
    public HomePage(Home home, Teacher teacher) {
        this.home = home;
        this.teacher=teacher;
    }

    @GetMapping("/student")
    public ResponseEntity<List<Students>> getStudentInfo() {
        return ResponseEntity.ok(home.getStudentInfo());
    }

    @GetMapping("/studentId")
    public ResponseEntity<List<Students>> getStudentInfoById(@RequestParam String id) {
        return ResponseEntity.ok(home.getStudent(id));
    }

    @GetMapping("/studentName")
    public ResponseEntity<List<Students>> getStudentInfoByName(@RequestParam String name) {
        return ResponseEntity.ok(home.getStudent(name));
    }

    @PostMapping("/student")
    public ResponseEntity<Students> addStudentInfo(@RequestBody Students student) {
        logger.info(String.valueOf(student));
        return ResponseEntity.ok(home.addStudent(student));
    }

    @DeleteMapping("studentName/{name}")
    public ResponseEntity<String> deleteRecord(@PathVariable("name") String name) {
        boolean isDeleted = home.deleteRecordByName(name);
        if (isDeleted) {
            return ResponseEntity.ok("Record deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found");
        }
    }
    @GetMapping("/teachers")
    public ResponseEntity<List<Teachers>>getTeachersInfo(){
        return ResponseEntity.ok(teacher.getTeachersInfo());
    };

    @PostMapping("/teachers")
    public ResponseEntity<Teachers>addTeacherInfo(@RequestBody Teachers teachers){
        return ResponseEntity.ok(teacher.addTeacher(teachers));
    }
}
