package com.example.springboot.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class VisitorDTO implements Serializable {

    private long id;
    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Document is required")
    private String document;
    private String phoneNumber;
    private Date createdAt;
    private Date lastVisit;
    private String observation;
    @NotNull(message = "Last visited resident ID is required")
    private long lastVisitedResidentId;
}
