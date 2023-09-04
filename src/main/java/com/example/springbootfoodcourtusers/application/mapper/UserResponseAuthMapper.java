package com.example.springbootfoodcourtusers.application.mapper;

import com.example.springbootfoodcourtusers.application.dto.UserResponseByAuth;
import com.example.springbootfoodcourtusers.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserResponseAuthMapper {
    UserResponseByAuth toUserResponseAuth(User user);
}
