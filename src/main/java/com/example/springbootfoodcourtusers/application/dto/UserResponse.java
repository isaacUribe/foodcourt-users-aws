package com.example.springbootfoodcourtusers.application.dto;

import com.example.springbootfoodcourtusers.domain.model.Rol;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private String name;
    private String lastName;
    private String cellPhone;
    private String email;
    private Rol rol;

}
