package com.xgen.interview;

import java.util.Objects;

/**
 * a class for shopping items that are used in the cart.
 */
public class ShoppingItem {
    private int amount;
    private final String name;


    public ShoppingItem(String name, int amount) {
        this.amount = amount;
        this.name = name;
    }

    public void addToAmount(int toAdd) {
        this.amount += toAdd;
    }

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingItem)) return false;
        ShoppingItem that = (ShoppingItem) o;
        return amount == that.amount && Objects.equals(name, that.name);
    }
}
