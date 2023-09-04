package com.example.springbootfoodcourtusers.domain.exceptionhandler;

import com.example.springbootfoodcourtusers.domain.exception.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ControllerAdvisorTest {

    @Test
    void emptyField() {
        EmptyField emptyField = mock(EmptyField.class);
        when(emptyField.getMessage()).thenReturn("Empty field");

        ControllerAdvisor controllerAdvisor = new ControllerAdvisor();
        ResponseEntity<Map<String, String>> responseEntity = controllerAdvisor.emptyField(emptyField);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    void documentoWrong() {
        DocumentWrong documentWrong = mock(DocumentWrong.class);
        when(documentWrong.getMessage()).thenReturn("Document Wrong");
        ControllerAdvisor controllerAdvisor = new ControllerAdvisor();
        ResponseEntity<Map<String, String>> responseEntity = controllerAdvisor.documentoWrong(documentWrong);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    void cellPhoneWrong() {
        CellPhoneWrong cellPhoneWrong = mock(CellPhoneWrong.class);
        when(cellPhoneWrong.getMessage()).thenReturn("Cellphone wrong");
        ControllerAdvisor controllerAdvisor = new ControllerAdvisor();
        ResponseEntity<Map<String, String>> responseEntity = controllerAdvisor.cellPhoneWrong(cellPhoneWrong);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    void notIdAdult() {
        NotIsAdult notIsAdult = mock(NotIsAdult.class);
        when(notIsAdult.getMessage()).thenReturn("Not is adult");
        ControllerAdvisor controllerAdvisor = new ControllerAdvisor();
        ResponseEntity<Map<String, String>> responseEntity = controllerAdvisor.notIdAdult(notIsAdult);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    void emailWrong() {
        EmailWrong emailWrong = mock(EmailWrong.class);
        when(emailWrong.getMessage()).thenReturn("Email wrong");
        ControllerAdvisor controllerAdvisor = new ControllerAdvisor();
        ResponseEntity<Map<String, String>> responseEntity = controllerAdvisor.emailWrong(emailWrong);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }
}