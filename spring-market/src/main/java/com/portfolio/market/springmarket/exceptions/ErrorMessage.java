package com.portfolio.market.springmarket.exceptions;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorMessage {

    private Date currentDate;
    private String message;
    
     public ErrorMessage(Date currentDate, String message) {
        this.currentDate = currentDate;
        this.message = message;
    }
    
}
