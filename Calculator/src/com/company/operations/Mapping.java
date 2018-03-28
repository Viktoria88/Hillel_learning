package com.company.operations;


abstract class Mapping implements Operations {

    private String symbol = getSymbol();
    private static Operations oper = null;

    public Mapping(ConstOperation symbol) {

        if (symbol == null) {
            throw new IllegalArgumentException("Operation don't enter yet");
        }
        this.symbol = String.valueOf(symbol).trim().toLowerCase();

    }

    @Override
    public Operations clone() throws CloneNotSupportedException {
        Operations copy = (Operations) super.clone();
        return copy;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isMySymbol(String symb) {

        boolean result = false;
        if (symbol.equalsIgnoreCase(ConstOperation.getEnumByString(symb))) {
            result = true;
        }
        return result;

    }
}
