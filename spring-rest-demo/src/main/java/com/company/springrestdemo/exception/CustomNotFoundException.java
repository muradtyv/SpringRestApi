package com.company.springrestdemo.exception;

import com.company.springrestdemo.enums.ErrorCodeEnum;

public class CustomNotFoundException extends RuntimeException{

    private final int code;
    private final String message;

//    public CustomRestException(String message) {
//        super(message);
//    }

    public CustomNotFoundException(ErrorCodeEnum errorCodeEnum  ) {

        super(errorCodeEnum.getMessage());
        this.code = errorCodeEnum.getCode();
        this.message = errorCodeEnum.getMessage();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
