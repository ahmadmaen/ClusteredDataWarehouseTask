package ProgressSoft.example.ClusteredDataWarehouse.exception;

import ProgressSoft.example.ClusteredDataWarehouse.exception.CustomException.DealRequestNotFoundException;
import ProgressSoft.example.ClusteredDataWarehouse.exception.CustomException.DuplicateEntryException;
import ProgressSoft.example.ClusteredDataWarehouse.exception.CustomException.ValidationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    //Add an exception handler using @ExceptionHandler

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleDealRequestNotFoundException(DealRequestNotFoundException exception) {

        //Create a Error Response
        ErrorResponse response = new ErrorResponse();

        response.setMessage(exception.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setTimeStamp(System.currentTimeMillis());

        //return a ResponseEntity
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleValidationException(ValidationException exception) {

        //Create a Error Response
        ErrorResponse response = new ErrorResponse();

        response.setMessage("Validation Exception : "+exception.getMessage());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setTimeStamp(System.currentTimeMillis());

        //return a ResponseEntity
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleDuplicateEntryException(DuplicateEntryException exception) {

        //Create a Error Response
        ErrorResponse response = new ErrorResponse();

        response.setMessage("DuplicateEntryException : "+exception.getMessage());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setTimeStamp(System.currentTimeMillis());

        //return a ResponseEntity
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exception){

        //Create a Error Response

        ErrorResponse response = new ErrorResponse();

        response.setMessage(exception.getMessage());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setTimeStamp(System.currentTimeMillis());

        //return a ResponseEntity
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }






}
