package com.example.springbootfoodcourtusers.domain.validation;

import com.example.springbootfoodcourtusers.domain.exception.*;
import com.example.springbootfoodcourtusers.domain.model.Rol;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class UserValidation {
    public void validateEmptyField(String data){
        if (data == null || data.isEmpty()){
            throw new EmptyField();
        }

    }
    public void validateDocument(String data){
        if (data == null || !StringUtils.isNumeric(data)){
            throw new DocumentWrong();
        }
    }
    public void validateCellPhone(String data){
        if (data == null || data.length()>13){
            throw new CellPhoneWrong();
        }
        char[] chars = data.toCharArray();
        for (int i = 1; i < data.length(); i++) {
            char c = chars[i];
            if (!Character.isDigit(c)){
                throw new CellPhoneWrong();
            }
        }
    }

    public void validateAge(LocalDate date){
        if (date == null){
            throw new NotIsAdult();
        }
        LocalDate dateNow = LocalDate.now();
        Period period = Period.between(date, dateNow);
        int difference = period.getYears();
        if (difference<18){
            throw new NotIsAdult();
        }
    }
    public void validateBirthdate(LocalDate date){
        if (date == null){
            throw new EmptyField();
        }
    }
    public void validateEmail(String data){

        String emailValidator = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (data == null || !data.matches(emailValidator)){
            throw new EmailWrong();
        }
    }
    public void validateRol(Rol rol){
        if (rol == null){
            throw new EmptyField();
        }
    }
    public void validateIfIdIsNull(Long id){
        if (id == null){
            throw new EmptyField();
        }
    }
}
