package com.etiya.searchservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "search-contactMedium")
public class ContactMedium {
    @Id
    private String id;
    @Field(name = "mobilePhone")
    private String mobilePhone;
    @Field(name = "homePhone")
    private String homePhone;
    @Field(name = "email")
    private String email;
    @Field(name = "fax")
    private String fax;
    @Field(name = "customerId")
    private String customerId;
}
