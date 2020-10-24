/**
 * @author Maria Gorbunova
 * 35B 
 * Assignment Number 3 
 * Due Date Oct 30
 * Date Submitted Oct 30 
 */
package adapter;
import exception.*;
//import util.*;

public interface FixAuto {
	public   String   fix(int errorNo, String line) throws AutoException;
	// fix method
	// make   the   fix   method   accessible   through   FixAuto   interface.
}
