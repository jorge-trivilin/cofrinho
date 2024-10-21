package com.cofrinho;

/**
 * The Euro class represents a currency of type Euro.
 * 
 * <p>
 * This class inherits from {@link Moeda} and implements the abstract methods to
 * display information about the currency and convert the value from Euro to Real. 
 * The conversion rate used is 1 Euro = 6.00 Reais (this value can be adjusted as needed).
 * </p>
 */
public class Euro extends Moeda {

    /**
     * Constructor for the Euro class.
     * 
     * @param valor The value of the currency in Euros.
     */
    public Euro(double valor) {
        super(valor);
    }

    /**
     * Displays information about the currency.
     * <p>
     * This method prints the type of currency (Euro) and the value of the currency in Euros.
     * </p>
     */
    @Override
    public void info() {
        System.out.println("Euro: " + valor);
    }

    /**
     * Converts the value of the currency from Euro to Real.
     * <p>
     * The conversion rate used is 1 Euro = 6.00 Reais. This method returns
     * the equivalent value in Reais.
     * </p>
     * 
     * @return The converted value from Euro to Real.
     */
    @Override
    public double converter() {
        return valor * 6.00;
    }
}
