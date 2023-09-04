package com.example.springbootfoodcourtusers.infrastructure.validation;

import com.example.springbootfoodcourtusers.domain.exception.*;
import com.example.springbootfoodcourtusers.domain.model.Rol;
import com.example.springbootfoodcourtusers.domain.validation.UserValidation;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserValidationTest {
    UserValidation userValidation = new UserValidation();

    @Test
    void validateEmptyField() {
        String data = "ejemplo";
        String dataWrong = "";
        assertDoesNotThrow(()->userValidation.validateEmptyField(data));
        assertThrows(EmptyField.class,()-> userValidation.validateEmptyField(dataWrong));
    }

    @Test
    void validateDocument() {
        String document = "12345642";
        String wrongDocument = "123465asdasd";
        assertDoesNotThrow(()->userValidation.validateDocument(document));
        assertThrows(DocumentWrong.class, ()->userValidation.validateDocument(wrongDocument));
    }

    @Test
    void validateCellPhone() {
        String tel = "+1234567";
        String telWrong = "+12312312312321231232";
        String telWithLetter = "+213123aasd";
        assertDoesNotThrow(()->userValidation.validateCellPhone(tel));
        assertThrows(CellPhoneWrong.class, ()->userValidation.validateCellPhone(telWrong));
        assertThrows(CellPhoneWrong.class, ()->userValidation.validateCellPhone(telWithLetter));
    }

    @Test
    void validateAge() {
        LocalDate dateNull = null;
        LocalDate date = LocalDate.of(2000,10,10);
        LocalDate dateWrong = LocalDate.of(2020,10,10);
        assertDoesNotThrow(()->userValidation.validateAge(date));
        assertThrows(NotIsAdult.class, ()->userValidation.validateAge(dateNull));
        assertThrows(NotIsAdult.class, ()->userValidation.validateAge(dateWrong));
    }

    @Test
    void validateEmail() {
        String email = "example@gmail.com";
        String emailWrong = "example@";
        assertDoesNotThrow(()->userValidation.validateEmail(email));
        assertThrows(EmailWrong.class, ()->userValidation.validateEmail(emailWrong));
    }

    @Test
    void validateRol() {
        Rol rol = new Rol();
        Rol rolWrong = null;
        assertDoesNotThrow(()->userValidation.validateRol(rol));
        assertThrows(EmptyField.class, ()->userValidation.validateRol(rolWrong));
    }

    @Test
    void validateIfIdIsNull() {
        Long id = 1L;
        Long idWrong = null;
        assertDoesNotThrow(()->userValidation.validateIfIdIsNull(id));
        assertThrows(EmptyField.class, ()->userValidation.validateIfIdIsNull(idWrong));
    }
    @Test
    void validateBirthday(){
        LocalDate date = LocalDate.of(2000,10,10);
        LocalDate dateNull = null;
        assertDoesNotThrow(()->userValidation.validateBirthdate(date));
        assertThrows(EmptyField.class, ()->userValidation.validateBirthdate(dateNull));
    }

}