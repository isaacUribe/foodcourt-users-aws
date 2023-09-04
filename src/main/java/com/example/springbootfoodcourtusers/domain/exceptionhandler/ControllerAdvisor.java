package com.example.springbootfoodcourtusers.domain.exceptionhandler;

import com.example.springbootfoodcourtusers.domain.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {
    private static final String MESSAGE = "Message";
    @ExceptionHandler(EmptyField.class)
    public ResponseEntity<Map<String, String>> emptyField(EmptyField emptyField){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap(MESSAGE, ExceptionResponse.EMPTY_FIELD.getMessage()));
    }
    @ExceptionHandler(DocumentWrong.class)
    public ResponseEntity<Map<String, String>> documentoWrong(DocumentWrong documentWrong){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap(MESSAGE, ExceptionResponse.DOCUMENT_WRONG.getMessage()));
    }
    @ExceptionHandler(CellPhoneWrong.class)
    public ResponseEntity<Map<String, String>> cellPhoneWrong(CellPhoneWrong cellPhoneWrong){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap(MESSAGE, ExceptionResponse.CELL_PHONE_WRONG.getMessage()));
    }
    @ExceptionHandler(NotIsAdult.class)
    public ResponseEntity<Map<String, String>> notIdAdult(NotIsAdult notIsAdult){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap(MESSAGE, ExceptionResponse.NOT_ID_ADULT.getMessage()));
    }
    @ExceptionHandler(EmailWrong.class)
    public ResponseEntity<Map<String, String>> emailWrong(EmailWrong emailWrong){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap(MESSAGE,ExceptionResponse.EMAIL_WRONG.getMessage()));
    }
}
