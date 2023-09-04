package com.example.springbootfoodcourtusers.domain.spi;

import com.example.springbootfoodcourtusers.domain.model.User;

import java.util.List;

public interface UserPersistancePort {
    void createOwner(User user);
    void createEmployee(User user);
    void createCustomer(User user);
    void createAdmin(User user);
    List<User> getAllUser();
    User getUser(Long idUser);
    User getUserByEmail(String email);
}
