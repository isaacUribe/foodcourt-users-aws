package com.example.springbootfoodcourtusers.application.dto;

import com.example.springbootfoodcourtusers.domain.model.Rol;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseByAuth {
    private Long id;
    private String email;
    private String password;
    private Rol rol;
}
