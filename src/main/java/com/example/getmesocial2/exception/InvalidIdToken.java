package com.example.getmesocial2.exception;

public class InvalidIdToken extends Exception{

    @Override
    public String getMessage(){

        return "Invalid token";
    }
}
