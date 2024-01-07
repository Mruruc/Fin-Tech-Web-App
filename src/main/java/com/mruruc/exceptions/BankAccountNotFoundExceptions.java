package com.mruruc.exceptions;

public class BankAccountNotFoundExceptions extends RuntimeException{
    public BankAccountNotFoundExceptions(String message){
        super(message);
    }
}
