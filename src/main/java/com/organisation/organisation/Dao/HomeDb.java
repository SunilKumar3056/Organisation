package com.organisation.organisation.Dao;

import com.organisation.organisation.models.Students;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HomeDb extends MongoRepository<Students, String> {
    @Query(value = "{}", collation = "{ 'locale' : 'en', 'strength': 2 }")
    List<Students> findAllWithCollation();
    // This will return a student by their ID (or any other unique identifier)
    @Query(value = "{}", collation = "{ 'locale' : 'en', 'strength': 2 }")
    Optional<Students> findById(int id);

    // You can add other queries, like finding by a specific field
    @Query(value = "{ 'name': ?0 }", collation = "{ 'locale': 'en', 'strength': 2 }")
    List<Students> findByName(String name);

}
