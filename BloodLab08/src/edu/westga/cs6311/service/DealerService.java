/**
 * 
 */
package edu.westga.cs6311.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import edu.westga.cs6311.car.Car;


/**
 * This class is simply to facilitate reading in the data from the data file
 * DO NOT MODIFY!
 */
public class DealerService {

	private static final int carPropLength = 7;
	private static final String  carDataFile = "car_data.csv";

	/**
	 * Read data in from external file and map over to objects
	 * @return an ArrayList<Car> with data from the file or an empty ArrayList if an error happens.
	 */
	public static Car[] readCarCsv() {
		try {

			Car[] myReturnArray = new Car[100];

			BufferedReader myReader = new BufferedReader(new FileReader(carDataFile));

			String currentLine;
			int currentArrayItem = 0;

			while((currentLine = myReader.readLine()) != null && !currentLine.isBlank()) {
				
				if(currentArrayItem >= 100) break;
					
				String[] lineProps = currentLine.split(","); 

				if(lineProps.length != carPropLength) continue;

				int stockNum = Integer.parseInt(lineProps[0]);
				String model = lineProps[1];
				String make = lineProps[2];
				int year = Integer.parseInt(lineProps[3]);
				String vin = lineProps[4];
				String color = lineProps[5];
				boolean forSale = Boolean.parseBoolean(lineProps[6]);

				myReturnArray[currentArrayItem] = new Car(stockNum, model, make, year, vin, color, forSale);

				currentArrayItem++;
			}

			myReader.close();

			return myReturnArray;
		}
		catch(FileNotFoundException notFoundException) {
			return null;

		}
		catch(IOException ioException) {
			return null;
		}

	}

	/**
	 * Generate random mileage
	 * @return random mileage from 0 to 100k
	 */
	public static int generateCarMileage() {
		Random myRandom = new Random();

		return myRandom.nextInt(100000);
	}
}
