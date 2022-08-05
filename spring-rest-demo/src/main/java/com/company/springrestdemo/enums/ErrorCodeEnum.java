package com.company.springrestdemo.enums;

public enum ErrorCodeEnum {
    CAN_NOT_FIND_EMPLOYEE("Can not find employee with given  id ");

    private final String message;

    ErrorCodeEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
