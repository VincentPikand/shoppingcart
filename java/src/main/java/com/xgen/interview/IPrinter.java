package com.xgen.interview;

import java.util.HashMap;

public interface IPrinter {

    /**
     * Declares how the lines should look for each item.
     * @param item item to be printed.
     * @return String of the line to be printed.
     */
    String printLine(ShoppingItem item, float price);

    /**
     * Declares how the "total price" line should look.
     * @param totalPrice The total price to be printed.
     * @return The string which shows the total price.
     */
    String printTotal(float totalPrice);

}
