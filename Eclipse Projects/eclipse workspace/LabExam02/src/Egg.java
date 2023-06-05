/*
 * Adam DI Cioccio
 * Mohammad Pataory
 * December 8, 2020
 * Lab Exam 02
 */

/* This class abstracts a, egg */
public class Egg {
	private double ounces;
	private double pricePerOunce;
	
	//non parameterized constructor
	public Egg() {
		
	}

	//ounce getter
	public double getOunces() {
		return ounces;
	}

	//ounce setter
	public void setOunces(double ounces) {
		this.ounces = ounces;
	}

	//get price
	public double getPricePerOunce() {
		return pricePerOunce;
	}

	//set price
	public void setPricePerOunce(double pricePerOunce) {
		this.pricePerOunce = pricePerOunce;
	}
	
	//calculate sales cost method
	public double calculateSalesCost() {
		return pricePerOunce * ounces * 1.40;
	}

}
