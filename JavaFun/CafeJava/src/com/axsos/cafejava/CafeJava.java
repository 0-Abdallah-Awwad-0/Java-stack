package com.axsos.cafejava;

public class CafeJava {

    public static void main(String[] args) {

        // APP VARIABLES

        // Lines of text that will appear in the app
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";


        // Menu variables
        double mochaPrice = 4.5;
        double dripCoffeePrice = 3.5;
        double lattePrice = 6.5;
        double cappuccinoPrice = 2.5;


        // Customer name variables
        String customer1 = "Shatha";
        String customer2 = "Ahmad";
        String customer3 = "Sali";
        String customer4 = "Adam";


        // Order completions
        boolean isReadyOrder1 = true;   // Shatha
        boolean isReadyOrder2 = true;   // Ahmad
        boolean isReadyOrder3 = false;  // Sali
        boolean isReadyOrder4 = true;   // Adam


        // APP INTERACTION SIMULATION

        // Greeting example
        System.out.println(generalGreeting + customer1);


        // 1. Sali ordered a coffee
        if (isReadyOrder3) {
            System.out.println(customer3 + readyMessage);
        } else {
            System.out.println(customer3 + pendingMessage);
        }


        // 2. Ahmad ordered a cappuccino
        if (isReadyOrder2) {
            System.out.println(customer2 + readyMessage);
            System.out.println(displayTotalMessage + cappuccinoPrice);
        } else {
            System.out.println(customer2 + pendingMessage);
        }


        // 3. Sali just ordered 2 lattes
        double saliTotal = lattePrice * 2;

        System.out.println(displayTotalMessage + saliTotal);

        // Change this value to test your if statement
        isReadyOrder3 = true;

        if (isReadyOrder3) {
            System.out.println(customer3 + readyMessage);
        } else {
            System.out.println(customer3 + pendingMessage);
        }


        // 4. Adam was charged for coffee, but he ordered a latte
        double adamDifference = lattePrice - dripCoffeePrice;

        System.out.println(customer4 + ", you owe $" + adamDifference);

    }

}