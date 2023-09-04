package com.example.springbootfoodcourtusers.infrastructure.exceptionhandler;

public enum ExceptionResponse {
    ID_NOT_EXIST("El id no existe"),
    WRONG_ROL_OWNER("El rol que se esta asignado al usuario esta incorrecto"),
    EMAIL_EXIST("El correo electronico que estas intentado crear ya existe"),
    USER_NOT_FOUND("El usuario no existe");

    private String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
