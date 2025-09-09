package com.cofrinho;

/**
 * Euro (EUR) currency implementation.
 *
 * <p>Uses a fixed conversion rate to BRL. The rate is currently hard-coded as
 * 6.00 BRL per 1 EUR; change the implementation if a different or dynamic rate
 * is required.</p>
 */
public class Euro extends Currency {
    /**
     * Creates a Euro amount.
     *
     * @param value the amount in EUR
     */
    public Euro(double value) { super(value); }

    /** Prints the amount in Euros to standard output. */
    @Override
    public void printInfo() {
        System.out.println("Euro: " + value);
    }

    /**
     * Converts EUR to BRL using the fixed internal rate (6.00 BRL = 1 EUR).
     *
     * @return equivalent amount in BRL
     */
    @Override
    public double toBRL() {
        return value * 6.00;
    }
}
