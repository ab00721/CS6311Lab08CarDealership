package edu.westga.cs6311.main;

import edu.westga.cs6311.dealership.CarDealer;

/**
* Main class to call methods from Car and Car Dealer  
* @author Anna Blood
* @version 10/12/22
*/
public class Main {

	/**
	 * Entry point into the application
	 * @param args not used
	 */
	public static void main(String[] args) {
		final CarDealer myCarDealer = new CarDealer("cardealer");
		
		int indexA = 0; 
		while (myCarDealer.getCarsThatHaveMileageOver(80000)[indexA] != null) {
			System.out.println(myCarDealer.getCarsThatHaveMileageOver(80000)[indexA].getCarInfo());
			indexA++;	
		}
		
		int indexB = 0;
		while (myCarDealer.getCarsThatAreSameMakeModel("Pontiac", "GTO")[indexB] != null) {
			System.out.println(myCarDealer.getCarsThatAreSameMakeModel("Pontiac", "GTO")[indexB].getCarInfo());
		indexB++;
		}
		
		int indexC = 0;
		while (myCarDealer.locateCarsForSaleThatMatch("GTO", "blue", 50000)[indexC] != null) {
			System.out.println(myCarDealer.getCarsThatAreSameMakeModel("Pontiac", "GTO")[indexC].getCarInfo());
		indexC++;
		}
	}	
}