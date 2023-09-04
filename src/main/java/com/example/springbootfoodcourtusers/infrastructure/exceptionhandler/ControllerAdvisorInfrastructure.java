package com.example.springbootfoodcourtusers.infrastructure.exceptionhandler;

import com.example.springbootfoodcourtusers.infrastructure.exception.IdNotExit;
import com.example.springbootfoodcourtusers.infrastructure.exception.InfrasEmaiExist;
import com.example.springbootfoodcourtusers.infrastructure.exception.InfrasUserNotFound;
import com.example.springbootfoodcourtusers.infrastructure.exception.InfrasWrongRolOwner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisorInfrastructure{
    public static final String MESSAGE = "Message";

    @ExceptionHandler(IdNotExit.class)
    public ResponseEntity<Map<String, String>> idNotExist(IdNotExit idNotExit){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap(MESSAGE, ExceptionResponse.ID_NOT_EXIST.getMessage()));
    }
    @ExceptionHandler(InfrasWrongRolOwner.class)
    public ResponseEntity<Map<String, String>> wrongRolOwner(InfrasWrongRolOwner wrongRolOwner){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap(MESSAGE, ExceptionResponse.WRONG_ROL_OWNER.getMessage()));
    }
    @ExceptionHandler(InfrasEmaiExist.class)
    public ResponseEntity<Map<String,String>> emailExist(InfrasEmaiExist emaiExist){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap(MESSAGE, ExceptionResponse.EMAIL_EXIST.getMessage()));
    }
    @ExceptionHandler(InfrasUserNotFound.class)
    public ResponseEntity<Map<String, String>> userNotFound(InfrasUserNotFound userNotFound){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap(MESSAGE, ExceptionResponse.USER_NOT_FOUND.getMessage()));
    }
}
