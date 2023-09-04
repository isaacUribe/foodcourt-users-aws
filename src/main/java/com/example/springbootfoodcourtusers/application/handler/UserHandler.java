package com.example.springbootfoodcourtusers.application.handler;

import com.example.springbootfoodcourtusers.application.dto.UserRequest;
import com.example.springbootfoodcourtusers.application.dto.UserResponse;
import com.example.springbootfoodcourtusers.application.dto.UserResponseByAuth;

import java.util.List;

public interface UserHandler {
    void createOwner(UserRequest userRequest);
    void createEmployee(UserRequest userRequest);
    void createCustomer(UserRequest userRequest);
    void createAdmin(UserRequest userRequest);
    List<UserResponse> gellAllUsers();
    UserResponse getUser(Long idUser);
    UserResponseByAuth getUserByEmail(String email);
}
