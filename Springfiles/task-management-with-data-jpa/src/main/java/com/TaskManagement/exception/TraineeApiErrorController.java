package com.TaskManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TraineeApiErrorController {


    @ExceptionHandler(TaskNotFoundException.class)
    public ProblemDetail handlerRecordNotFoundError(TaskNotFoundException ex){
        ProblemDetail response= ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        response.setDetail(ex.getMessage());
        return response;
    }

    @ExceptionHandler(InvalidInputDataException.class)
    public ProblemDetail handlerEntityAlreadyExistError(InvalidInputDataException ex){
        ProblemDetail response= ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        response.setDetail(ex.getMessage());
        return response;
    }

}
