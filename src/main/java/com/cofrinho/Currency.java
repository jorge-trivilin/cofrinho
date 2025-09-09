package com.cofrinho;

/**
 * Abstract base class representing a monetary amount in a specific currency.
 *
 * <p>Concrete subclasses provide presentation (via {@link #printInfo()}) and a
 * conversion to Brazilian Real (BRL) via {@link #toBRL()}. Instances are mutable
 * (the amount can be changed by {@link #withdraw(double)}).</p>
 *
 * <p>Equality is defined by runtime class and numeric value. This class is
 * intentionally small and not thread-safe; callers must synchronize externally
 * if used from multiple threads.</p>
 *
 * @since 1.0
 */
public abstract class Currency {

    /** The current amount stored for this currency. */
    protected double value;

    /**
     * Creates a Currency instance with the given amount.
     *
     * @param value the initial amount for this currency
     */
    public Currency(double value) {
        this.value = value;
    }

    /**
     * Returns the current amount for this currency.
     *
     * @return the amount represented by this Currency
     */
    public double getValue() {
        return value;
    }

    /**
     * Prints a short, human-readable description of the currency and its amount.
     * <p>Implementations should write a concise representation to standard
     * output (for example: "Dollar - Value: $10.0"). This method is primarily
     * used by sample CLI code and tests; production code may present values
     * differently.</p>
     */
    public abstract void printInfo();

    /**
     * Converts the current amount to Brazilian Real (BRL).
     *
     * @return equivalent amount in BRL
     */
    public abstract double toBRL();

    /**
     * Subtracts {@code amount} from this currency balance if sufficient funds exist.
     * If {@code amount} is greater than the balance, no change is made and a
     * message is printed to standard output.
     *
     * @param amount the amount to withdraw; must be non-negative
     * @throws IllegalArgumentException if {@code amount} is negative
     */
    public void withdraw(double amount) {
        if (amount < 0) throw new IllegalArgumentException("amount must be non-negative");
        if (amount <= this.value) {
            this.value -= amount;
        } else {
            System.out.println("The withdrawal amount is greater than the currency's balance.");
        }
    }

    /**
     * Adds {@code amount} to this currency balance.
     *
     * @param amount the amount to add; must be non-negative
     * @throws IllegalArgumentException if {@code amount} is negative
     */
    public void deposit(double amount) {
        if (amount < 0) throw new IllegalArgumentException("amount must be non-negative");
        this.value += amount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Currency other = (Currency) obj;
        return Double.compare(other.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }
}
