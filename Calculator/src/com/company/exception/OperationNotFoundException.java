package com.company.exception;


public class OperationNotFoundException extends Exception {

    public OperationNotFoundException() {
    }

    public String toString() {
        return "OperationNotFoundException [" + "Operations not found" + "]";
    }

}
