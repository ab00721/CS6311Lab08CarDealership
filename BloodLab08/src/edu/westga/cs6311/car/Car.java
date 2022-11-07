package edu.westga.cs6311.car;

/**
 * Create variables, constructors, and methods for Car 
 * @author Anna Blood
 * @version 10/12/22
 *
 */
public class Car {
	private int stockNum;
	private String model;
	private String make;
	private int year;
	private String vin;
	private String color;
	private boolean forSale;
	private int mileage;

	/**
	 * Constructor
	 * @param stockNum dealership stock number
	 * @param model model name of the car
	 * @param make manufacturer of the car
	 * @param year model year of the car
	 * @param vin car VIN number
	 * @param color car paint color
	 * @param forSale is car for sale
	 */
	public Car(int stockNum, String model, String make, int year, String vin, String color, boolean forSale) {
		this.stockNum = stockNum;
		this.model = model;
		this.make = make;
		this.year = year;
		this.vin = vin;
		this.color = color;
		this.forSale = forSale;
		this.mileage = 0;
	}

	/**
	 * Getter 
	 * 
	 * @return the mileage
	 */
	public int getMileage() {
		return this.mileage;
	}

	/**
	 * Setter
	 * 
	 * @param newMileage the mileage to set
	 */
	public void setMileage(int newMileage) {
		this.mileage = newMileage;
	}

	/**
	 * Getter
	 * 
	 * @return the stock_num
	 */
	public int getStockNum() {
		return this.stockNum;
	}

	/**
	 * Getter
	 * 
	 * @return the model
	 */
	public String getModel() {
		return this.model;
	}

	/**
	 * Getter
	 * 
	 * @return the make
	 */
	public String getMake() {
		return this.make;
	}

	/**
	 * Getter
	 * 
	 * @return the year
	 */
	public int getYear() {
		return this.year;
	}

	/**
	 * Getter
	 * 
	 * @return the VIN
	 */
	public String getVin() {
		return this.vin;
	}

	/**
	 * Getter
	 * 
	 * @return the color
	 */
	public String getColor() {
		return this.color;
	}

	/**
	 * Getter
	 * 
	 * @return the for_sale
	 */
	public boolean isForSale() {
		return this.forSale;
	}
	
	/**
	 * Setter
	 * 
	 * @param newForSale the forSale to set	 
	 */
	public void setForSale(boolean newForSale) {
		this.forSale = newForSale;
	}

	/**
	 * Get a text representation of the data in this car
	 * @return the text details of the car
	 */
	public String getCarInfo() {
		return String.format("Model: %s, Make: %s, Year: %s, Vin: %s, Color: %s, Mileage: %s",
				this.getModel(), this.getMake(), this.getYear(), this.getVin(), this.getColor(), this.getMileage());
	}
}
