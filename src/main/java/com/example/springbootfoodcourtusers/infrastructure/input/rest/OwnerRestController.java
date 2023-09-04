package com.example.springbootfoodcourtusers.infrastructure.input.rest;

import com.example.springbootfoodcourtusers.application.dto.UserRequest;
import com.example.springbootfoodcourtusers.application.handler.UserHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
@RequiredArgsConstructor
public class OwnerRestController {
    private final UserHandler userHandler;

    @Operation(summary = "Create a Employee")
    @ApiResponse(responseCode = "201", description = "Employee created successfully")
    @ApiResponse(responseCode = "403", description = "Unauthorized / Invalid Token")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @PostMapping("/createEmployee")
    public ResponseEntity<Void> saveEmployee(@RequestBody UserRequest userRequest){
        userHandler.createEmployee(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
