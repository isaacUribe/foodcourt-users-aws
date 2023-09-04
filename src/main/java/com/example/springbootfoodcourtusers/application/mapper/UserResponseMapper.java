package com.example.springbootfoodcourtusers.application.mapper;

import com.example.springbootfoodcourtusers.application.dto.UserResponse;
import com.example.springbootfoodcourtusers.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserResponseMapper {
    UserResponse toUserResponse(User user);
    List<UserResponse> toUserResponseList(List<User> userList);
}
