package com.company.calculation;

import com.company.annotations.DescriptionCalculation;
import com.company.annotations.TypeCalculation;
import com.company.exception.IncorrectValueException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


@TypeCalculation(type = TypeCalculation.Type.RUTISHAUSER_CALCULATION)
@DescriptionCalculation(description = "Can count simple operation, follow the calculation priority if it is set in brackets")
public class RutCalc<T extends Number> extends Calculation {

    private List<T> variable = new LinkedList<>();
    private List<Integer> level = new LinkedList<>();
    private List<String> mark = new LinkedList<>();

    private final T constForArrVariable = null;
    private final String constForArrMark = "0";
    private final MyGeneric<T> type = new MyGeneric<T>(getClass());
    private final Class<T> getGeneric = type.getGenericType();
    private Class typeNumber = null;


    protected <T> RutCalc(String[] args, Class<T> genericType) {
        super(args);
        try {
            typeNumber = genericType;
            adds(args, typeNumber);
        } catch (IncorrectValueException e) {
            System.out.println(e);
        }
    }

    @Override
    public BigDecimal getResult() {

        while (level.size() > 1) {

            int max = 0;
            max = Collections.max(level);
            int index = level.indexOf(max);
            T res = null;
            int score = 0;

            for (int i = index; i < level.size(); i += 2) {
                score++;
                try {

                    if (level.get(i + 2) == max) {
                        try {
                            if (res == null && score == 1) {
                                res = (T) count(mark.get(i + 1), typeNumber, variable.get(i), variable.get(i + 2));
                            } else {
                                res = (T) count(mark.get(i + 1), typeNumber, res, variable.get(i + 2));
                            }
                        } catch (ArithmeticException e) {
                            System.out.println("Divided by 0");
                        }
                    } else {
                        i++;
                        int del = i - score * 2;
                        change(i, res, max);
                        removes(i, del);
                        break;
                    }

                } catch (IndexOutOfBoundsException e) {
                    if (mark.contains(")")) {
                        i++;
                        int del = i - score * 2;
                        change(i, res, max);
                        removes(i, del);
                        break;
                    } else {
                        int del = 0;
                        change(i, res, max);
                        removes(i, del);
                        break;
                    }
                }
            }
        }
        if (level.size() == 1) {
            if (variable.get(0) instanceof BigInteger) {
                BigDecimal g = new BigDecimal(variable.get(0).doubleValue());
                return g;
            } else {
                BigDecimal g = (BigDecimal) variable.get(0);
                return g;
            }
        }
        return null;
    }

    protected void adds(String[] s, Class<T> getGenericType) throws IncorrectValueException {
        int lvl = 0;

        for (int i = 0; i < s.length; i++) {
            try {
                T d = null;
                if (getGenericType.equals(BigInteger.class)) {
                    d = (T) parseBigInt(s[i]);
                } else if (getGenericType.equals(BigDecimal.class)) {
                    d = (T) parseBigDecimal(s[i]);
                }
                variable.add(d);
                mark.add(s[i]);
                lvl++;
                level.add(lvl);
            } catch (NumberFormatException e) {
                if ("(".equals(s[i])) {
                    variable.add(constForArrVariable);
                    mark.add(s[i]);
                    lvl++;
                    level.add(lvl);
                } else if (")".equals(s[i]) || isSymb(s[i])) {
                    variable.add(constForArrVariable);
                    mark.add(s[i]);
                    lvl--;
                    level.add(lvl);
                } else {
                    throw new IncorrectValueException(s[i]);
                }
            }
        }
    }

    private void removes(int index, int del) {

        for (int j = index - 1; j >= del; j--) {
            variable.remove(j);
            mark.remove(j);
            level.remove(j);
        }
    }

    private void change(int index, T r, int max) {

        variable.set(index, r);
        mark.set(index, constForArrMark);
        level.set(index, max - 1);

    }
}
