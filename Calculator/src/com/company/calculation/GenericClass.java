package com.company.calculation;


abstract class GenericClass<T> {

    private Class<T> genericType;

    protected GenericClass(Class<T> type) {
        this.genericType = type;
    }

    public Class<T> getGenericType() {
        return genericType;
    }
}
