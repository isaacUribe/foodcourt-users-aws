package com.example.springbootfoodcourtusers.application.mapper;

import com.example.springbootfoodcourtusers.application.dto.UserRequest;
import com.example.springbootfoodcourtusers.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserRequestMapper {
    User toUser(UserRequest userRequest);

}
