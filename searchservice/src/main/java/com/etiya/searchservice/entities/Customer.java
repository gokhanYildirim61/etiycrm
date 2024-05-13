package com.etiya.searchservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "search-customer")
public class Customer {
    @Id
    private String id;

    @Field(name = "firstName")
    private String firstName;

    @Field(name = "middleName")
    private String middleName;

    @Field(name = "lastname")
    private String lastName;

    @Field(name = "motherName")
    private String motherName;

    @Field(name = "fatherName")
    private String fatherName;

    @Field(name = "gender")
    private String gender;

    @Field(name = "nationalityId")
    private String nationalityId;

    @Field(name = "birthDate")
    private LocalDate birthDate;

    @Field(name = "deletedDate")
    private LocalDateTime deletedDate;



}