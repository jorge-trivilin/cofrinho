package com.cofrinho;

import java.util.Scanner;

/**
 * Main class that implements the coin piggy bank management system.
 * 
 * <p>
 * This program simulates a piggy bank that allows the user to add coins of different
 * types (Dollar, Euro, Real), remove a specific amount from a coin, and list all 
 * the coins present in the piggy bank. Additionally, the program can calculate the total
 * value of all stored coins converted to Brazilian Real.
 * </p>
 * 
 * <p>
 * The user interacts through an options menu that includes:
 * </p>
 * <ul>
 * <li>Add a coin to the piggy bank, specifying the type and value of the coin.</li>
 * <li>Remove a specific amount from an existing coin in the piggy bank.</li>
 * <li>List all the coins in the piggy bank.</li>
 * <li>Calculate the total value of all coins converted to Brazilian Real.</li>
 * <li>Exit the program.</li>
 * </ul>
 * 
 * <p>
 * The program keeps running until the user chooses the exit option.
 * </p>
 */

public class Main {
    /**
     * Main method that starts the piggy bank management application.
     * <p>
     * The user interacts with a menu that allows adding coins, removing
     * amounts from coins, listing all the coins, and calculating the total value 
     * converted to Brazilian Real. The menu loop continues until the user selects the exit option.
     * </p>
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cofrinho cofrinho = new Cofrinho();
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
                    adicionarMoeda(scanner, cofrinho);
                    break;
                case 2:
                    removerMoeda(scanner, cofrinho);
                    break;
                case 3:
                    cofrinho.listagemMoedas();
                    break;
                case 4:
                    System.out.printf("Total converted to Real: R$%.2f%n", cofrinho.totalConvertido());
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
     * Adds a coin to the piggy bank based on the user's choice.
     * <p>
     * This method presents the user with a list of currency types (Dollar, Euro, Real)
     * and asks for the value of the coin to be added. The corresponding coin is then 
     * created and added to the piggy bank.
     * </p>
     * 
     * @param scanner  The Scanner object used to get user input.
     * @param cofrinho The Cofrinho object where the coin will be added.
     */
    private static void adicionarMoeda(Scanner scanner, Cofrinho cofrinho) {
        System.out.println("Choose a currency:");
        System.out.println("1 - Dollar");
        System.out.println("2 - Euro");
        System.out.println("3 - Real");
        int tipoMoeda = scanner.nextInt();

        System.out.println("Enter the value:");
        double valor = scanner.nextDouble();
        
        switch (tipoMoeda) {
            case 1:
                cofrinho.adicionar(new Dolar(valor));
                break;
            case 2:
                cofrinho.adicionar(new Euro(valor));
                break;
            case 3:
                cofrinho.adicionar(new Real(valor));
                break;
            default:
                System.out.println("Invalid currency.");
        }
    }

    /**
     * Removes a specific amount from an existing coin in the piggy bank.
     * <p>
     * This method allows the user to choose the type of coin (Dollar, Euro, Real)
     * and the amount they wish to subtract from the total balance of that coin. If the coin
     * with the specified value exists and has sufficient balance, the amount will be subtracted.
     * Otherwise, an error message will be displayed.
     * </p>
     * 
     * @param scanner  The Scanner object used to get user input.
     * @param cofrinho The Cofrinho object from which the amount will be subtracted.
     */
    private static void removerMoeda(Scanner scanner, Cofrinho cofrinho) {
        System.out.println("Choose a currency to subtract value from:");
        System.out.println("1 - Dollar");
        System.out.println("2 - Euro");
        System.out.println("3 - Real");
        int tipoMoeda = scanner.nextInt();
    
        System.out.println("Enter the amount to subtract:");
        double valor = scanner.nextDouble();
        Moeda moedaParaRemover = null;
    
        switch (tipoMoeda) {
            case 1:
                moedaParaRemover = new Dolar(0); // Passing 0 since the value will be adjusted by the removal method
                break;
            case 2:
                moedaParaRemover = new Euro(0); 
                break;
            case 3:
                moedaParaRemover = new Real(0); 
                break;
            default:
                System.out.println("Invalid currency.");
                return;
        }
    
        // Attempts to subtract the value from the coin in the piggy bank
        boolean sucesso = cofrinho.remover(moedaParaRemover, valor);
        if (!sucesso) {
            System.out.println("Could not subtract the value from the coin. Check if it exists in the piggy bank or if there is sufficient balance.");
        }
    }
}
