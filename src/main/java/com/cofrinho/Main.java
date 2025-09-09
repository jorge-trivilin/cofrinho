package com.cofrinho;

import java.util.Scanner;

/**
 * Command-line front-end for the piggy bank application.
 *
 * <p>This class provides a simple, menu-driven user interface to interact with
 * a {@link PiggyBank}: add currencies, withdraw amounts from an existing
 * stored currency type, list stored currencies, and compute the total value in
 * Brazilian Real (BRL).</p>
 *
 * <p>The implementation is intentionally minimal and designed for demonstration
 * and learning purposes; input validation is basic and invalid input may throw
 * runtime exceptions (for example, {@link java.util.InputMismatchException}).</p>
 *
 * @see PiggyBank
 */

public class Main {
    /**
     * Application entry point. Presents a short menu loop and executes the
     * selected action until the user chooses to exit.
     *
     * @param args command-line arguments (ignored)
     * @throws java.util.InputMismatchException if the user types non-numeric input when a number is expected
     */
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    PiggyBank piggy = new PiggyBank();
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Add coin");
            System.out.println("2 - Remove coin");
            System.out.println("3 - List coins");
            System.out.println("4 - Calculate total value converted to Real");
            System.out.println("5 - Exit");
            opcao = scanner.nextInt();

            switch (opcao) {
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
                    System.out.printf("Total converted to Real: R$%.2f%n", piggy.totalInBRL());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    /**
     * Prompts the user to choose a currency type and a value, then adds the
     * created currency instance to {@code piggy}.
     *
     * @param scanner a Scanner used to read user input; must not be null
     * @param piggy the PiggyBank that will receive the new currency; must not be null
     * @throws java.util.InputMismatchException if the user inputs a non-numeric value when a number is expected
     */
    private static void addCurrency(Scanner scanner, PiggyBank piggy) {
        System.out.println("Choose a currency:");
        System.out.println("1 - Dollar");
        System.out.println("2 - Euro");
        System.out.println("3 - Real");
        int tipoMoeda = scanner.nextInt();

        System.out.println("Enter the value:");
        double valor = scanner.nextDouble();
        
        switch (tipoMoeda) {
            case 1:
                piggy.add(new Dollar(valor));
                break;
            case 2:
                piggy.add(new Euro(valor));
                break;
            case 3:
                piggy.add(new Real(valor));
                break;
            default:
                System.out.println("Invalid currency.");
        }
    }

    /**
     * Prompts the user for a currency type and an amount, then attempts to
     * withdraw the amount from the first stored currency of that type.
     *
     * @param scanner a Scanner used to read user input; must not be null
     * @param piggy the PiggyBank to withdraw from; must not be null
     * @throws java.util.InputMismatchException if the user inputs a non-numeric value when a number is expected
     */
    private static void withdrawCurrency(Scanner scanner, PiggyBank piggy) {
        System.out.println("Choose a currency to withdraw from:");
        System.out.println("1 - Dollar");
        System.out.println("2 - Euro");
        System.out.println("3 - Real");
        int tipoMoeda = scanner.nextInt();

        System.out.println("Enter the amount to withdraw:");
        double valor = scanner.nextDouble();
        Currency currencyType = null;

        switch (tipoMoeda) {
            case 1:
                currencyType = new Dollar(0);
                break;
            case 2:
                currencyType = new Euro(0);
                break;
            case 3:
                currencyType = new Real(0);
                break;
            default:
                System.out.println("Invalid currency.");
                return;
        }

        boolean success = piggy.withdraw(currencyType, valor);
        if (!success) {
            System.out.println("Could not withdraw the value. Check if it exists in the piggy bank or if there is sufficient balance.");
        }
    }
}
