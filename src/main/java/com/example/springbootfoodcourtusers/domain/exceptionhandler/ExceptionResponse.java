package com.example.springbootfoodcourtusers.domain.exceptionhandler;

public enum ExceptionResponse {
    EMPTY_FIELD("Un campo esta vacio"),
    DOCUMENT_WRONG("El campo documento esta vacio o tiene letras"),

    CELL_PHONE_WRONG("El telefono es null o pasa del limite de caracteres"),
    NOT_ID_ADULT("El usuario que esta intentando crear no es mayor de edad o el campo fecha de nacimiento es null"),
    EMAIL_WRONG("El email ingresado es incorrecto o el campo es nulo");

    private String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
