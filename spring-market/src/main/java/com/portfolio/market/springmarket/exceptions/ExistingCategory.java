package com.portfolio.market.springmarket.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExistingCategory extends RuntimeException{

    public ExistingCategory(String message){
        super(message);
    }
}
