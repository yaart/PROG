package org.example.exceptions;

public class InvalidArgumentException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid value, Please enter a value from the range";
    }
}