package com.example.springbootfoodcourtusers.infrastructure.out.jpa.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.springbootfoodcourtusers.infrastructure.out.jpa.entity.Permission.*;

@RequiredArgsConstructor
public enum Role {
    USER(Collections.emptySet()),
    ADMIN(
            Set.of(
                    ADMIN_CREATE_OWNER,
                    ADMIN_CREATE_RESTAURANT,
                    ADMIN_READ_ALL
            )
    ),
    OWNER(
            Set.of(
                    OWNER_CREATE_DISH,
                    OWNER_UPDATE_DISH,
                    OWNER_READ_ONE
            )
    ),
    EMPLOYEE(
            Set.of(
                    EMPLOYEE_READ_ORDER_PENDING
            )
    ),
    CUSTOMER(
            Set.of(
                    CUSTOMER_READ_ALL_RESTAURANT
            )
    );

    @Getter
    private final Set<Permission> permissions;



}
