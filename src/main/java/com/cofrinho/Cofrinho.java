package com.cofrinho;

import java.util.ArrayList;

/**
 * The Cofrinho class represents a piggy bank that stores different types of coins.
 * 
 * <p>
 * The class allows adding and removing coins from the piggy bank, listing all stored coins,
 * and calculating the total value of all coins converted to Brazilian Real.
 * The stored coins are instances of the abstract class {@link Moeda} and its subclasses,
 * such as {@link Dolar}, {@link Euro}, and {@link Real}.
 * </p>
 */

public class Cofrinho {
    private ArrayList<Moeda> moedas;

    /**
     * Constructor for the Cofrinho class.
     * <p>
     * Initializes the piggy bank with an empty list of coins.
     * </p>
     */
    public Cofrinho() {
        this.moedas = new ArrayList<>();
    }

    /**
     * Adds a new coin to the piggy bank.
     * <p>
     * The coin is added to the internal list of coins, and a message is displayed
     * confirming the addition, showing the coin's value and type (e.g., Dollar, Euro, Real).
     * </p>
     * 
     * @param moeda The coin to be added, which must be an instance of a
     *              class that inherits from {@link Moeda}.
     */
    public void adicionar(Moeda moeda) {
        moedas.add(moeda);
        System.out.println("Coin added: " + moeda.getValor() + " " + moeda.getClass().getSimpleName());
    }

    /**
     * Subtracts a specific value from an existing coin in the piggy bank.
     * <p>
     * This method finds the corresponding type of coin in the piggy bank and, if there is enough balance,
     * subtracts the indicated value from the coin's balance. If the value is greater
     * than the available balance, an error message is displayed.
     * </p>
     * 
     * @param moeda The coin type to perform the subtraction on (Dollar, Euro, Real).
     * @param valor The amount to be subtracted from the coin's balance.
     * @return {@code true} if the value was successfully subtracted, {@code false} if there was
     *         insufficient balance or the coin was not found.
     */
    public boolean remover(Moeda moeda, double valor) {
        for (Moeda m : moedas) {
            if (m.getClass() == moeda.getClass()) { // Found the right coin type
                if (m.getValor() >= valor) {
                    m.subtrairValor(valor);
                    System.out.println("Subtracted " + valor + " from the coin " + m.getClass().getSimpleName());
                    return true;
                } else {
                    System.out.println("Insufficient balance to subtract.");
                    return false;
                }
            }
        }
        System.out.println("Coin not found.");
        return false;
    }

    /**
     * Lists all the coins present in the piggy bank.
     * <p>
     * The method displays information about all the coins stored in the piggy bank.
     * If the piggy bank is empty, a message indicating that will be displayed.
     * </p>
     */
    public void listagemMoedas() {
        if (moedas.isEmpty()) {
            System.out.println("Piggy bank is empty.");
            return;
        }

        System.out.println("Coins in the piggy bank:");
        for (Moeda moeda : moedas) {
            moeda.info();
        }
    }

    /**
     * Calculates the total value of all the coins in the piggy bank converted to Brazilian Real.
     * <p>
     * The method iterates through all the coins in the piggy bank and sums their values converted to Real,
     * using the {@link Moeda#converter()} method for each coin.
     * </p>
     * 
     * @return The total value in Brazilian Real of all the coins in the piggy bank.
     */
    public double totalConvertido() {
        double total = 0;
        for (Moeda moeda : moedas) {
            total += moeda.converter();
        }
        return total;
    }
}
