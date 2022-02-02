package com.portfolio.market.springmarket.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{ //* Essa classe que estou estendendo pega exeptions de algum response entity.
    
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleAnyException(Exception e, WebRequest request ){ //* Eu vou receber no método uma exception(stack tracej) e o tipo da requisição, seja ela GET, POST, etc.
       
        String errorDescription = e.getLocalizedMessage(); //* isso vai pegar apenas a descrição la da stack trace
        
        if(errorDescription == null){ //* Aqui eu verifico se está nullo, se sim pego o toString da Stack trace
            errorDescription = e.toString();
        }

        ErrorMessage errorMessage = new ErrorMessage(new Date(), errorDescription);

        return new ResponseEntity<>(errorMessage, 
        new HttpHeaders(), 
        HttpStatus.INTERNAL_SERVER_ERROR); //* Aqui eu passo a exception, crio um novo cabeçalho e coloco esse erro da familia 500 pra retornar

        /**
         * Escrever so esse response_entity simples retornando apenas o "e"(que seria toda a StackTrace da exception) não é bom, 
         * é ate considerado uma falha na segurança, pois eu estou mostrando pro meu cliente tudo que está acontecendo no meu back-end
         * então eu vou usar uma classe customizada para mensagens de erro
         */

    }
    
}
