package com.example.springbootfoodcourtusers.infrastructure.out.jpa.adapter;

import com.example.springbootfoodcourtusers.domain.model.User;
import com.example.springbootfoodcourtusers.domain.spi.UserPersistancePort;
import com.example.springbootfoodcourtusers.infrastructure.exception.IdNotExit;
import com.example.springbootfoodcourtusers.infrastructure.exception.InfrasEmaiExist;
import com.example.springbootfoodcourtusers.infrastructure.exception.InfrasWrongRolOwner;
import com.example.springbootfoodcourtusers.infrastructure.out.jpa.entity.RolEntity;
import com.example.springbootfoodcourtusers.infrastructure.out.jpa.entity.UserEntity;
import com.example.springbootfoodcourtusers.infrastructure.out.jpa.mapper.UserEntityMapper;
import com.example.springbootfoodcourtusers.infrastructure.out.jpa.repository.RolRepository;
import com.example.springbootfoodcourtusers.infrastructure.out.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;


import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class UserJpaAdapter implements UserPersistancePort {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final RolRepository rolRepository;



    @Override
    public void createOwner(User user) {
        Optional<RolEntity> optionalRol = rolRepository.findById(user.getRol().getId());
        if (!optionalRol.isPresent()){
            throw new IdNotExit();
        }
        if (!user.getRol().getId().equals(2L)){
            throw new InfrasWrongRolOwner();
        }
        Optional<UserEntity> userEntity = userRepository.findByEmail(user.getEmail());
        if (userEntity.isPresent()){
            throw new InfrasEmaiExist();
        }
        userRepository.save(userEntityMapper.toUserEntity(user));
    }

    @Override
    public void createEmployee(User user) {
        Optional<RolEntity> optionalRol = rolRepository.findById(user.getRol().getId());
        if (!optionalRol.isPresent()){
            throw new IdNotExit();
        }
        if (!user.getRol().getId().equals(4L)){
            throw new InfrasWrongRolOwner();
        }
        Optional<UserEntity> userEntity = userRepository.findByEmail(user.getEmail());
        if (userEntity.isPresent()){
            throw new InfrasEmaiExist();
        }
        userRepository.save(userEntityMapper.toUserEntity(user));
    }

    @Override
    public void createCustomer(User user) {
        Optional<RolEntity> optionalRol = rolRepository.findById(user.getRol().getId());
        if (!optionalRol.isPresent()){
            throw new IdNotExit();
        }

        if (!user.getRol().getId().equals(5L)){
            throw new InfrasWrongRolOwner();
        }
        Optional<UserEntity> userEntity = userRepository.findByEmail(user.getEmail());
        if (userEntity.isPresent()){
            throw new InfrasEmaiExist();
        }
        userRepository.save(userEntityMapper.toUserEntity(user));
    }

    @Override
    public void createAdmin(User user) {
        Optional<RolEntity> optionalRol = rolRepository.findById(user.getRol().getId());
        if (!optionalRol.isPresent()){
            throw new IdNotExit();
        }

        if (!user.getRol().getId().equals(1L)){
            throw new InfrasWrongRolOwner();
        }
        Optional<UserEntity> userEntity = userRepository.findByEmail(user.getEmail());
        if (userEntity.isPresent()){
            throw new InfrasEmaiExist();
        }
        userRepository.save(userEntityMapper.toUserEntity(user));
    }

    @Override
    public List<User> getAllUser() {
        List<UserEntity> userEntityList = userRepository.findAll();
        return userEntityMapper.toUserList(userEntityList);
    }

    @Override
    public User getUser(Long idUser){
        Optional<UserEntity> userEntityOptional = userRepository.findById(idUser);
        if (!userEntityOptional.isPresent()){
            throw new IdNotExit();
        }
        UserEntity userEntity = userEntityOptional.get();
        return userEntityMapper.toUser(userEntity);
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<UserEntity> userOptional = userRepository.findByEmail(email);
        UserEntity user = userOptional.get();
        return userEntityMapper.toUser(user);
    }
}
