public class TestOrders {
    public static void main(String[] args) {

        // Menu items
        Item item1 = new Item();
        item1.name = "mocha";
        item1.price = 3.5;

        Item item2 = new Item();
        item2.name = "latte";
        item2.price = 4.0;

        Item item3 = new Item();
        item3.name = "drip coffee";
        item3.price = 2.0;

        Item item4 = new Item();
        item4.name = "cappuccino";
        item4.price = 4.5;

        // Order variables
        Order order1 = new Order();
        order1.name = "Rami";

        Order order2 = new Order();
        order2.name = "Jimmy";

        Order order3 = new Order();
        order3.name = "Noah";

        Order order4 = new Order();
        order4.name = "Sam";

        // Print order1 variable
        System.out.println(order1);

        // Print order1 total
        System.out.println(order1.total);

        // Add item1 to order2's item list and increment total
        order2.items.add(item1);
        order2.total += item1.price;

        // Noah ordered a cappuccino
        order3.items.add(item4);
        order3.total += item4.price;

        // Sam added a latte
        order4.items.add(item2);
        order4.total += item2.price;

        // Rami's order is now ready
        order1.ready = true;

        // Sam ordered more drinks - 2 lattes
        order4.items.add(item2);
        order4.items.add(item2);
        order4.total += item2.price * 2;

        // Jimmy's order is now ready
        order2.ready = true;

        // Test output
        System.out.println("\n----- Order 1 -----");
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);

        System.out.println("\n----- Order 2 -----");
        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: %s\n", order2.total);
        System.out.printf("Ready: %s\n", order2.ready);

        System.out.println("\n----- Order 3 -----");
        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: %s\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);

        System.out.println("\n----- Order 4 -----");
        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
    }
}