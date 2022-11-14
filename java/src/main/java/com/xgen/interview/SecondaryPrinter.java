package com.xgen.interview;

public class SecondaryPrinter implements IPrinter {
    private String priceString(float price) {
        return String.format("€%.2f", price);
    }

    public String printLine(ShoppingItem item, float price) {

        return priceString(price) + " — " + item.getName() + " — "+ item.getAmount();
    }

    public String printTotal(float totalPrice) {
        return "TOTAL: " + priceString(totalPrice);
    }
}
