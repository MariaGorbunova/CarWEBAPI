/**
 * @author Maria Gorbunova
 * 35B 
 * Assignment Number 3 
 * Due Date Oct 30
 * Date Submitted Oct 30 
 */

package driver;




import adapter.*;

public class Driver_2 {
//To   test   this   new   Automobile   class,   write   a   driver  
		//program   to   read   your   text   input   file,   populate   an instance   of
		//Automobile   class   and   print   the   OptionSet's   and   their 
		//respective   options.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.printf("\n               ============= ASSIGNMENT 3 =============\n");
		String file = ("FordWagonZTW.txt");
		
		//LinkedHashMapTemplate <ProxyAutomobile> a1 = new LinkedHashMapTemplate <ProxyAutomobile> ();
		//a1.create(file);
		
		
		String modelname = "Ford Wagon ZTW";	// Automobile name
		
		CreateAuto automobile = new  BuildAuto();
		automobile.BuildAuto(file);
		UpdateAuto automobile1 = new BuildAuto();
		
		
		
		//automobile.printAuto(modelname);
		
		//System.out.printf("\n=====================================\n");
		//System.out.printf("\nUpdating the prices and names of some options...\n");
		//System.out.printf("\n=====================================\n");
		
		automobile1.updateOptionSetName(modelname, "Color", "Color Options");
		automobile1.updateOptionSetName(modelname, "Brakes", "Brake Options"); //name does not exist, the program just ignores it
		automobile1.updateOptionSetName(modelname, "Power Moonroof", "Power Moonroof Options");
		automobile1.updateOptionPrice(modelname, "Color Options", "Gold Clearcoat Metallic", 300);
		automobile1.updateOptionPrice(modelname, "Color Options", "Infra-Red Clearcoat", 200);
		automobile1.updateOptionPrice(modelname, "Color Options", "Twilight Blue Clearcoat Metallic", 150);
	
		automobile.printAuto(modelname);
		
		System.out.printf("\n=====================================\n");
		System.out.printf("\n           Customization\n");
		System.out.printf("\n=====================================\n");
		CustomizeAuto automobile2 = new BuildAuto();
		System.out.printf("\n Setting the option choices. . . \n");

		automobile2.setOptionChoice(modelname,"Color Options", "Gold Clearcoat Metallic");
		System.out.printf("\n Price for color option choice: "+ automobile2.getOptionChoicePrice(modelname,"Color Options") );
		automobile2.setOptionChoice(modelname,"Transmission", "automatic");
		System.out.printf("\n Price for transmission choice: "+ automobile2.getOptionChoicePrice(modelname,"Transmission") );
		automobile2.setOptionChoice(modelname,"Brakes/Traction Control", "ABS with Advance Trac");
		System.out.printf("\n Price for brakes choice: "+ automobile2.getOptionChoicePrice(modelname,"Brakes/Traction Control") );
		automobile2.setOptionChoice(modelname,"Side Impact Air Bags", "selected");
		System.out.printf("\n Price for Air Bag choice: "+ automobile2.getOptionChoicePrice(modelname,"Side Impact Air Bags") );
		automobile2.setOptionChoice(modelname,"Power Moonroof Options", "selected");//power moonroof option was changed to power moonroof options
		System.out.printf("\n Price for Power Moonroof choice: "+ automobile2.getOptionChoicePrice(modelname,"Power Moonroof Options") );
		
		automobile2.getTotalPrice(modelname);
		
		
		System.out.printf("\n ");
		
		
		Fleetable automobile3 = new BuildAuto();
		automobile3.find(modelname);
		automobile3.deleteAuto(modelname);
		automobile3.updateFleetName(modelname, null);
		;
		
	}

}
