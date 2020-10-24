/**
 * @author Maria Gorbunova
 * 35B 
 * Assignment Number 3 
 * Due Date Oct 30
 * Date Submitted Oct 30 
 */
package adapter;


public class BuildAuto 
	extends ProxyAutomobile implements CreateAuto, UpdateAuto, 
	FixAuto, CustomizeAuto, Fleetable, EditThread {

	// this class remains empty. 
	// It connects two interfaces with our proxy class, which has all 
	// the implementations of methods from both interfaces.
	
	// why are we doing this?
	// all the method should have been implemented here but we got proxyAutomobile (abstract class)
	// and for this reason BuldAuto extends proxyAutomobile
	
	// all this design is because of safety, putting everything "inside"
	

}
