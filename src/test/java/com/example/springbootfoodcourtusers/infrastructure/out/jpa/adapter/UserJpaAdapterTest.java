package com.example.springbootfoodcourtusers.infrastructure.out.jpa.adapter;

import com.example.springbootfoodcourtusers.domain.model.Rol;
import com.example.springbootfoodcourtusers.domain.model.User;
import com.example.springbootfoodcourtusers.infrastructure.exception.IdNotExit;
import com.example.springbootfoodcourtusers.infrastructure.exception.InfrasEmaiExist;
import com.example.springbootfoodcourtusers.infrastructure.exception.InfrasWrongRolOwner;
import com.example.springbootfoodcourtusers.infrastructure.out.jpa.entity.RolEntity;
import com.example.springbootfoodcourtusers.infrastructure.out.jpa.entity.Role;
import com.example.springbootfoodcourtusers.infrastructure.out.jpa.entity.UserEntity;
import com.example.springbootfoodcourtusers.infrastructure.out.jpa.mapper.UserEntityMapper;
import com.example.springbootfoodcourtusers.infrastructure.out.jpa.repository.RolRepository;
import com.example.springbootfoodcourtusers.infrastructure.out.jpa.repository.UserRepository;
import com.example.springbootfoodcourtusers.domain.validation.UserValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserJpaAdapterTest {
    private User user;
    private Rol rol;
    private Role role;

    private UserEntity userEntity;
    private RolEntity rolEntity;

    @InjectMocks
    UserJpaAdapter userJpaAdapter;
    @Mock
    UserValidation userValidation;

    @Mock
    RolRepository rolRepository;

    @Mock
    UserEntityMapper userEntityMapper;
    @Mock
    UserRepository userRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void saveUser() {
        String email = "exmaple@email.com";
        when(rolRepository.findById(2L)).thenReturn(Optional.of(new RolEntity()));
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        Rol rol = new Rol();
        rol.setId(2L);
        user.setRol(rol);
        userJpaAdapter.createOwner(user);
        verify(userRepository, times(1)).save(userEntityMapper.toUserEntity(user));
    }
    @Test
    void saveUserIdNotExist(){
        when(rolRepository.findById(1L)).thenReturn(Optional.empty());
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        Rol rol = new Rol();
        rol.setId(2L);
        user.setRol(rol);
        assertThrows(IdNotExit.class, ()->userJpaAdapter.createOwner(user));
    }
    @Test
    void saveUserWrongRol(){
        when(rolRepository.findById(1L)).thenReturn(Optional.of(new RolEntity()));
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        Rol rol = new Rol();
        rol.setId(1L);
        user.setRol(rol);
        assertThrows(InfrasWrongRolOwner.class, ()->userJpaAdapter.createOwner(user));
    }
    @Test
    void saveUserIdExist(){
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        Rol rol = new Rol();
        rol.setId(2L);
        user.setRol(rol);
        when(rolRepository.findById(2L)).thenReturn(Optional.of(new RolEntity()));
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(new UserEntity()));
        assertThrows(InfrasEmaiExist.class, ()->userJpaAdapter.createOwner(user));
    }
    @Test
    void saveEmployee(){
        String email = "exmaple@email.com";
        when(rolRepository.findById(4L)).thenReturn(Optional.of(new RolEntity()));
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        Rol rol = new Rol();
        rol.setId(4L);
        user.setRol(rol);
        userJpaAdapter.createEmployee(user);
        verify(userRepository, times(1)).save(userEntityMapper.toUserEntity(user));
    }
    @Test
    void saveEmployeeIdNotExist(){
        when(rolRepository.findById(1L)).thenReturn(Optional.empty());
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        Rol rol = new Rol();
        rol.setId(2L);
        user.setRol(rol);
        assertThrows(IdNotExit.class, ()->userJpaAdapter.createEmployee(user));
    }
    @Test
    void saveEmployeeWrongRol(){
        when(rolRepository.findById(1L)).thenReturn(Optional.of(new RolEntity()));
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        Rol rol = new Rol();
        rol.setId(1L);
        user.setRol(rol);
        assertThrows(InfrasWrongRolOwner.class, ()->userJpaAdapter.createEmployee(user));
    }
    @Test
    void saveEmployeeIdExist(){
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        Rol rol = new Rol();
        rol.setId(4L);
        user.setRol(rol);
        when(rolRepository.findById(4L)).thenReturn(Optional.of(new RolEntity()));
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(new UserEntity()));
        assertThrows(InfrasEmaiExist.class, ()->userJpaAdapter.createEmployee(user));
    }
    @Test
    void saveCustomer(){
        String email = "exmaple@email.com";
        when(rolRepository.findById(5L)).thenReturn(Optional.of(new RolEntity()));
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        Rol rol = new Rol();
        rol.setId(5L);
        user.setRol(rol);
        userJpaAdapter.createCustomer(user);
        verify(userRepository, times(1)).save(userEntityMapper.toUserEntity(user));
    }
    @Test
    void saveCustomerIdNotExist(){
        when(rolRepository.findById(1L)).thenReturn(Optional.empty());
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        Rol rol = new Rol();
        rol.setId(2L);
        user.setRol(rol);
        assertThrows(IdNotExit.class, ()->userJpaAdapter.createCustomer(user));
    }
    @Test
    void saveCustomerWrongRol(){
        when(rolRepository.findById(1L)).thenReturn(Optional.of(new RolEntity()));
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        Rol rol = new Rol();
        rol.setId(1L);
        user.setRol(rol);
        assertThrows(InfrasWrongRolOwner.class,()->userJpaAdapter.createCustomer(user));
    }
    @Test
    void saveCustomerIdExist(){
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        Rol rol = new Rol();
        rol.setId(5L);
        user.setRol(rol);
        when(rolRepository.findById(5L)).thenReturn(Optional.of(new RolEntity()));
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(new UserEntity()));
        assertThrows(InfrasEmaiExist.class, ()->userJpaAdapter.createCustomer(user));
    }
    @Test
    void saveAdmin(){
        String email = "exmaple@email.com";
        when(rolRepository.findById(1L)).thenReturn(Optional.of(new RolEntity()));
        when(userRepository.findByEmail(email)).thenReturn(Optional.empty());
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        Rol rol = new Rol();
        rol.setId(1L);
        user.setRol(rol);
        userJpaAdapter.createAdmin(user);
        verify(userRepository, times(1)).save(userEntityMapper.toUserEntity(user));
    }
    @Test
    void saveAdminIdNotExist(){
        when(rolRepository.findById(1L)).thenReturn(Optional.empty());
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        Rol rol = new Rol();
        rol.setId(1L);
        user.setRol(rol);
        assertThrows(IdNotExit.class, ()->userJpaAdapter.createAdmin(user));
    }
    @Test
    void saveAdminWrongRol(){
        when(rolRepository.findById(3L)).thenReturn(Optional.of(new RolEntity()));
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        Rol rol = new Rol();
        rol.setId(3L);
        user.setRol(rol);
        assertThrows(InfrasWrongRolOwner.class,()->userJpaAdapter.createAdmin(user));
    }
    @Test
    void saveAdminEmailExist(){
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        Rol rol = new Rol();
        rol.setId(1L);
        user.setRol(rol);
        when(rolRepository.findById(1L)).thenReturn(Optional.of(new RolEntity()));
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(new UserEntity()));
        assertThrows(InfrasEmaiExist.class, ()->userJpaAdapter.createAdmin(user));
    }
    @Test
    void getAllUser() {
        List<UserEntity> userEntityList = new ArrayList<>();
        userEntityList.add(userEntity);

        when(userRepository.findAll()).thenReturn(userEntityList);
        List<User> users = userJpaAdapter.getAllUser();
        assertEquals(users, userEntityMapper.toUserList(userEntityList));
    }

    @Test
    void getUser() {
        User user = new User();
        user.setId(1L);
        user.setEmail("test@example.com");
        user.setPassword("password");
        Rol rol = new Rol();
        rol.setId(2L);
        user.setRol(rol);
        UserEntity userEntity1 = new UserEntity();
        when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity1));
        when(userEntityMapper.toUser(userEntity1)).thenReturn(user);
        User result = userJpaAdapter.getUser(user.getId());
        assertEquals(result, user);
    }
    @Test
    void getUserIdNotExist(){
        User user = new User();
        user.setId(1L);
        user.setEmail("test@example.com");
        user.setPassword("password");
        Rol rol = new Rol();
        rol.setId(2L);
        user.setRol(rol);
        when(userRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(IdNotExit.class, ()->userJpaAdapter.getUser(user.getId()));
    }
    @Test
    void getUserByEmail(){
        User user = new User();
        user.setId(1L);
        user.setEmail("test@example.com");
        user.setPassword("password");
        Rol rol = new Rol();
        rol.setId(2L);
        user.setRol(rol);
        UserEntity userEntity1 = new UserEntity();
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(userEntity1));
        when(userEntityMapper.toUser(userEntity1)).thenReturn(user);
        User result = userJpaAdapter.getUserByEmail(user.getEmail());
        assertEquals(result, user);
    }
}