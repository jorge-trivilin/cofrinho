package com.cofrinho;

/**
 * Brazilian Real (BRL) currency implementation.
 */
public class Real extends Currency {
    /**
     * Creates a Real amount.
     *
     * @param value the amount in BRL
     */
    public Real(double value) { super(value); }

    /** Prints the amount in Reais to standard output. */
    @Override
    public void printInfo() {
        System.out.println("Real: " + value);
    }

    /**
     * Returns the amount in BRL (no conversion required).
     *
     * @return the same value passed to the constructor
     */
    @Override
    public double toBRL() {
        return value;
    }
}
