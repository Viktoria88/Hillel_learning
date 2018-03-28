package com.company.operations;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Divide extends Mapping {

    private static Operations divid = null;

    protected Divide() {
        super(ConstOperation.DIVIDE);
    }

    @Override
    public <T extends Number> T execute(Class type, T... args) {
        if (type.equals(BigInteger.class)) {
            if (BigInteger.valueOf(args[0].longValue()).mod(BigInteger.valueOf(args[1].longValue())) != null) {
                BigDecimal total;
                BigDecimal a = BigDecimal.valueOf(args[1].longValue());
                total = BigDecimal.valueOf(args[0].longValue()).divide(a, 2, RoundingMode.HALF_UP);
                return (T) total;
            } else {
                BigInteger total;
                total = BigInteger.valueOf(args[0].longValue()).divide(BigInteger.valueOf(args[1].longValue()));
                return (T) total;
            }
        } else if (type.equals(BigDecimal.class)) {
            BigDecimal total;
            BigDecimal a = BigDecimal.valueOf(args[1].doubleValue());
            total = BigDecimal.valueOf(args[0].doubleValue()).divide(a, 2, RoundingMode.HALF_UP);
            return (T) total;
        }
        return null;
    }

    public static Operations createInstance() throws CloneNotSupportedException {
        Operations result = null;
        if (divid == null) {
            result = new Divide();
        } else {
            result = ((Mapping) divid).clone();
        }
        return result;
    }
}
