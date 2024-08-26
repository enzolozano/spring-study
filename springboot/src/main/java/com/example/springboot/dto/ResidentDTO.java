package com.example.springboot.dto;

import com.example.springboot.enumerator.Gender;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class ResidentDTO implements Serializable {

    private long id;
    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Document is required")
    private String document;
    private String phoneNumber;
    private Date birthDate;
    private Date createdAt;
    private Date updatedAt;
    private String observation;
    @NotEmpty(message = "Address is required")
    private String address;
    private Gender gender;
    private String photo;
}
