package org.example.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Resource does not exist");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
