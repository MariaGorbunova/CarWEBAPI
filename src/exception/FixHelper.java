
/**
 * @author Maria Gorbunova
 * 35B 
 * Assignment Number 2 
 * Due Date Oct 19
 * Date Submitted Oct 19 
 */
package exception;

public class FixHelper {

	public FixHelper() {}
	
	
	/*   I hardcoded the data although it could be a user input
	 * 	
	 * */ 
	 
	
	
	
	// fix the name of the automobile
	public String fix1(String line) {
		line = "No name";
		return line;
	}
	
	// baseprice
	public String fix2(String line) {
		line = "0.0";
		return line;
	}
	
	//number of optionsets
	public String fix3(String line) {
		line = "5";
		//System.out.print(" =========> " + line + "\n");
		return line;
	}
	
	//name of the optionset
		public String fix4(String line) {
			line = "No name";
			//System.out.print(" =========> " + line + "\n");
			return line;
		}
	
		public String fix5(String line) {
			line = "10";
			//System.out.print(" =========> " + line + "\n");
			return line;
		}
	
}
