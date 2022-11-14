package com.xgen.interview;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DefaultPrinterTest {

    IPrinter printer;

    @Before
    public void setUp() {
       printer = new DefaultPrinter();
    }

    @Test
    public void printLine() {
        ShoppingItem item = new ShoppingItem("banana", 5);
        assertEquals(printer.printLine(item, 20.0f), "banana — 5 — €20.00");
    }

    @Test
    public void printTotal() {
        assertEquals(printer.printTotal(20.0f), "TOTAL: €20.00");
    }
}