/**
 * @author Maria Gorbunova
 * 35B 
 * Assignment Number 3 
 * Due Date Oct 30
 * Date Submitted Oct 30
 */
package adapter;
//import java.util.*; // linkedhashmap

import exception.AutoException;
import model.*;
import util.*;
import scale.*;

// This   class	will   contain   all   the   implementation   of   any  
//method   declared   in   the   interfaces.

public abstract class ProxyAutomobile { // extends EditOptions {
	// call the method using an interface)
	private Automobile a1; // it was static before lab 3
	private static Fleet f = new Fleet();

	// private static LinkedHashMap<String, Automobile> lhm;

	public ProxyAutomobile() {
	}

	public Automobile getA1() {
		return a1;
	}

	public void setA1(Automobile a1) {
		this.a1 = a1;
	}

	public static Fleet getF() {
		return f;
	}

	public static void setF(Fleet f) {
		ProxyAutomobile.f = f;
	}

	public void BuildAuto(String filename) {
		if (extension(filename).equals("txt")) {
			FileIO f1 = new FileIO(filename);
			a1 = f1.readFile(a1);
		} else {
			FileIO f1 = new FileIO(filename);
			a1 = f1.readProp(a1);
		}
		// lhm = new LinkedHashMap<>();
		
			//System.out.println(a1.getMake() + " " + a1.getModel() + " " + a1.getYear());
		f.put(a1.getMake() + " " + a1.getModel() + " " + a1.getYear(), a1);
		// System.out.printf("\n ==================== Constructor ====================
		// \n");
	}

	public String extension(String filename) {
		String extension = "";

		int i = filename.lastIndexOf('.');
		if (i > 0) {
			extension = filename.substring(i + 1);
		}
		return extension;
	}

	public void printAuto(String modelname) {
		// System.out.printf("\n ==================== printAuto method
		// ==================== \n");
		a1 = f.find(modelname);
		a1.printAll();
	}

	/*
	 * // Print all specifications of a vehicle with choices? public void
	 * printOptions(String key) { Automobile tempAutomobile; tempAutomobile =
	 * fleet.get(key); tempAutomobile.printOptions(); }
	 */

	public void updateOptionSetName(String modelname, String optionSetname, String newName) {
		a1 = f.find(modelname);
		a1.updateOptSetName(optionSetname, newName);
	}

	public void updateOptionName(String modelname, String optionSetname, String optionName, String newName) {
		a1 = f.find(modelname);
		a1.updateOption(optionSetname, optionName, newName);
	}

	public void updateOptionPrice(String modelname, String optionName, String option, float newprice) {
		a1 = f.find(modelname);
		a1.updateOption(optionName, option, newprice);
	}

	public String fix(int errorNo, String line) {
		AutoException a = new AutoException(errorNo, line);
		return a.fix(errorNo, line);
	}

	// lab3
	public void setOptionChoice(String modelname, String setName, String optionName) {
		a1 = f.find(modelname);
		a1.setOptionChoice(setName, optionName);
	}

	public float getOptionChoicePrice(String modelname, String setName) {
		a1 = f.find(modelname);
		return a1.getOptionChoicePrice(setName);
	}

	public void getTotalPrice(String modelname) {
		// a1.getTotalPrice();
		a1 = f.find(modelname);
		System.out.print("\n    The total price is : " + a1.getTotalPrice());
	}

	// extra credit

	public void deleteAuto(String modelname) {
		// a1.getTotalPrice();
		a1 = f.find(modelname);
		f.delete(modelname, a1);
		// System.out.print("\n Deleted!\n ");
	}

	public void deleteAll(String modelname) {
		f.deleteMap();
	}

	public void find(String modelname) {
		a1 = f.find(modelname);
		a1.printAutomotive();
	}

	public void updateFleetName(String modelname, Automobile newAuto) {
		// a1 = f.find(modelname);
		f.updateAuto(modelname, newAuto);
	}

	// lab 4
	public void editAuto(int threadNo, int operationNo, String[] automobile) {
		System.out.print("\nEdit auto for scale package(threads): \n");
		EditOptions temp = new EditOptions(threadNo, operationNo, automobile);
		temp.start();
		// System.out.print( "\n Here \n");
		// temp.start();
	}
	
	// lab5
	public void addAutoLHM(Automobile a1) {
		f.put(a1.getMake() + " " + a1.getModel() + " " + a1.getYear(), a1);
	}
}
