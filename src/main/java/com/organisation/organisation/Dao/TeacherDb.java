package com.organisation.organisation.Dao;

import com.organisation.organisation.models.Teachers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDb extends MongoRepository<Teachers,String> {
    @Query(value = "{}", collation = "{ 'locale' : 'en', 'strength': 2 }")
    List<Teachers> findAllWithCollation();
}
