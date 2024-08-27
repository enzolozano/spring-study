package com.example.springboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String plate;
    private String model;
    private String color;

    @ManyToOne
    @JoinColumn(name = "resident_owner_id")
    private Resident residentOwner;
}
