package com.example.springbootfoodcourtusers.application.dto;

import com.example.springbootfoodcourtusers.domain.model.Rol;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserRequest {
    private String name;
    private String lastName;
    private String document;
    private String cellPhone;
    private LocalDate birthdate;
    private String email;
    private String password;
    private Rol rol;
}
