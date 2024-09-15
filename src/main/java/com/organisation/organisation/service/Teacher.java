package com.organisation.organisation.service;

import com.organisation.organisation.models.Teachers;

import java.util.List;

public interface Teacher {
    List<Teachers> getTeachersInfo();
    Teachers addTeacher(Teachers teachers);
}
