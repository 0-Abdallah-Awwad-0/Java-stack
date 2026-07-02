# Orders and Items

## Assignment

This assignment builds a simple cafe ordering system using multiple Java classes.

The goal is to organize related data into separate class files instead of keeping everything inside one file.

## Concepts Practiced

* Creating custom classes
* Using member variables
* Creating objects with the `new` keyword
* Using another class as a data type
* Using `ArrayList`
* Updating object fields
* Testing code with a separate `main` file

## Files

OrdersItems
└── src
├── Item.java
├── Order.java
└── TestOrders.java

## Item.java

The `Item` class stores information about a menu item.

### Member Variables

* `String name`
* `double price`

Example items:

* mocha
* latte
* drip coffee
* cappuccino

## Order.java

The `Order` class stores information about a customer order.

### Member Variables

* `String name`
* `double total`
* `boolean ready`
* `ArrayList<Item> items`

Each order has a customer name, total price, ready status, and a list of ordered items.

## TestOrders.java

The `TestOrders` class contains the `main` method.

This file is used to create menu items, create customer orders, update orders, and print order information.

## Program Features

The program does the following:

1. Creates 4 menu items.
2. Sets the name and price for each item.
3. Creates 4 customer orders.
4. Sets the customer name for each order.
5. Adds items to customer orders.
6. Updates each order total.
7. Updates whether an order is ready.
8. Prints order information to the console.

## Example Actions

* Jimmy orders a mocha.
* Noah orders a cappuccino.
* Sam orders a latte.
* Rami's order becomes ready.
* Sam orders two more lattes.
* Jimmy's order becomes ready.

## Example Code

```java
Item item1 = new Item();

item1.name = "mocha";
item1.price = 4.5;
```

```java
Order order1 = new Order();

order1.name = "Rami";
order1.ready = false;
order1.total = 0.0;
order1.items = new ArrayList<Item>();
```

## How to Run

Open the project in IntelliJ IDEA.

Run the `TestOrders.java` file.

The output will appear in the console.

## Notes

`Item.java` and `Order.java` do not have the `main` method.

`TestOrders.java` is the file used to run and test the program.

This assignment is important because it introduces object-oriented programming and shows how classes can help organize data in a cleaner way.
