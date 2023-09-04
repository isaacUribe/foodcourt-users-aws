package com.example.springbootfoodcourtusers.domain.model;

public class Rol {
    private Long id;
    private String  rol;
    private String description;

    public Rol() {
    }

    public Rol(Long id, String rol, String description) {
        this.id = id;
        this.rol = rol;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
