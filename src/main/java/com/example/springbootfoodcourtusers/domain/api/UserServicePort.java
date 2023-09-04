package com.example.springbootfoodcourtusers.domain.api;

import com.example.springbootfoodcourtusers.domain.model.User;

import java.util.List;

public interface UserServicePort {

    void createOwner(User user);
    void createEmployee(User user);
    void createCustomer(User user);
    void createAdmin(User user);
    List<User> getAllUsers();
    User getUser(Long idUser);

    User getUserByEmail(String email);
}
