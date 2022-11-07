package edu.westga.cs6311.dealership;

import edu.westga.cs6311.car.Car;
import edu.westga.cs6311.service.DealerService;

/**
* Create variables, constructors, and methods for Car Dealer
* @author Anna Blood
* @version 10/12/22
* 
*/

public class CarDealer {
	private String name;
	private Car[] carInventory;
	
	/**
	 * Constructor
	 * @param dealerName to set dealerName
	 */
	public CarDealer(String dealerName) {
		this.setName(dealerName); 
		this.setCarInventory(DealerService.readCarCsv());
		this.updateInventoryMileage();
	}
	
	/**
	 * Method to get the number of Cars in the inventory
	 * @return number of cars in inventory
	 */
	private int getNumCarsInventory() {
		return this.getCarInventory().length;
	}

	/**
	 * Method to search inventory by Stock Number
	 * @param stockNum to set stock num search
	 * @return cars in inventory that match stock num 
	 */
	public Car getCarByStockNumber(int stockNum) {
		Car result = null;
		for (int index = 0; index < this.getNumCarsInventory(); index++) {
			if (this.carInventory[index].getStockNum() == stockNum) {
				result = this.getCarInventory()[index];
			}
		}
		return result;
	}
	
	/**
	 * Method to search inventory by VIN Number
	 * @param searchVin to set vin num search
	 * @return cars in inventory that match VIN Number
	 */
	public Car getCarByVinNumber(String searchVin) {
		Car result = null;
		for (int index = 0; index < this.getNumCarsInventory(); index++) {
			if (this.carInventory[index].getVin().equals(searchVin)) {
				result = this.getCarInventory()[index];
			}
		}
		return result;
	}
	
	/**
	 * Method to update the mileage on the cars in the inventory 
	 * with a random number of miles 0 - 100000 inclusive 
	 */
	private void updateInventoryMileage() {
		for (int index = 0; index < this.getNumCarsInventory(); index++) {
			int miles = (int) (Math.random() * 100001);
			this.carInventory[index].setMileage(miles); 
		}
	}
	
	/**
	 * Method to change if the car is for sale 
	 * @param inventoryPosition to set position that matches index 
	 */
	public void toggleCarIsForSale(int inventoryPosition) {
		if (inventoryPosition < 0 || inventoryPosition >= this.getNumCarsInventory()) {
			throw new IllegalArgumentException();
		}
		
		for (int index = 0; index < this.getNumCarsInventory(); index++) {
			if (inventoryPosition == index && this.carInventory[index].isForSale()) {
				this.carInventory[index].setForSale(false);
			} else if (inventoryPosition == index && !this.carInventory[index].isForSale()) {
				this.carInventory[index].setForSale(true);
			}
		}
	}
	
	/**
	 * Method to search car inventory array and create a new array 
	 * with the cars that have mileage over searchMileage 
	 * @param searchMileage to set searchMileage
	 * @return array of cars with higher mileage that searchMileage 
	 */
	public Car[] getCarsThatHaveMileageOver(int searchMileage) {
		int index2 = 0;
		Car[] highMileage = new Car[this.getNumCarsInventory()];
		for (int index = 0; index < this.getNumCarsInventory(); index++) {
			if (this.carInventory[index].getMileage() > searchMileage) {
				highMileage[index2] = this.carInventory[index];
				index2++;
			} 
		}
		return highMileage;
	}
	
	/**
	 * Method to search car inventory for make and model and create
	 * a new array of cars of that make and model 
	 * @param searchMake to set searchMake
	 * @param searchModel to set searchModel 
	 * @return an array of cars that match the searchMake and searchModel 
	 */
	public Car[] getCarsThatAreSameMakeModel(String searchMake, String searchModel) {
		int index2 = 0;
		Car[] sameMakeModel = new Car[this.getNumCarsInventory()];
		
		for (int index = 0; index < this.getNumCarsInventory(); index++) {
			if (searchMake.equals(this.carInventory[index].getMake()) && searchModel.equals(this.carInventory[index].getModel())) {
				sameMakeModel[index2] = this.carInventory[index];
				index2++;
			}
		}

		return sameMakeModel;
	}
	
	/**
	 * Method to search car inventory for model, color, and mileage 
	 * and create a new array of cars that matches the search 
	 * @param searchModel to set searchModel
	 * @param searchColor to set searchColor
	 * @param searchMileage to set searchMileage
	 * @return an array of cars that matches searchModel, Color, and Mileage
	 */
	public Car[] locateCarsForSaleThatMatch(String searchModel, String searchColor, int searchMileage) {
		int index2 = 0; 
		Car[] locatedCars = new Car[this.getNumCarsInventory()];
		
		for (int index = 0; index < this.getNumCarsInventory(); index++) {
			if (searchModel.equals(this.carInventory[index].getModel()) && searchColor.equals(this.carInventory[index].getColor())
					&& String.valueOf(searchMileage) == this.carInventory[index].getColor()) {
				locatedCars[index2] = this.carInventory[index];
				index2++;
			}
		}
		return locatedCars;
	}
	
	/**
	 * Method to search an array and turn the array into a String
	 * @param carCollection to set the array 
	 * @return a string of the car info from the input array 
	 */
	public String formatCarResults(Car[] carCollection) {
		String carResult = "";
		for (Car index: carCollection) {
			if (index != null) {
				carResult += index.getCarInfo() + "\n";
			}
		}
		return carResult;
	}
	
	/**
	 * Getter 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Setter
	 * @param newName the name to set
	 */
	public void setName(String newName) {
		this.name = newName;
	}
	
	/**
	 * Getter 
	 * @return the carInventory
	 */
	public Car[] getCarInventory() {
		return this.carInventory;
	}

	/**
	 * Setter
	 * @param newCarInventory the carInventory to set
	 */
	public void setCarInventory(Car[] newCarInventory) {
		this.carInventory = newCarInventory;
	}
}
