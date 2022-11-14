package com.xgen.interview;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingItemTest {

    @Test
    public void updateAmount() {
        ShoppingItem item = new ShoppingItem("banana", 1);
        item.addToAmount(2);
        assertEquals(item.getAmount(), 3);
    }
}