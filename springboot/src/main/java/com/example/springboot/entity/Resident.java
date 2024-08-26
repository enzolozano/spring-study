package com.example.springboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "resident")
public class Resident implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String document;
    private String phoneNumber;
    private Date birthDate;
    private Date createdAt;
    private Date updatedAt;
    private String observation;
    private String address;
    private int gender;
    private String photo;
}
