package com.cofrinho;

/**
 * The Real class represents a currency of type Real.
 * 
 * <p>
 * This class inherits from {@link Moeda} and implements the abstract methods to
 * display information about the currency and convert the value from Real to Real (no conversion).
 * Since the value is already in Reais, the conversion method simply returns the value without changes.
 * </p>
 */
public class Real extends Moeda {

    /**
     * Constructor for the Real class.
     * 
     * @param valor The value of the currency in Reais.
     */
    public Real(double valor) {
        super(valor);
    }

    /**
     * Displays information about the currency.
     * <p>
     * This method prints the type of currency (Real) and the value of the currency in Reais.
     * </p>
     */
    @Override
    public void info() {
        System.out.println("Real: " + valor);
    }

    /**
     * Returns the value of the currency in Reais.
     * <p>
     * Since the value is already in Reais, this method simply returns the currency's value
     * without performing any additional conversion.
     * </p>
     * 
     * @return The value of the currency in Reais.
     */
    @Override
    public double converter() {
        return valor;
    }
}
