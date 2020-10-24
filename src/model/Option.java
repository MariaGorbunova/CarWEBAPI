/**
 * @author Maria Gorbunova
 * 35B 
 * Assignment Number 3 
 * Due Date Oct 30
 * Date Submitted Oct 30 
 */

package model;

import java.io.Serializable;

public class Option implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name = null;
	private float price = 0;

	// constructors
	public Option() {
	}

	public Option(Option opt) {
		this.name = opt.name;
		this.price = opt.price;
	}

	public Option(String name, float price) {
		this.name = name;
		this.price = price;
	}

	// setters&getters
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected float getPrice() {
		return price;
	}

	protected void setPrice(float price) {
		this.price = price;
	}
	//print method
	protected void optionPrintMethod() {
		System.out.printf("\t"+ name );
		System.out.printf (" ($%.2f)\n", price) ;
	}
}
