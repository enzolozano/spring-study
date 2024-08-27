package com.example.springboot.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class OperatorDTO implements Serializable {

    private long id;
    private String name;
    private String password;
    private String email;
    private Date createdAt;
    private Date updatedAt;
}
