# Notes

## Printer interface
As one of the requirements was to change the receipt format
and allow for other formatting options in the future, I've created a
Printer interface, which has two methods `String printLine(float price)` and `String printTotal(float price)`.
With this interface, it is easy to implement your own version of the printer accommodating your customers needs.
I also wrote 2 classes which fulfill this interface, namely `DefaultPrinter` and `SecondaryPrinter`.

## ShoppingItem class
I've implemented a `ShoppingItem` class to nicely structure the shopping items.
This might seem overkill, but I assume that in the future
the complexity of the system will rise rapidly and then having 
a separate class makes perfect sense.

## Changes to shopping cart

### Constructor
I've added a printer object to the ShoppingCart class, which
determines how the receipt will be printed. This enables easy refactoring/changes
in the future.

### Keeping track of items
I'm using a LinkedHashMap for keeping track of the contents
in the right order. In the background, it uses a linked list
to keep track of the order and a hashmap for quick access.<br/>
In the case of adding an item multiple times, its amount
will be incremented instead of a new insertion. This is also
my experience with my local supermarket :) <br/>.

### "method safety"
I've added null checks to the constructor and addItem to make
sure no unexpected behaviour happens.

### printReceipt()
printReceipt() keeps track of the total price while looping over
all elements of the cart. For each item, we print some information, which
is determined by the printer we are using. In the end, we print
the total amount. Here again, the format is determined by our printer. 

## Tests
I've added a `toList()` method in the `ShoppingCart` class to ease testing. While
adding class methods just for testing is not ideal, it is important to be pragmatic, and I've
found this to be the best solution. The upside is that the core functionality of `ShoppingCart`
can now be tested regardless of the printer that is used. It should be noted
that tests related to `printReceipt()` are still dependent on the printer, because it is inherently
coupled with printing.

## Improvements
To further improve the solution, I would change out all `float`'s to only use integer based calculations as
it is generally safer and faster. I would also separate the calculation of the prices from `printReceipt()` to have
more testing coverage.