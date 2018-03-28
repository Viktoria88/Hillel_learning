package com.company.calculation;

import com.company.exception.IncorrectValueException;
import com.company.exception.OperationNotFoundException;
import com.company.operations.ConstOperation;
import com.company.operations.Operations;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

import static com.company.operations.ConstOperation.getEnumByString;
import static java.lang.Character.isDigit;


public abstract class Calculation<T extends Number> implements Calcul<T>, Iterable<Operations> {

    protected static String[] args;
    protected static HashMap<ConstOperation, Operations> operations;

    protected Calculation(String[] args) {
        this.args = args;
    }

    public void setOperations(HashMap<ConstOperation, Operations> operations) {
        this.operations = operations;
    }

    public <T extends Number> T count(String s, Class type, T... args) {

        T res = null;
        for (ConstOperation con : operations.keySet()) {
            if (operations.get(con).isMySymbol(s)) {
                res = operations.get(con).execute(type, args);
            }
        }
        return res;
    }

    public boolean isSymb(String s) {
        getEnumByString(s);
        return true;
    }

    public void setExp(String[] exp) throws IncorrectValueException {

        for (int i = 0; i < exp.length; i++) {

            for (char c : exp[i].toCharArray()) {
                if (!isDigit(c) && isSymb(exp[i]) || c == '(' || c == ')') {
                    continue;
                } else if (isDigit(c)) {
                    continue;
                } else {
                    throw new IncorrectValueException(exp[i]);
                }
            }
        }

    }

    public BigInteger parseBigInt(String s) {
        BigInteger parsBigInt = BigInteger.valueOf(0);
        try {
            parsBigInt = parsBigInt.add(new BigInteger(s));
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        return parsBigInt;
    }

    protected BigDecimal parseBigDecimal(String s) {
        BigDecimal parsBigDecimal = BigDecimal.valueOf(0);
        try {
            parsBigDecimal = parsBigDecimal.add(new BigDecimal(s));
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        return parsBigDecimal;
    }

    @Override
    public Iterator<Operations> iterator() {
        return new OperationIterator(this.operations);
    }

    public static void existOperations() {
        OperationIterator operationIterator = new OperationIterator(operations);
        while (operationIterator.hasNext()) {
            System.out.println(operationIterator.next());
        }
        return;
    }

    public static class OperationIterator implements Iterator<Operations> {

        private int index;
        private final List<ConstOperation> listKey = new ArrayList(operations.keySet());
        Operations oper;
        private int size = operations.size();


        public OperationIterator(HashMap<ConstOperation, Operations> op) {
            operations = op;
        }


        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Operations next() {
            if (hasNext()) {
                oper = operations.get(listKey.get(index));
                index++;
            } else {
                try {
                    throw new OperationNotFoundException();
                } catch (OperationNotFoundException e) {
                    e.printStackTrace();
                }
            }
            return oper;
        }
    }

}
