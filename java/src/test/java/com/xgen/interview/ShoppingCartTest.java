package com.xgen.interview;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class ShoppingCartTest {

    IPrinter printer;
    Pricer pricer;
    ShoppingCart cart;
    ByteArrayOutputStream output;

    @Before
    public void setup() {
        printer = new DefaultPrinter();
        pricer = new Pricer();
        cart = new ShoppingCart(printer, pricer);
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }


    @Test
    public void validConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new ShoppingCart(printer, null));
        assertThrows(IllegalArgumentException.class, () -> new ShoppingCart(null, pricer));
    }

    @Test
    public void testOneItem() {
        var actual = List.of(
                new ShoppingItem("banana", 2)
        );

        cart.addItem("banana", 2);

        assertEquals(cart.toList(), actual);
    }

    @Test
    public void testIllegalItem() {
        assertThrows(IllegalArgumentException.class, () -> cart.addItem(null, 5));
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("banana", -2));
    }

    @Test
    public void testTwoItems() {
        var actual = List.of(
            new ShoppingItem("banana", 2),
            new ShoppingItem("apple", 1)
        );

        cart.addItem("banana", 2);
        cart.addItem("apple", 1);

        assertEquals(cart.toList(), actual);
    }

    @Test
    public void testItemUpdated() {
        var actual = List.of(
                new ShoppingItem("banana", 5)
        );

        cart.addItem("banana", 2);
        cart.addItem("banana", 3);

        assertEquals(cart.toList(), actual);
    }

    @Test
    public void testItemOrder() {
        var actual = List.of(
                new ShoppingItem("banana", 5),
                new ShoppingItem("apple", 2)
        );

        cart.addItem("banana", 2);
        cart.addItem("apple", 2);
        cart.addItem("banana", 3);

        assertEquals(cart.toList(), actual);
    }

    /**
     * NB! this test is dependent on the implementation of DefaultPrinter.
     */
   @Test
    public void testOneItemPrinting() {
        cart.addItem("banana", 5);

        cart.printReceipt();

        String actual =
                "banana — 5 — €10.00\n" +
                "TOTAL: €10.00\n";

        assertEquals(output.toString(),
                actual);
    }

    /**
     * NB! this test is dependent on the implementation of DefaultPrinter.
     */
    @Test
    public void testFloatingPointSum() {
        cart.addItem("banana", 5);
        cart.addItem("orange", 3);

        cart.printReceipt();

        String actual =
                "banana — 5 — €10.00\n" +
                "orange — 3 — €3.75\n" +
                "TOTAL: €13.75\n";

        assertEquals(output.toString(),
                actual);
    }

    /**
     * NB! this test is dependent on the implementation of DefaultPrinter.
     */
    @Test
    public void testFreeItem() {
        cart.addItem("Chocolate", 5);

        cart.printReceipt();

        String actual =
                "Chocolate — 5 — €0.00\n" +
                "TOTAL: €0.00\n";

        assertEquals(output.toString(),
                actual);
    }
    /**
     * NB! this test is dependent on the implementation of DefaultPrinter.
     */
    @Test
    public void testCombinationOfItems() {
        cart.addItem("Chocolate", 1);
        cart.addItem("banana", 10);
        cart.addItem("apple", 5);

        cart.printReceipt();

        String actual =
                "Chocolate — 1 — €0.00\n" +
                "banana — 10 — €20.00\n" +
                "apple — 5 — €5.00\n" +
                "TOTAL: €25.00\n";

        assertEquals(output.toString(),
                actual);
    }
}


