package com.example.springbootfoodcourtusers.infrastructure.input.rest;

import com.example.springbootfoodcourtusers.application.dto.UserRequest;
import com.example.springbootfoodcourtusers.application.dto.UserResponse;
import com.example.springbootfoodcourtusers.application.dto.UserResponseByAuth;
import com.example.springbootfoodcourtusers.application.handler.UserHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestController {
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
    @Operation(summary = "Create a Employee")
    @ApiResponse(responseCode = "201", description = "Employee created successfully")
    @ApiResponse(responseCode = "403", description = "Unauthorized / Invalid Token")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @PostMapping("/createEmployee")
    public ResponseEntity<Void> saveEmployee(@RequestBody UserRequest userRequest){
        userHandler.createEmployee(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Find user in the database by email")
    @ApiResponse(responseCode = "200", description = "OK / User found")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<UserResponseByAuth> getUserByEmail(@PathVariable String email){
        return ResponseEntity.ok(userHandler.getUserByEmail(email));
    }
    @Operation(summary = "Find user in the database by id")
    @ApiResponse(responseCode = "200", description = "OK / User found")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @GetMapping("/getOne/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userHandler.getUser(id));
    }
    @Operation(summary = "Create a Customer")
    @ApiResponse(responseCode = "201", description = "Customer created succesfully")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @PostMapping("/createCustomer")
    public ResponseEntity<Void> saveCustomer(@RequestBody UserRequest userRequest){
        userHandler.createCustomer(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @Operation(summary = "Create a Admin")
    @ApiResponse(responseCode = "201", description = "Admin created succesfully")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @PostMapping("/createAdmin")
    public ResponseEntity<Void> saveAdmin(@RequestBody UserRequest userRequest){
        userHandler.createAdmin(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
