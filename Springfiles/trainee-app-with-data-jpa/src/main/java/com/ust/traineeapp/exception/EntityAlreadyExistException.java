package com.ust.traineeapp.exception;

public class EntityAlreadyExistException extends RuntimeException{
    public EntityAlreadyExistException(String msg){
        super(msg);
    }
}
