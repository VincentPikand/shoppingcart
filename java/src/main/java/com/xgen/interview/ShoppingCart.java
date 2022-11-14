package com.xgen.interview;

import java.util.*;


/**
 * updated implementation of Shopping`Cart
 */
public class ShoppingCart implements IShoppingCart {
    private final HashMap<String, ShoppingItem> contents;
    private final IPrinter printer;
    private final Pricer pricer;

    /**
     * Initializes the Shopping cart
     * @param printer the printer to be used
     * @param pricer the pricing database to be used
     */
    public ShoppingCart(IPrinter printer, Pricer pricer) {
        if (printer == null) {
            throw new IllegalArgumentException("Printer can not be null");
        }
        if (pricer == null) {
            throw new IllegalArgumentException("Pricer can not be null");
        }
        this.printer = printer;
        this.pricer = pricer;
        this.contents = new LinkedHashMap<>();
    }


    public void addItem(String itemType, int number) {
        if(itemType == null) throw new IllegalArgumentException("Item name can not be null.");
        if(number <= 0) throw new IllegalArgumentException("Item amount must be > 0.");
        if (contents.containsKey(itemType)) {
            var item = contents.get(itemType);
            item.addToAmount(number);
            return;
        }
        ShoppingItem item = new ShoppingItem(itemType, number);
        contents.put(itemType, item);
    }

    public void printReceipt() {
        int total = 0;
        for(var item : contents.values()) {
            int pricePerItem = pricer.getPrice(item.getName());
            total += item.getAmount() * pricePerItem;
            float price = (float) pricePerItem * item.getAmount() / 100;
            String line = printer.printLine(item, price);
            System.out.println(line);
        }
        float convertedTotal = (float) total / 100;
        String totalLine = printer.printTotal(convertedTotal);
        System.out.println(totalLine);
    }

    public List<ShoppingItem> toList() {
        return new ArrayList<>(contents.values());
    }

}
