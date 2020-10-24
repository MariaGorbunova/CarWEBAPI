/**
 * @author Maria Gorbunova
 * 35B 
 * Assignment Number 3 
 * Due Date Oct 30
 * Date Submitted Oct 30 
 */


package adapter;

public interface UpdateAuto {
// updateOptionSetName
	//This   function   searches   the   Model   for   a   given   
	// OptionSet   and   sets   the   name   of   OptionSet   to
	//newName.
	public   void   updateOptionSetName(String   Modelname,   String   OptionSetname,   String newName);
	
	
	//updateOptionPrice
	//This   function   searches   the   Model   for   a   given   OptionSet  
	//and   Option   name,   and   sets   the   price   to 
	//newPrice.
	public   void   updateOptionPrice(String   Modelname,   String   Optionname,   String Option,   float   newprice);
}
