package com.xgen.interview;

public class DefaultPrinter implements IPrinter {

    private String priceString(float price) {
        return String.format("€%.2f", price);
    }

    public String printLine(ShoppingItem item, float price) {

        return item.getName() + " — " + item.getAmount() + " — "+ priceString(price);
    }

    public String printTotal(float totalPrice) {
        return "TOTAL: " + priceString(totalPrice);
    }
}
