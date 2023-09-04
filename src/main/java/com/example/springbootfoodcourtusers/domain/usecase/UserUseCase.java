package com.example.springbootfoodcourtusers.domain.usecase;

import com.example.springbootfoodcourtusers.domain.api.UserServicePort;
import com.example.springbootfoodcourtusers.domain.model.User;
import com.example.springbootfoodcourtusers.domain.spi.UserPersistancePort;
import com.example.springbootfoodcourtusers.domain.validation.UserValidation;

import java.util.List;

public class UserUseCase implements UserServicePort {

    private final UserPersistancePort userPersistancePort;
    private final UserValidation userValidation;

    public UserUseCase(UserPersistancePort userPersistancePort, UserValidation userValidation) {
        this.userPersistancePort = userPersistancePort;
        this.userValidation = userValidation;
    }


    @Override
    public void createOwner(User user) {
        userValidation.validateEmptyField(user.getName());
        userValidation.validateEmptyField(user.getLastName());
        userValidation.validateDocument(user.getDocument());
        userValidation.validateCellPhone(user.getCellPhone());
        userValidation.validateAge(user.getBirthdate());
        userValidation.validateEmail(user.getEmail());
        userValidation.validateEmptyField(user.getPassword());
        userValidation.validateRol(user.getRol());
        userValidation.validateIfIdIsNull(user.getRol().getId());
        userPersistancePort.createOwner(user);
    }

    @Override
    public void createEmployee(User user) {
        userValidation.validateEmptyField(user.getName());
        userValidation.validateEmptyField(user.getLastName());
        userValidation.validateDocument(user.getDocument());
        userValidation.validateCellPhone(user.getCellPhone());
        userValidation.validateAge(user.getBirthdate());
        userValidation.validateEmail(user.getEmail());
        userValidation.validateEmptyField(user.getPassword());
        userValidation.validateRol(user.getRol());
        userValidation.validateIfIdIsNull(user.getRol().getId());
        userPersistancePort.createEmployee(user);
    }

    @Override
    public void createCustomer(User user) {
        userValidation.validateEmptyField(user.getName());
        userValidation.validateEmptyField(user.getLastName());
        userValidation.validateDocument(user.getDocument());
        userValidation.validateCellPhone(user.getCellPhone());
        userValidation.validateBirthdate(user.getBirthdate());
        userValidation.validateEmail(user.getEmail());
        userValidation.validateEmptyField(user.getPassword());
        userValidation.validateRol(user.getRol());
        userValidation.validateIfIdIsNull(user.getRol().getId());
        userPersistancePort.createCustomer(user);
    }

    @Override
    public void createAdmin(User user) {
        userValidation.validateEmptyField(user.getName());
        userValidation.validateEmptyField(user.getLastName());
        userValidation.validateDocument(user.getDocument());
        userValidation.validateCellPhone(user.getCellPhone());
        userValidation.validateBirthdate(user.getBirthdate());
        userValidation.validateEmail(user.getEmail());
        userValidation.validateEmptyField(user.getPassword());
        userValidation.validateRol(user.getRol());
        userValidation.validateIfIdIsNull(user.getRol().getId());
        userPersistancePort.createAdmin(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userPersistancePort.getAllUser();
    }

    @Override
    public User getUser(Long idUser) {
        return userPersistancePort.getUser(idUser);
    }

    @Override
    public User getUserByEmail(String email) {
        return userPersistancePort.getUserByEmail(email);
    }
}
