package com.company.operations;


public interface Operations extends Cloneable {

    <T extends Number> T execute(Class type, T... args);

    boolean isMySymbol(String symb);

    String getSymbol();
}
