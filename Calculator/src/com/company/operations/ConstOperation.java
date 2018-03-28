package com.company.operations;


public enum ConstOperation {

    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String symbol;

    ConstOperation(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static String getEnumByString(String symb) {
        for (ConstOperation e : ConstOperation.values()) {
            if (symb.equals(e.getSymbol())) {
                return e.name();
            }
        }
        return null;
    }
}
