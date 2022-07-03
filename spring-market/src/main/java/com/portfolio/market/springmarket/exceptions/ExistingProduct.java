package com.portfolio.market.springmarket.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExistingProduct extends RuntimeException{

    public ExistingProduct(String message){
        super(message);
    }
}
