package com.company.calculation;


import com.company.exception.IncorrectValueException;
import com.company.operations.ConstOperation;
import com.company.operations.Operations;

import java.math.BigDecimal;
import java.util.HashMap;

public interface Calcul<T extends Number> {

    void setOperations(HashMap<ConstOperation, Operations> operations);

    BigDecimal getResult();

    <T extends Number> T count(String s, Class type, T... args);

    void setExp(String[] exp) throws IncorrectValueException;

}
