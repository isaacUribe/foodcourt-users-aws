package com.example.springbootfoodcourtusers.application.handler;

import com.example.springbootfoodcourtusers.application.dto.UserRequest;
import com.example.springbootfoodcourtusers.application.dto.UserResponse;
import com.example.springbootfoodcourtusers.application.dto.UserResponseByAuth;
import com.example.springbootfoodcourtusers.application.mapper.UserRequestMapper;
import com.example.springbootfoodcourtusers.application.mapper.UserResponseAuthMapper;
import com.example.springbootfoodcourtusers.application.mapper.UserResponseMapper;
import com.example.springbootfoodcourtusers.domain.api.UserServicePort;
import com.example.springbootfoodcourtusers.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class UserHandlerImplement implements UserHandler{

    private final UserServicePort userServicePort;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;
    private final UserResponseAuthMapper userResponseAuthMapper;


    @Override
    public void createOwner(UserRequest userRequest) {
        User user = userRequestMapper.toUser(userRequest);
        userServicePort.createOwner(user);
    }

    @Override
    public void createEmployee(UserRequest userRequest) {
        User user = userRequestMapper.toUser(userRequest);
        userServicePort.createEmployee(user);
    }

    @Override
    public void createCustomer(UserRequest userRequest) {
        User user = userRequestMapper.toUser(userRequest);
        userServicePort.createCustomer(user);
    }

    @Override
    public void createAdmin(UserRequest userRequest) {
        User user = userRequestMapper.toUser(userRequest);
        userServicePort.createAdmin(user);
    }

    @Override
    public List<UserResponse> gellAllUsers() {
        return userResponseMapper.toUserResponseList(userServicePort.getAllUsers());
    }

    @Override
    public UserResponse getUser(Long idUser) {
        return userResponseMapper.toUserResponse(userServicePort.getUser(idUser));
    }

    @Override
    public UserResponseByAuth getUserByEmail(String email) {
        return userResponseAuthMapper.toUserResponseAuth(userServicePort.getUserByEmail(email));
    }
}
