package com.cofrinho;

import java.util.ArrayList;

/**
 * Simple piggy bank that stores multiple {@link Currency} instances.
 *
 * <p>This class provides a minimal in-memory container that supports adding
 * currency instances, withdrawing from the first stored instance of a given
 * type, listing stored currencies to standard output, and computing the total
 * converted amount in BRL.</p>
 */
public class PiggyBank {
    private ArrayList<Currency> currencies;

    /** Creates an empty PiggyBank. */
    public PiggyBank() {
        this.currencies = new ArrayList<>();
    }

    /**
     * Adds a currency instance to the piggy bank.
     *
     * @param currency the Currency to add; must not be null
     * @throws NullPointerException if {@code currency} is null
     */
    public void add(Currency currency) {
        if (currency == null) throw new NullPointerException("currency");
        currencies.add(currency);
        System.out.println("Added: " + currency.getValue() + " " + currency.getClass().getSimpleName());
    }

    /**
     * Withdraws an amount from the first stored currency that matches the provided type.
     *
     * <p>The {@code currencyType} parameter is used to identify the currency class to
     * withdraw from; only the runtime class is inspected, not its value.</p>
     *
     * @param currencyType a Currency instance whose class identifies the type to withdraw from
     * @param amount the amount to withdraw; must be non-negative
     * @return {@code true} if the withdrawal succeeded; {@code false} if the currency was not
     *         found or had insufficient balance
     * @throws NullPointerException if {@code currencyType} is null
     */
    public boolean withdraw(Currency currencyType, double amount) {
        if (currencyType == null) throw new NullPointerException("currencyType");
        for (Currency c : currencies) {
            if (c.getClass() == currencyType.getClass()) {
                if (c.getValue() >= amount) {
                    c.withdraw(amount);
                    System.out.println("Withdrew " + amount + " from " + c.getClass().getSimpleName());
                    return true;
                } else {
                    System.out.println("Insufficient balance to withdraw.");
                    return false;
                }
            }
        }
        System.out.println("Currency not found.");
        return false;
    }

    /**
     * Prints information about all stored currencies to standard output.
     */
    public void list() {
        if (currencies.isEmpty()) {
            System.out.println("Piggy bank is empty.");
            return;
        }
        System.out.println("Currencies in piggy bank:");
        for (Currency c : currencies) {
            c.printInfo();
        }
    }

    /**
     * Computes the total value of all stored currencies converted to BRL.
     *
     * @return total amount in BRL
     */
    public double totalInBRL() {
        double total = 0;
        for (Currency c : currencies) {
            total += c.toBRL();
        }
        return total;
    }
}
