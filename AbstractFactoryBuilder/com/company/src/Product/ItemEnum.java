package Product;

public enum ItemEnum {
    BIGMAC("BigMac"),
    ROYAL_CHEESBURGER("Royal CheesBurger"),
    POTATO_FRY("Potato Fry"),
    CHICKEN_MACNUGGETS("Chicken MacNuggets"),
    COCACOLA("CocaCola"),
    JUICE("Juice"),
    LATTE("Latte");

    private String symbol;

    ItemEnum(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}
