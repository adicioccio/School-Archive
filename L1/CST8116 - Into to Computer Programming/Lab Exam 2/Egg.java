/*
 * Author: Stanley Pieda
 * Professor: Lab Professor
 * Date: Oct 7, 2020
 * Description: Lab exam 1 section 321 sample answer by Stanley Pieda
 */

/* This class abstracts a, egg */
public class Egg {
	private double ounces;
	private double pricePerOunce;
	
	/* Default, no parameters constructor */
	public Egg() {
		
	}

	/* Accessor for ounces */
	public double getOunces() {
		return ounces;
	}

	/* Mutator for ounces */
	public void setOunces(double ounces) {
		this.ounces = ounces;
	}

	/* Accessor for pricePerOunce */
	public double getPricePerOunce() {
		return pricePerOunce;
	}

	/* Mutator for pricePerOunce */
	public void setPricePerOunce(double pricePerOunce) {
		this.pricePerOunce = pricePerOunce;
	}
	
	/* Work method to calculate sales cost of egg */
	public double calculateSalesCost() {
		return pricePerOunce * ounces * 1.40;
	}

}
