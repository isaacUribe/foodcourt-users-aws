package com.example.springbootfoodcourtusers.infrastructure.input.rest;

import com.example.springbootfoodcourtusers.application.dto.UserRequest;
import com.example.springbootfoodcourtusers.application.dto.UserResponse;
import com.example.springbootfoodcourtusers.application.handler.UserHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminRestController {
    private final UserHandler userHandler;
    @Operation(summary = "Create a Owner")
    @ApiResponse(responseCode = "201", description = "Owner created successfully")
    @ApiResponse(responseCode = "403", description = "Unauthorized / Invalid Token")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @PostMapping("/createOwner")
    public ResponseEntity<Void> saveOwner(@RequestBody UserRequest userRequest){
        userHandler.createOwner(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @Operation(summary = "Get all users from the database")
    @ApiResponse(responseCode = "200", description = "All users found")
    @ApiResponse(responseCode = "403", description = "Unauthorized / Invalid Token")
    @GetMapping("/getAll")
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.ok(userHandler.gellAllUsers());
    }
}
