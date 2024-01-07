package com.mruruc.exceptions;

public class ClientAuthException extends RuntimeException{
    public ClientAuthException(String message){
        super(message);
    }
}
