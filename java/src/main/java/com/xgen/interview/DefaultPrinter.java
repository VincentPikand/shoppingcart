package com.xgen.interview;

public class DefaultPrinter implements IPrinter {

    private String priceString(float price) {
        return String.format("€%.2f", price);
    }

    /**
     * Prints the line for a shopping item
     * @param item item to be printed.
     * @param price item price.
     * @return line in the format of "name — amount — price"
     */
    public String printLine(ShoppingItem item, float price) {

        return item.getName() + " — " + item.getAmount() + " — "+ priceString(price);
    }

    public String printTotal(float totalPrice) {
        return "TOTAL: " + priceString(totalPrice);
    }
}
