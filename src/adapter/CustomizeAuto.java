/**
 * @author Maria Gorbunova
 * 35B 
 * Assignment Number 3 
 * Due Date Oct 30
 * Date Submitted Oct 30 
 */
package adapter;

public interface CustomizeAuto {
	// FOR TESTING!!!
	public void setOptionChoice(String modelname, String setName, String optionName) ;
	public float getOptionChoicePrice(String modelname, String setName) ;
	public void getTotalPrice(String modelname) ;
}
