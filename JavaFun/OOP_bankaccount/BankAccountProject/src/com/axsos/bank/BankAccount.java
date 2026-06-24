package com.axsos.bank;
public class BankAccount {
    // MEMBER VARIABLES
    private double checkingBalance;
    private double savingsBalance;

    private static int accounts;
    private static double totalMoney; // refers to the sum of all bank account checking and savings balances

    // CONSTRUCTOR
    // Be sure to increment the number of accounts
    public  BankAccount(){
        accounts++;
    }
    // GETTERS
    // for checking, savings, accounts, and totalMoney
    public double getCheckingBalance(){
        return checkingBalance;
    }
    public double getSavingsBalance(){
        return savingsBalance;
    }
    public int getAccounts(){
        return  accounts;
    }
    public double getTotalMoney(){
        return totalMoney;
    }

    // METHODS

    // deposit
    // - users should be able to deposit money into their checking or savings account
    public void deposit(double amount ,String thierAccount){
    if(thierAccount.equals("checking")){
        checkingBalance += amount;
    } else if (thierAccount.equals("saving")) {
        savingsBalance += amount;
    }
    totalMoney +=amount;
    }


    // withdraw
    // - users should be able to withdraw money from their checking or savings account
    // - do not allow them to withdraw money if there are insufficient funds
    // - all deposits and withdrawals should affect totalMoney

    public void withdraw(double amount, String thierAccount){
        if(thierAccount.equals("checking")){
            if(amount>checkingBalance){
                System.out.println("error please try again");
                return;
            }
            checkingBalance-=amount;
        } else if (thierAccount.equals("saving")) {
            if(amount>savingsBalance){
                System.out.println("error please try again");
                return;
            }
            savingsBalance -= amount;
        }
        totalMoney -= amount;
    }

    // getBalance
    // - display total balance for checking and savings of a particular bank account
    public void getBalance(){
        System.out.printf("this is your checking account balance: %.2f%n",checkingBalance);
        System.out.printf("this is your Saving account balance: %.2f%n",savingsBalance);
        System.out.printf("Your total balance: %.2f%n",checkingBalance + savingsBalance);
    }


}
