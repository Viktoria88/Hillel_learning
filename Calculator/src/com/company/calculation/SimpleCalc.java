package com.company.calculation;


import com.company.annotations.DescriptionCalculation;
import com.company.annotations.TypeCalculation;
import com.company.exception.IncorrectValueException;

import java.math.BigDecimal;
import java.math.BigInteger;

@TypeCalculation(type = TypeCalculation.Type.SIMPLE_CALCULATION)
@DescriptionCalculation(description = "Can count simple operation, does not follow the calculation priority.\nDon't use brackets",
                countWithBrackets = false)
public class SimpleCalc<T extends Number> extends Calculation<T> {

    private int element = args.length;
    T[] pars = (T[]) new Number[element];
    private final MyGeneric<T> type = new MyGeneric<T>(getClass());
    private final Class<T> getGeneric = type.getGenericType();
    private Class typeNumber = null;


    protected SimpleCalc(String[] args, Class<T> genericType) {
        super(args);
        try {
            typeNumber = genericType;
            adds(args, genericType);
        } catch (IncorrectValueException e) {
            System.out.println(e);
        }
    }

    @Override
    public BigDecimal getResult() {

        T res = null;

        for (int i = 0; i < pars.length; i++) {
            try {
                if (i == 0) {
                    res = count(args[i + 1], typeNumber, pars[i], pars[i + 2]);
                } else {
                    res = count(args[i + 1], typeNumber, res, pars[i + 2]);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                continue;
            }
        }
        BigDecimal g;
        if (res instanceof BigInteger) {
            g = new BigDecimal(res.doubleValue());
        } else {
            g = (BigDecimal) res;
        }
        return g;
    }

    protected void adds(String[] s, Class<T> getGenericType) throws IncorrectValueException {
        for (int i = 0; i < element; i++) {

            try {
                T d = null;
                if (getGenericType.equals(BigInteger.class)) {
                    d = (T) parseBigInt(s[i]);
                } else if (getGenericType.equals(BigDecimal.class)) {
                    d = (T) parseBigDecimal(s[i]);
                }
                pars[i] = d;
            } catch (NumberFormatException e) {
                if (!isSymb(s[i])) {
                    throw new IncorrectValueException(s[i]);
                }
            }
        }
    }
}
