package com.example.springboot.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class UnityDTO implements Serializable {

    private long id;

    @NotEmpty(message = "Description is required")
    private String description;

    @NotEmpty(message = "Block is required")
    private String block;

    @NotEmpty(message = "Lot is required")
    private String lot;

    private String observation;

    private Date createdAt;

    private Date updatedAt;

    private long operatorId;
}
