package com.example.springboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "visitor")
public class Visitor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String document;
    private String phoneNumber;
    private Date createdAt;
    private Date lastVisit;
    private String observation;

    @ManyToOne
    @JoinColumn(name = "last_visited_resident_id")
    private Resident lastVisitedResident;

}
