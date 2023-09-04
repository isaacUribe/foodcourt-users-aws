package com.example.springbootfoodcourtusers.domain.model;



import java.time.LocalDate;
public class User {
    private Long id;
    private String name;
    private String lastName;
    private String document;
    private String cellPhone;
    private LocalDate birthdate;
    private String email;
    private String password;
    private Rol rol;

    public User() {
    }

    public User(Long id, String name, String lastName, String document, String cellPhone, LocalDate birthdate, String email, String password, Rol rol) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.cellPhone = cellPhone;
        this.birthdate = birthdate;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
