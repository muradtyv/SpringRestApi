package com.company.springrestdemo.enums;

public enum ErrorCodeEnum {
    CAN_NOT_FIND_EMPLOYEE(1001,"Can not find employee with given  id "),
    VALIDATION_ERROR(1002," is not valid "),
    UNKNOWN_ERROR(500,"Unknown error");

    private final int code;
    private final String message;

    ErrorCodeEnum(int code ,String message) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }
    public int getCode(){
        return code;
    }

}
