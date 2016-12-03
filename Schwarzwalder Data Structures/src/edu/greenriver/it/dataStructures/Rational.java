/**
 * Jami Schwarzwalder
 * Dec 2, 2016
 * Rational.java
 * Immutable data type for rational numbers 
 */
package edu.greenriver.it.dataStructures;

/**
 * 1.2.16 Immutable data type for rational numbers that supports addition,
 * subtraction, multiplication, and division.
 * 
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class Rational {
	private long numerator;
	private long denominator;

	/**
	 * Creates a new Rational
	 *
	 * @param numerator
	 * @param denominator
	 */
	public Rational(long numerator, long denominator) {
		super();
		this.numerator = numerator;
		this.denominator = denominator;
	}

	/**
	 * sum of this number and b
	 * 
	 * @param b
	 * @return
	 */
	public Rational plus(Rational b) {
		Rational number = new Rational(numerator, denominator);

		if (b.denominator == number.denominator) {
			number.numerator += b.numerator;
		} else {
			number.numerator = (number.numerator * b.denominator) + (b.numerator * number.denominator);
			number.denominator = number.denominator * b.denominator;
		}

		return number;

	}

	/**
	 * difference of this number and b
	 * 
	 * @param b
	 * @return
	 */
	public Rational minus(Rational b) {
		Rational number = new Rational(numerator, denominator);

		if (b.denominator == number.denominator) {
			number.numerator -= b.numerator;
		} else {
			number.numerator = (number.numerator * b.denominator) - (b.numerator * number.denominator);
			number.denominator = number.denominator * b.denominator;
		}

		return number;
	}

	/**
	 * product of this number and b
	 * 
	 * @param b
	 * @return
	 */
	public Rational times(Rational b) {
		Rational number = new Rational(numerator, denominator);

		number.numerator = number.numerator * b.numerator;
		number.denominator = number.denominator * b.denominator;

		return number;

	}

	/**
	 * quotient of this number and b
	 * 
	 * @param b
	 * @return
	 */
	public Rational dividedBy(Rational b) {
		Rational number = new Rational(numerator, denominator);

		number.numerator = number.numerator * b.denominator;
		number.denominator = number.denominator * b.numerator;

		return number;
	}

	/**
	 * is this number equal to that?
	 * 
	 * @param that
	 * @return
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object that) {
		if (that instanceof Rational) {
			return this.numerator == ((Rational) that).numerator && this.denominator == ((Rational) that).denominator;
		}
		return false;

	}

	/**
	 * string representation
	 * 
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}
}
