package com.example.springbootfoodcourtusers.infrastructure.configuration;

import com.example.springbootfoodcourtusers.domain.api.UserServicePort;
import com.example.springbootfoodcourtusers.domain.spi.UserPersistancePort;
import com.example.springbootfoodcourtusers.domain.usecase.UserUseCase;
import com.example.springbootfoodcourtusers.infrastructure.out.jpa.adapter.UserJpaAdapter;
import com.example.springbootfoodcourtusers.infrastructure.out.jpa.mapper.UserEntityMapper;
import com.example.springbootfoodcourtusers.infrastructure.out.jpa.repository.RolRepository;
import com.example.springbootfoodcourtusers.infrastructure.out.jpa.repository.UserRepository;
import com.example.springbootfoodcourtusers.domain.validation.UserValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final UserValidation userValidation;
    private final RolRepository rolRepository;




    @Bean
    public UserPersistancePort userPersistancePort(){
        return new UserJpaAdapter(userRepository,userEntityMapper,rolRepository);
    }

    @Bean
    public UserServicePort userServicePort(){
        return new UserUseCase(userPersistancePort(), userValidation);
    }
}
