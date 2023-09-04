package com.example.springbootfoodcourtusers.infrastructure.auth;

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

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationRestController {

    private final AuthenticationService authenticationService;
    private final UserHandler userHandler;

    @Operation(summary = "Authenticate")
    @ApiResponse(responseCode = "200", description = "OK / Authenticated")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
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
