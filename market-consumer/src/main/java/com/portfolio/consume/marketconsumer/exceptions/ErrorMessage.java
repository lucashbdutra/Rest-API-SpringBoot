package com.portfolio.consume.marketconsumer.exceptions;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorMessage { //Apenas a classe que eu usei pra settar a mensagem de erro, na medida que eu tiver diferentes mensagens pra diferentes problemas elas vao todas aqui

    private Date currentDate;
    private String message;
    
     public ErrorMessage(Date currentDate, String message) {
        this.currentDate = currentDate;
        this.message = message;
    }
    
}
