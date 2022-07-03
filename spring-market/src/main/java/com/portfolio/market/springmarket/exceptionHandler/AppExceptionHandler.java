package com.portfolio.market.springmarket.exceptionHandler;

import com.portfolio.market.springmarket.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.util.Date;

@RestControllerAdvice // É uma especialização do "@Component"
public class AppExceptionHandler extends ResponseEntityExceptionHandler{ //* Essa classe que estou estendendo pega exeptions de algum response entity.
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAnyException(Exception e, WebRequest request ){ //* Eu vou receber no método uma exception(stack tracej) e o tipo da requisição, seja ela GET, POST, etc.

        ErrorMessage error = new ErrorMessage(new Date(), e.getMessage(),request.getDescription(false));

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(CategoryNotFound.class)
    public ResponseEntity<ErrorMessage> handleCategoryException(Exception e, WebRequest request){

        ErrorMessage error = new ErrorMessage(new Date(), e.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<ErrorMessage> handleProductNotFoundException(Exception e, WebRequest request){

        ErrorMessage error = new ErrorMessage(new Date(), e.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExistingProduct.class)
    public ResponseEntity<ErrorMessage> handleExistingProductException(Exception e, WebRequest request){

        ErrorMessage error = new ErrorMessage(new Date(), e.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ExistingCategory.class)
    public ResponseEntity<ErrorMessage> handleExistingCategoryException(Exception e, WebRequest request){

        ErrorMessage error = new ErrorMessage(new Date(), e.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
    
}
