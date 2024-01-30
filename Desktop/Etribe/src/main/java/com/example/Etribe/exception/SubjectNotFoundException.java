package com.example.Etribe.exception;

public class SubjectNotFoundException extends RuntimeException{
    public SubjectNotFoundException()  {
        super("Subject not found");
    }

}
