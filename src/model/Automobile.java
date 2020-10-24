/**
 * @author Maria Gorbunova
 * 35B 
 * Assignment Number 3 
 * Due Date Oct 30
 * Date Submitted Oct 30 
 */
package model;

import java.util.*; // importing for working with collections
import java.io.Serializable;

public class Automobile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private String name;
	private float baseprice;
	private ArrayList<OptionSet> opset; // ArrayList
	private boolean DEBUG = false;

	/// lab3 variables:
	private String make;
	private String model;
	private String year;
	private ArrayList<Option> choice;
	private float totalPrice;

	// Constructors
	public Automobile() {
	}
//old constructor
	public Automobile(String n, float baseprice, int size) {
		opset = new ArrayList<>();
		// ArrayList<AConcreteType> list = new ArrayList<>();
		/*
		 * for (int i = 0; i < size; i++) { opset[i] = new OptionSet(); } // have to do
		 * that when i know the size and name ?
		 */
		//name = n;
		this.baseprice = baseprice;
	}

	public Automobile(String make, String model, String year,  float baseprice) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.baseprice = baseprice;
		opset = new ArrayList<OptionSet>();
		choice = new ArrayList<Option>();
	}

	// setters&getters
	/*public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
*/
	public float getBaseprice() {
		return baseprice;
	}

	public void setBaseprice(float baseprice) {
		this.baseprice = baseprice;
	}

	// setters & getters for the whole arrayList
	public ArrayList<OptionSet> getOpset() {
		// System.out.print( "getOpset\n " + opset.length);
		return opset;
	}

	public  void setOpset(ArrayList<OptionSet> opset) {
		this.opset = opset;
	}

	// lab3
	public String getMake() {
		return make;
	}

	public  void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public  void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public ArrayList<Option> getChoice() {
		return choice;
	}

	public  void setChoice(ArrayList<Option> choice) {
		this.choice = choice;
	}

	// lab 3 methods
	// for choice
	public String getOptionChoice(String optionSetName) {
		String temp = null;
		for (int i = 0; i < opset.size(); i++) {
			if (opset.get(i).getName().equals(optionSetName)) {
				// tempOption =
				return opset.get(i).getOptionChoice().getName();
			}
		}
		return temp;
	}
	
	// returns the price of the chosen option!
	public float getOptionChoicePrice(String optionSetName) {
		float tempPrice = 0;
		for (int i = 0; i < opset.size(); i++) {
			if (opset.get(i).getName().equals(optionSetName)) {
				return opset.get(i).getOptionChoice().getPrice();
			}
		}
		return tempPrice;
	}

	// The method setOptionChoice() is for choosing a
	// particular option in an option set. E.g.,
	// would choose the standard transmission option.
	// After the above choice is set,
	// getOptionChoice("transmission") would return "standard" and
	// getOptionChoicePrice("transmission") would
	// return -815.
	public  void setOptionChoice(String setName, String optionName) {
		Option temp;
		for (int i = 0; i < opset.size(); i++) {
			if (opset.get(i).getName().equals(setName)) {
				opset.get(i).setOptionChoice(optionName);
				temp = opset.get(i).getOptionChoice();
				choice.add(temp);
			}
		}
	}

	public float getTotalPrice() {
		totalPrice = baseprice;
		for (int i = 0; i < choice.size(); i++) {
			totalPrice += choice.get(i).getPrice();
		}
		return totalPrice;
	}

	// find opset
	public OptionSet findOptionSet(String nameOfOptionSet) {
		if (nameOfOptionSet == null) {
			return null;
		}
		for (OptionSet temp : opset) {
			if (nameOfOptionSet.equals(temp.getName())) {
				return temp;
			}
		}
		return null; // not found
	}

	// setters & getters for one element of the array
	// get optionset by index
	public OptionSet getOpset(int i) {
		if (opset == null || i >= opset.size()) {
			return null;
		}
		return opset.get(i);
	}

	// get optionset by name
	public OptionSet getOpset(String name) {
		if (name == null) {
			return null;
		}
		for (OptionSet temp : opset) {
			if (name.equals(temp.getName())) {
				return temp;
			}
		}
		return null; // not found
	}

	// set one element of the array by index
	public  void addOptionSet(String name, int numOfOptions, int i) {
		opset.set(i, new OptionSet(name, numOfOptions));
		// opset[i].setName(name);
		if (DEBUG) {
			System.out.print(
					"addOptionSet in automotive: " + opset.get(i).getName() + " " + numOfOptions + " " + i + "\n");
		}
	}

	// Add OptionSet object to OptionSet ArrayList
	public   void addOptionSet(String optionSetName) {
		OptionSet tempOptionSet = new OptionSet(optionSetName);

		opset.add(tempOptionSet);
	}

	public  void addOptionSet(OptionSet newOptSet, int i) {
		opset.set(i, new OptionSet(newOptSet));
		// opset[i].setName(name);
		if (DEBUG) {
			System.out.print("addOptionSet in automotive: " + opset.get(i).getName() + " " + i + "\n");
		}
	}

	// update OptsetName
	public  void updateOptSetName(String oldOpSetName, String newOpSetName) {
		OptionSet optionSet = findOptionSet(oldOpSetName);
		if (optionSet != null) {
			optionSet.setName(newOpSetName);
		}
	}

	// delete OptionSet
	public  void deleteOptionSet() {
		// call deleteAllOptions() from here
	}

	// methods for working with Options through OptionSet
	public  void addOption(String name, float price, int opSetIndex) {
		opset.get(opSetIndex).addOption(name, price);

		// if (DEBUG) {
		// System.out.print(" - addOption in automotive: "
		// +opset.get(opSetIndex).getOptName(optIndex) +
		// " "+ opset.get(opSetIndex).getOptPrice(optIndex)+ " " + optIndex + "\n"); }
	}

	// update option's price for option that has a certain name
	public  void updateOption(String opSetName, String OptionName, float price) {
		OptionSet temp = getOpset(opSetName); // find the opset that you need
		if (temp != null) {
			for (int i = 0; i < temp.getOpt().size(); i++) { // go through the loop to find a certain option
				if (temp.getOpt(i).getName().equals(OptionName)) { // compare the names of the options
					temp.getOpt(i).setPrice(price); // set the price
				}
			}
		}
	}

	// update option's name
	public  void updateOption(String opSetName, String OldOptionName, String newOptionName) {
		OptionSet temp = getOpset(opSetName); // find the opset that you need
		if (temp != null) {
			for (int i = 0; i < temp.getOpt().size(); i++) { // go through the loop to find a certain option
				if (temp.getOpt(i).getName().equals(OldOptionName)) { // compare the names of the options
					temp.getOpt(i).setName(newOptionName); // set the new name
				}
			}
		}
	}

	// ????????????? add several options?
	public  void addOptions(int opSetIndex, String[] optionsNames, float[] optionsPrices) {
		for (int i = 0; i < optionsPrices.length; i++) {
			opset.get(opSetIndex).addOption(optionsNames[i], optionsPrices[i]);
		}
	}
//add several options
	public  void addOptions(String opsetName, String[] optionsNames, float[] optionsPrices) {
		
		for (int i = 0; i < optionsPrices.length; i++) {
			//opset.get(opSetIndex).addOption(optionsNames[i], optionsPrices[i]);
			findOptionSet(opsetName).addOption(optionsNames[i], optionsPrices[i]);;
		}
	}
	
	
	public void deleteOption() {
	}

	public void deleteAllOptions() {
	}

	// print methods
	public void printAutomotive() {
		if (DEBUG)
			System.out.print("Print method in Automobile class\n");
		System.out.print(this.make + " " + this.model + " " + this.year + " " + this.baseprice + " \n");
	}

	// print certain optionset
	public void printOptionSet(int i) {
		opset.get(i).printOptionSet();
	}

	// print all optionsets
	public void printOptionSet() {
		if (DEBUG)
			System.out.print("\nCalling printOptionSet from Automobile: \n");
		for (int i = 0; i < opset.size(); i++) {
			opset.get(i).printOptionSet();
		}
	}

	public void printAll() {
		printAutomotive();
		printOptionSet();
	}


}
