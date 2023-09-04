package com.example.springbootfoodcourtusers.domain.usecase;

import com.example.springbootfoodcourtusers.domain.model.Rol;
import com.example.springbootfoodcourtusers.domain.model.User;
import com.example.springbootfoodcourtusers.domain.spi.UserPersistancePort;
import com.example.springbootfoodcourtusers.domain.validation.UserValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserUseCaseTest {
    @InjectMocks
    UserUseCase userUseCase;
    private User user;
    private Rol rol;
    @Mock
    UserPersistancePort userPersistancePort;
    @Mock
    UserValidation userValidation;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setName("Ejemplo de nombre");
        user.setLastName("Ejemplo de apellido");
        user.setDocument("12231232");
        user.setCellPhone("+12312312");
        user.setBirthdate(LocalDate.of(2000,10,10));
        user.setEmail("test@example.com");
        user.setPassword("password");
        rol = new Rol();
        rol.setId(2L);
        user.setRol(rol);
    }

    @Test
    void createOwner() {
        userUseCase.createOwner(user);
        verify(userPersistancePort, times(1)).createOwner(user);
    }
    @Test
    void createEmployee(){
        userUseCase.createEmployee(user);
        verify(userPersistancePort, times(1)).createEmployee(user);
    }
    @Test
    void createCustomer(){
        userUseCase.createCustomer(user);
        verify(userPersistancePort, times(1)).createCustomer(user);
    }
    @Test
    void createAdmin(){
        userUseCase.createAdmin(user);
        verify(userPersistancePort, times(1)).createAdmin(user);
    }

    @Test
    void getAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(user);
        when(userPersistancePort.getAllUser()).thenReturn(userList);
        List<User> users = userUseCase.getAllUsers();
        verify(userPersistancePort, times(1)).getAllUser();
    }

    @Test
    void getUser() {
        when(userPersistancePort.getUser(1L)).thenReturn(user);
        User result = userUseCase.getUser(1L);
        assertEquals(result, user);
    }

    @Test
    void getUserByEmail() {
        when(userPersistancePort.getUserByEmail("example@email.com")).thenReturn(user);
        User result = userUseCase.getUserByEmail("example@email.com");
        assertEquals(result, user);
    }
}