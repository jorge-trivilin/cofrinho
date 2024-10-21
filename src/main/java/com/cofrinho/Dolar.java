package com.cofrinho;

/**
 * The Dolar class represents a currency of type Dollar.
 * 
 * <p>
 * This class inherits from {@link Moeda} and implements the abstract methods to
 * display information about the currency and convert the value from Dollar to Real. 
 * The conversion rate used is 1 Dollar = 5.00 Reais (this value can be adjusted as needed).
 * </p>
 */

public class Dolar extends Moeda {

    /**
     * Constructor for the Dolar class.
     * 
     * @param valor The value of the currency in Dollars.
     */
    public Dolar(double valor) {
        super(valor);
    }

    /**
     * Displays information about the currency.
     * <p>
     * This method prints the type of currency (Dollar) and the value of the currency in Dollars.
     * </p>
     */
    @Override
    public void info() {
        System.out.println("Dollar - Value: $" + valor);
    }

    /**
     * Converts the value of the currency from Dollar to Real.
     * <p>
     * The conversion rate used is 1 Dollar = 5.00 Reais. This method returns
     * the equivalent value in Reais.
     * </p>
     * 
     * @return The converted value from Dollar to Real.
     */
    @Override
    public double converter() {
        return valor * 5.00;
    }
}
