package com.example.springbootfoodcourtusers.infrastructure.exceptionhandler;

import com.example.springbootfoodcourtusers.domain.exceptionhandler.ControllerAdvisor;
import com.example.springbootfoodcourtusers.infrastructure.exception.IdNotExit;
import com.example.springbootfoodcourtusers.infrastructure.exception.InfrasEmaiExist;
import com.example.springbootfoodcourtusers.infrastructure.exception.InfrasUserNotFound;
import com.example.springbootfoodcourtusers.infrastructure.exception.InfrasWrongRolOwner;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ControllerAdvisorInfrastructureTest {

    @Test
    void idNotExist() {
        IdNotExit idNotExit = mock(IdNotExit.class);
        when(idNotExit.getMessage()).thenReturn("Id not exist");
        ControllerAdvisorInfrastructure controllerAdvisorInfrastructure = new ControllerAdvisorInfrastructure();
        ResponseEntity<Map<String, String>> responseEntity = controllerAdvisorInfrastructure.idNotExist(idNotExit);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    void wrongRolOwner() {
        InfrasWrongRolOwner wrongRolOwner = mock(InfrasWrongRolOwner.class);
        when(wrongRolOwner.getMessage()).thenReturn("Wrong rol");
        ControllerAdvisorInfrastructure controllerAdvisorInfrastructure = new ControllerAdvisorInfrastructure();
        ResponseEntity<Map<String, String>> responseEntity = controllerAdvisorInfrastructure.wrongRolOwner(wrongRolOwner);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    void emailExist() {
        InfrasEmaiExist emaiExist = mock(InfrasEmaiExist.class);
        when(emaiExist.getMessage()).thenReturn("Email Exist");
        ControllerAdvisorInfrastructure controllerAdvisorInfrastructure = new ControllerAdvisorInfrastructure();
        ResponseEntity<Map<String, String>> responseEntity = controllerAdvisorInfrastructure.emailExist(emaiExist);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    void userNotFound() {
        InfrasUserNotFound userNotFound = mock(InfrasUserNotFound.class);
        when(userNotFound.getMessage()).thenReturn("User not found");
        ControllerAdvisorInfrastructure controllerAdvisorInfrastructure = new ControllerAdvisorInfrastructure();
        ResponseEntity<Map<String, String>> responseEntity = controllerAdvisorInfrastructure.userNotFound(userNotFound);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }
}