package com.company.springrestdemo.exception;

import com.company.springrestdemo.enums.ErrorCodeEnum;

public class CustomRestException extends RuntimeException{
    public CustomRestException(String message) {
        super(message);
    }

    public CustomRestException(ErrorCodeEnum errorCodeEnum  ) {
        super(errorCodeEnum.getMessage());
    }
}
