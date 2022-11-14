package com.xgen.interview;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SecondaryPrinterTest {

    IPrinter printer;

    @Before
    public void setUp() {
        printer = new SecondaryPrinter();
    }

    @Test
    public void printLine() {
        ShoppingItem item = new ShoppingItem("banana", 5);
        assertEquals(printer.printLine(item, 20.0f), "€20.00 — banana — 5");
    }

    @Test
    public void printTotal() {
        assertEquals(printer.printTotal(20.0f), "TOTAL: €20.00");
    }
}