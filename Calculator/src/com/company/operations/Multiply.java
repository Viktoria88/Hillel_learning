package com.company.operations;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Multiply extends Mapping {

    private static Operations multy = null;

    protected Multiply() {
        super(ConstOperation.MULTIPLY);
    }

    @Override
    public <T extends Number> T execute(Class type, T... args) {
        if (type.equals(BigInteger.class)) {
            BigInteger total;
            total = BigInteger.valueOf(args[0].longValue()).multiply(BigInteger.valueOf(args[1].longValue()));
            return (T) total;
        } else if (type.equals(BigDecimal.class)) {
            BigDecimal total;
            total = BigDecimal.valueOf(args[0].doubleValue()).multiply(BigDecimal.valueOf(args[1].doubleValue()));
            return (T) total;
        }
        return null;
    }

    public static Operations createInstance() throws CloneNotSupportedException {
        Operations result = null;
        if (multy == null) {
            result = new Multiply();
        } else {
            result = ((Mapping) multy).clone();
        }
        return result;
    }
}
