package com.example.springbootfoodcourtusers.domain.model;

public class Rol {
    private Long id;
    private String rolUser;
    private String description;

    public Rol() {
    }

    public Rol(Long id, String rolUser, String description) {
        this.id = id;
        this.rolUser = rolUser;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolUser() {
        return rolUser;
    }

    public void setRolUser(String rolUser) {
        this.rolUser = rolUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
