package com.cofrinho;

/**
 * Dollar (USD) currency implementation.
 *
 * <p>Uses a fixed conversion rate to BRL. The rate is currently hard-coded as
 * 5.00 BRL per 1 USD; change the implementation if a different or dynamic rate
 * is required.</p>
 */
public class Dollar extends Currency {
    /**
     * Creates a Dollar amount.
     *
     * @param value the amount in USD
     */
    public Dollar(double value) { super(value); }

    /** Prints the amount in dollars to standard output. */
    @Override
    public void printInfo() {
        System.out.println("Dollar - Value: $" + value);
    }

    /**
     * Converts USD to BRL using the fixed internal rate (5.00 BRL = 1 USD).
     *
     * @return equivalent amount in BRL
     */
    @Override
    public double toBRL() {
        return value * 5.00; // conversion rate
    }
}
