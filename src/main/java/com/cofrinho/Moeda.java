package com.cofrinho;

/**
 * The abstract Moeda (Currency) class defines the basic behavior of a currency.
 * 
 * <p>
 * This class serves as the base for different types of currencies, such as {@link Dolar}, {@link Euro}
 * and {@link Real}. It defines the attributes and common methods that all currencies share,
 * such as the currency value, displaying information, and conversion to Brazilian Real.
 * Classes that inherit from {@link Moeda} must implement the abstract methods {@code info()} 
 * and {@code converter()} to provide the specific behavior for each currency.
 * </p>
 */
public abstract class Moeda {

    /**
     * The value of the currency.
     */
    protected double valor;

    /**
     * Constructor for the Moeda class.
     * 
     * @param valor The value of the currency.
     */
    public Moeda(double valor) {
        this.valor = valor;
    }

    /**
     * Returns the value of the currency.
     * 
     * @return The value of the currency.
     */
    public double getValor() {
        return valor;
    }

    /**
     * Abstract method to display information about the currency.
     * <p>
     * This method must be implemented by the subclasses to display the type
     * of currency and its corresponding value.
     * </p>
     */
    public abstract void info();

    /**
     * Abstract method to convert the value of the currency to Brazilian Real.
     * <p>
     * This method must be implemented by the subclasses to provide the logic
     * for converting the specific type of currency.
     * </p>
     * 
     * @return The value converted to Brazilian Real.
     */
    public abstract double converter();

    /**
     * Subtracts a value from the currency, if the value is less than or equal to the current balance of the currency.
     * <p>
     * If the value to be subtracted is greater than the currency's balance, an error message is displayed.
     * </p>
     * 
     * @param valor The value to be subtracted from the currency.
     */
    public void subtrairValor(double valor) {
        if (valor <= this.valor) {
            this.valor -= valor;
        } else {
            System.out.println("The subtraction value is greater than the currency's balance.");
        }
    }

    /**
     * Compares whether two currencies are equal based on their value and type.
     * <p>
     * Two currencies are considered equal if they have the same type (class)
     * and the same value.
     * </p>
     * 
     * @param obj The object to be compared.
     * @return {@code true} if the currencies are of the same type and have the same value,
     *         {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Moeda moeda = (Moeda) obj;
        return Double.compare(moeda.valor, valor) == 0;
    }

    /**
     * Returns the hash code of the currency, based on its value.
     * <p>
     * This method ensures that currencies with the same value have the same hash
     * code, facilitating comparisons in collections that use hashing.
     * </p>
     * 
     * @return The hash code based on the currency's value.
     */
    @Override
    public int hashCode() {
        return Double.hashCode(valor);
    }
}
