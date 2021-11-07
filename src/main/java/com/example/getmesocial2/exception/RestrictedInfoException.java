package com.example.getmesocial2.exception;

public class RestrictedInfoException extends Exception{

    @Override
    public String getMessage(){

        return "No user found";
    }
}
