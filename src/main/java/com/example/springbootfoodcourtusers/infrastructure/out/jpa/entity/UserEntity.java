package com.example.springbootfoodcourtusers.infrastructure.out.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String document;
    private String cellPhone;
    private LocalDate birthdate;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "idRol" )
    private RolEntity rol;


}
