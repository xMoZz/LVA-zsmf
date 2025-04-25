/**
 * This class represents a constant integer value.
 * PLEASE DO NOT CHANGE THIS FILE.
 */
public class IntConst {

    private final int value;

    /**
     * Initializes this constant with the specified value.
     * @param value the value which 'this' represents.
     */
    public IntConst(int value) {

        this.value = value;
    }

    /**
     * Returns the sum of 'this' and 'c'.
     * @param c the second operand, c != null.
     * @return the sum of 'this' and 'c'.
     */
    public IntConst plus(IntConst c) {

        return new IntConst(c.value + this.value);
    }

    /**
     * Returns 'true' only if 'this' represents the value 0.
     * @return 'true' if 'this' represents the value 0, otherwise 'false'.
     */
    public boolean isZero() {

        return value == 0;
    }

    /**
     * Returns 'true' if and only if 'this' is less than 'c'.
     * @param c the other constant to compare with, c != null.
     * @return 'true' if 'this' is less than 'c', otherwise 'false'.
     */
    public boolean lessThan(IntConst c) {

        return this.value < c.value;
    }

    /**
     * Returns 'true' if and only if 'this' is the same value as 'c'.
     * @param c the other constant to compare with, c != null.
     * @return 'true' if 'this' represent the same value, otherwise 'false'.
     */
    public boolean isEqual(IntConst c) {

        return this.value == c.value;
    }

    /**
     * Returns a readable representation of 'this', i.e., the value as a string.
     * @return a readable representation of 'this'.
     */
    @Override
    public String toString() {

        return Integer.toString(value);
    }
}
