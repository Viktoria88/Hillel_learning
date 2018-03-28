package com.company.operations;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Minus extends Mapping {

    private static Operations minuss = null;

    protected Minus() {
        super(ConstOperation.MINUS);
    }

    @Override
    public <T extends Number> T execute(Class type, T... args) {
        if (type.equals(BigInteger.class)) {
            BigInteger total;
            total = BigInteger.valueOf(args[0].longValue()).subtract(BigInteger.valueOf(args[1].longValue()));
            return (T) total;
        } else if (type.equals(BigDecimal.class)) {
            BigDecimal total;
            total = BigDecimal.valueOf(args[0].doubleValue()).subtract(BigDecimal.valueOf(args[1].doubleValue()));
            return (T) total;
        }
        return null;
    }

    public static Operations createInstance() throws CloneNotSupportedException {
        Operations result = null;
        if (minuss == null) {
            result = new Minus();
        } else {
            result = ((Mapping) minuss).clone();
        }
        return result;
    }
}
