package com.example.springbootfoodcourtusers.infrastructure.out.jpa.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    ADMIN_READ_ALL("admin:readall"),
    ADMIN_CREATE_OWNER("admin:createowner"),
    ADMIN_CREATE_RESTAURANT("admin:createrestaurant"),
    OWNER_READ_ONE("owner:readone"),
    OWNER_CREATE_DISH("owner:createdish"),
    OWNER_UPDATE_DISH("owner:updatedish"),
    EMPLOYEE_READ_ORDER_PENDING("employee:readorderpending"),
    CUSTOMER_READ_ALL_RESTAURANT("customer:readallrestaurant");
    @Getter
    private final String authorization;
}
