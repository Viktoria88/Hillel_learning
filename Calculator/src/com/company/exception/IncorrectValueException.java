package com.company.exception;


public class IncorrectValueException extends Exception {

    String c;

    public IncorrectValueException(String c) {
        this.c = c;
    }

    public String toString() {
        return "IncorrectValueException[" + "Value " + c + " is incorrect" + "]";
    }

}
