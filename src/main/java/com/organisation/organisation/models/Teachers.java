package com.organisation.organisation.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "teachers")
public class Teachers {
    @Id
    private String id;
    private String name;
    private  String subjectName;
    private int experience;
    private String education;
}
