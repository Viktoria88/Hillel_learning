package com.company.history;

import java.math.BigDecimal;


public class History {

    private String typeCalculation;
    private String currentData;
    private String[] args;
    private BigDecimal total;

    private static History instance;

    public static History getInstance(String typeCalculation, String data, String[] args, BigDecimal total) {
        if (instance == null) {
            instance = new History(typeCalculation, data, args, total);
        }
        return instance;
    }

    public History(String typeCalculation, String currentData, String[] args, BigDecimal total) {
        this.typeCalculation = typeCalculation;
        this.currentData = currentData;
        this.args = args;
        this.total = total;
    }

    public String getTypeCalculation() {
        return typeCalculation;
    }

    public String getCurrentData() {
        return currentData;
    }

    public String[] getArgs() {
        return args;
    }

    public BigDecimal getTotal() {
        return total;
    }

}
