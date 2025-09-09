package com.cofrinho;

import java.util.Scanner;

/**
 * Simple command-line application for interacting with a {@link PiggyBank}.
 *
 * <p>Run this class to start a menu-driven program to add currencies, withdraw from
 * stored currency types, list stored currencies and compute the total in BRL.</p>
 */
public class PiggyBankApp {

    /**
     * Application entry point.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PiggyBank piggy = new PiggyBank();
        int option;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Add currency");
            System.out.println("2 - Withdraw from currency");
            System.out.println("3 - List currencies");
            System.out.println("4 - Total in BRL");
            System.out.println("5 - Exit");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addCurrency(scanner, piggy);
                    break;
                case 2:
                    withdrawCurrency(scanner, piggy);
                    break;
                case 3:
                    piggy.list();
                    break;
                case 4:
                    System.out.printf("Total converted to BRL: R$%.2f%n", piggy.totalInBRL());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 5);

        scanner.close();
    }

    /**
     * Prompts the user to choose a currency type and value, then adds it to the piggy bank.
     *
     * @param scanner the Scanner to read user input
     * @param piggy the PiggyBank to add the currency to
     */
    private static void addCurrency(Scanner scanner, PiggyBank piggy) {
        System.out.println("Choose a currency:");
        System.out.println("1 - Dollar");
        System.out.println("2 - Euro");
        System.out.println("3 - Real");
        int type = scanner.nextInt();

        System.out.println("Enter the value:");
        double value = scanner.nextDouble();

        switch (type) {
            case 1: piggy.add(new Dollar(value)); break;
            case 2: piggy.add(new Euro(value)); break;
            case 3: piggy.add(new Real(value)); break;
            default: System.out.println("Invalid currency.");
        }
    }

    /**
     * Prompts the user to select a currency type and an amount to withdraw from the piggy bank.
     *
     * @param scanner the Scanner to read user input
     * @param piggy the PiggyBank to withdraw from
     */
    private static void withdrawCurrency(Scanner scanner, PiggyBank piggy) {
        System.out.println("Choose a currency to withdraw from:");
        System.out.println("1 - Dollar");
        System.out.println("2 - Euro");
        System.out.println("3 - Real");
        int type = scanner.nextInt();

        System.out.println("Enter the amount to withdraw:");
        double amount = scanner.nextDouble();
        Currency currencyType = null;

        switch (type) {
            case 1: currencyType = new Dollar(0); break;
            case 2: currencyType = new Euro(0); break;
            case 3: currencyType = new Real(0); break;
            default: System.out.println("Invalid currency."); return;
        }

        boolean success = piggy.withdraw(currencyType, amount);
        if (!success) {
            System.out.println("Could not withdraw the requested amount. Check existence or balance.");
        }
    }
}

