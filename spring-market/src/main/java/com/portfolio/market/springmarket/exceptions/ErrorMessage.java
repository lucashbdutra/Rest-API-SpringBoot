package com.portfolio.market.springmarket.exceptions;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorMessage { //Apenas a classe que eu usei pra settar a mensagem de erro, na medida que eu tiver diferentes mensagens pra diferentes problemas elas vao todas aqui

    private Date currentDate;
    private String message;
    private String details;
    
     public ErrorMessage(Date currentDate, String message, String details) {
        this.currentDate = currentDate;
        this.message = message;
        this.details = details;
    }
    
}
