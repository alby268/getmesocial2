package com.example.getmesocial2.exception;

public class RestrictedNameException extends Exception{
    @Override
    public String getMessage(){

        return "Cannot create name root";
    }
}
