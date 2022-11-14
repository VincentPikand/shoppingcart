package com.xgen.interview;

public class SecondaryPrinter implements IPrinter {
    private String priceString(float price) {
        return String.format("€%.2f", price);
    }

    /**
     * Prints the line for a shopping item
     * @param item item to be printed.
     * @param price item price.
     * @return line in the format of "price — name — amount"
     */
    public String printLine(ShoppingItem item, float price) {

        return priceString(price) + " — " + item.getName() + " — "+ item.getAmount();
    }

    public String printTotal(float totalPrice) {
        return "TOTAL: " + priceString(totalPrice);
    }
}
