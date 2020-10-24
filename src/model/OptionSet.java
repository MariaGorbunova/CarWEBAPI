/**
 * @author Maria Gorbunova
 * 35B 
 * Assignment Number 3 
 * Due Date Oct 30
 * Date Submitted Oct 30 
 */
package model;

import java.util.*;
import java.io.Serializable;

public class OptionSet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Option> opt;
	private Option choice;
	private String name;
	boolean DEBUG = false;

	// constructors
	public OptionSet() {
	}

	public OptionSet(String n) {
		opt = new ArrayList<>();
		name = n;
	}

	// old constructor
	public OptionSet(String n, int size) {
		opt = new ArrayList<>();
		// opset = new ArrayList<>();
		// ArrayList<AConcreteType> list = new ArrayList<>();

		/*
		 * for (int i = 0; i < size; i++) { opt.get(i) = new Option(); }
		 */
		name = n;
	}

	public OptionSet(OptionSet newOptionSet) {
		this.opt = (ArrayList<Option>) newOptionSet.opt.clone(); // creates and returns the copy of the object
		this.name = newOptionSet.name;
	}

	// getters&setters
	protected ArrayList<Option> getOpt() {
		return opt;
	}

	protected Option getOpt(int index) {
		return opt.get(index);
	}


	protected void setOpt(ArrayList<Option> opt) {
		this.opt = opt;
	}

	protected void setOpt(Option opt, int index) {
		this.opt.set(index, opt);// = opt;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	public Option getChoice() {
		return choice;
	}

	public void setChoice(Option choice) {
		this.choice = choice;
	}

	// lab3
	// setOptionChoice(), given the name of an option,
	// would save that choice inside the option set.
	public void setOptionChoice(String optionName) {
		for (int i = 0; i < opt.size(); i++) {
			if (opt.get(i).getName().equals(optionName)) {
				choice = opt.get(i);
				break;
			}
		}
	}

	// getOptionChoice() would return the option chosen
	// if any, otherwise it should return null.
	public Option getOptionChoice() {
		return choice;
	}

	// add
	protected void addOption(String name, float price) {
		opt.add(new Option(name, price));
		/*
		 * setOptName(name, index); setOptPrice(price, index);
		 */
	}

	// find using name
	protected Option findOption(String name) {
		if (name == null) {
			return null;
		}
		for (Option temp : opt) {
			if (name.equals(temp.getName())) {
				return temp;
			}
		}
		return null;
	}

	// update option at a certain index
	protected void updateOption(String name, float price, int i) {
		if (i >= 0 && i < opt.size()) { // make sure the index is within the range
			opt.get(i).setName(name);
			opt.get(i).setPrice(price);
		}
	}

	// methods working with Option class <<====
	// update option price
	protected void updateOptionPrice(String name, float price) {
		Option option = findOption(name);
		if (option != null) {
			option.setPrice(price);
		}
	}

	// Update the name
	protected void updateOptionName(float price, String name) {
		Option option = findOption(name);
		if (option != null) {
			option.setName(name);
		}
	}

	// to get/set name of the option
	protected void setOptName(String nameOpt, int index) {
		this.opt.get(index).setName(nameOpt);
	}

	protected String getOptName(int index) {
		return opt.get(index).getName();
	}

	// to get/set price of the option
	protected void setOptPrice(float price, int index) {
		this.opt.get(index).setPrice(price);
	}

	protected float getOptPrice(int index) {
		return opt.get(index).getPrice();
	}

	// delete
	// for deleting I need to redo the whole array??????
	// delete one option
	protected void deleteOption(String name) {

	}

	// delete all options
	protected void deleteAllOptions() {

	}

	// print method
	protected void printOptionSet() {

		if (DEBUG)
			System.out.print("Print method in OptionSet:");

		System.out.print("\nName of the set: " + name);
		System.out.print("\n\tName (Price)\n");
		for (int i = 0; i < opt.size(); i++) {
			opt.get(i).optionPrintMethod();
		}
	}
	/*
	 * // inner class protected static class Option implements Serializable{ private
	 * String name = null; private float price = 0;
	 * 
	 * // constructors public Option() { }
	 * 
	 * public Option(Option opt) { this.name = opt.name; this.price = opt.price; }
	 * 
	 * public Option(String name, float price) { this.name = name; this.price =
	 * price; }
	 * 
	 * // setters&getters protected String getName() { return name; }
	 * 
	 * protected void setName(String name) { this.name = name; }
	 * 
	 * protected float getPrice() { return price; }
	 * 
	 * protected void setPrice(float price) { this.price = price; } //print method
	 * protected void optionPrintMethod() { System.out.printf("\t"+ name );
	 * System.out.printf (" ($%.2f)\n", price) ;
	 * 
	 * } }
	 */
}
