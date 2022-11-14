package com.techeer3rd.freelogbackend.domain.test.exception;

import com.techeer3rd.freelogbackend.global.exception.BaseException;

public class NotFoundTestDataEntityException extends BaseException {

    public NotFoundTestDataEntityException(){
        super("Not Found TestData Entity");
    }
}
