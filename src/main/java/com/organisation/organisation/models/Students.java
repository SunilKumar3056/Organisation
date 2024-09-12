package com.organisation.organisation.models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "students")
public class Students {

    private String name;
    private ObjectId _id;
}
