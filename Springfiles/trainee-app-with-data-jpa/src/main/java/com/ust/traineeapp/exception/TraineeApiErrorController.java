package com.ust.traineeapp.exception;

import com.ust.traineeapp.dto.ErrorResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice  // to deal exceptions in any part of application
public class TraineeApiErrorController {

//    @ExceptionHandler(RecordNotFoundException.class)
//    public ResponseEntity<ErrorResponseDto> handleRecordNotFoundError(RecordNotFoundException ex, HttpServletRequest request){
//       var status=HttpStatus.NOT_FOUND;
//        ErrorResponseDto body= new ErrorResponseDto(
//                LocalDateTime.now(),
//                status.value(),
//                status.getReasonPhrase(),
//                ex.getMessage(),
//                request.getRequestURI()
//
//        );
//        return  ResponseEntity.status(status).body(body);
//    }

    @ExceptionHandler(RecordNotFoundException.class)  // from spring boot 3 new way of handling exception
    public ProblemDetail handlerRecordNotFoundError(RecordNotFoundException ex){
        ProblemDetail response= ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        response.setDetail(ex.getMessage());
        return response;
    }

    @ExceptionHandler(EntityAlreadyExistException.class)  // from spring boot 3 new way of handling exception
    public ProblemDetail handlerEntityAlreadyExistError(EntityAlreadyExistException ex){
        ProblemDetail response= ProblemDetail.forStatus(HttpStatus.CONFLICT);
       // response.setDetail(ex.getMessage());
        response.setProperty("message",ex.getMessage());
        return response;
    }
}
