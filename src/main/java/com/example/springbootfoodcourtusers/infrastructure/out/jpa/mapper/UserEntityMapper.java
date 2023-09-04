package com.example.springbootfoodcourtusers.infrastructure.out.jpa.mapper;

import com.example.springbootfoodcourtusers.domain.model.User;
import com.example.springbootfoodcourtusers.infrastructure.out.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {

    UserEntity toUserEntity(User user);
    User toUser(UserEntity userEntity);
    List<User> toUserList(List<UserEntity> userEntityList);
}
