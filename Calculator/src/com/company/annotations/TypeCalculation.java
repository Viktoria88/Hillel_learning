package com.company.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TypeCalculation {

    Type type();

    enum Type {SIMPLE_CALCULATION, RUTISHAUSER_CALCULATION, JS_CALCULATION}
}
