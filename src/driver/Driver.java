/**
 * @author Maria Gorbunova
 * 35B 
 * Assignment Number 1 
 * Due Date Oct 9
 * Date Submitted Oct 9 
 */
package driver;

/**
 * @author Maria Gorbunova
 * 35B 
 * Assignment Number 2 
 * Due Date Oct 19
 * Date Submitted Oct 19 
 */


import model.*;
import util.*;

public class Driver {

	public static void main(String[] args) {
		System.out.printf("\n     ============= ASSIGNMENT 1 =============\n");

		String file = ("FordWagonZTW.txt");
	
		try {	
			Automobile auto = new Automobile();
			FileIO f1 = new FileIO(file);
			auto = f1.readFile(auto);
			f1.serialize(auto);
			auto = f1.deserialize();
		} catch (Exception e) {
			System.out.println("Error -- " + e.toString());
		}	
		System.out.printf("\n\n   ~~~~~~~~~~~~~~ End of the program! ~~~~~~~~~~~~~\n");
	}

}
