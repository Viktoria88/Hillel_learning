package com.company.operations;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Plus extends Mapping {

    private static Operations pluss = null;

    public Plus() {
        super(ConstOperation.PLUS);
    }

    @Override
    public <T extends Number> T execute(Class type, T... args) {
        if (type.equals(BigInteger.class)) {
            BigInteger total;
            total = BigInteger.valueOf(args[0].longValue()).add(BigInteger.valueOf(args[1].longValue()));
            return (T) total;
        } else if (type.equals(BigDecimal.class)) {
            BigDecimal total;
            total = BigDecimal.valueOf(args[0].doubleValue()).add(BigDecimal.valueOf(args[1].doubleValue()));
            return (T) total;
        }
        return null;
    }

    public static Operations createInstance() throws CloneNotSupportedException {
        Operations result = null;
        if (pluss == null) {
            result = new Plus();
        } else {
            result = ((Mapping) pluss).clone();
        }
        return result;
    }


}
