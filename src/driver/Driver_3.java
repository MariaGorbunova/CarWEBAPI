package driver;

import adapter.*;


public class Driver_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("\t\t============= ASSIGNMENT 4 =============\n");
		String file = ("FordWagonZTW.txt");
		//LinkedHashMapTemplate <ProxyAutomobile> a1 = new LinkedHashMapTemplate <ProxyAutomobile> ();
		//a1.create(file);
		String modelname = "Ford Wagon ZTW 1996";	// Automobile name
		CreateAuto automobile = new  BuildAuto();
		automobile.BuildAuto(file);
		UpdateAuto a = new BuildAuto();
		//automobile.printAuto(modelname);
		 /*
		  CustomizeAuto automobile2 = new BuildAuto();
		
		System.out.printf("\n Setting the option choices. . . \n");

		automobile2.setOptionChoice(modelname,"Color", "Gold Clearcoat Metallic");
		System.out.printf("\n Price for color option choice: "+ automobile2.getOptionChoicePrice(modelname,"Color") );
		automobile2.setOptionChoice(modelname,"Transmission", "automatic");
		System.out.printf("\n Price for transmission choice: "+ automobile2.getOptionChoicePrice(modelname,"Transmission") );
		automobile2.setOptionChoice(modelname,"Brakes/Traction Control", "ABS with Advance Trac");
		System.out.printf("\n Price for brakes choice: "+ automobile2.getOptionChoicePrice(modelname,"Brakes/Traction Control") );
		automobile2.setOptionChoice(modelname,"Side Impact Air Bags", "selected");
		System.out.printf("\n Price for Air Bag choice: "+ automobile2.getOptionChoicePrice(modelname,"Side Impact Air Bags") );
		automobile2.setOptionChoice(modelname,"Power Moonroof", "selected");//power moonroof option was changed to power moonroof options
		System.out.printf("\n Price for Power Moonroof choice: "+ automobile2.getOptionChoicePrice(modelname,"Power Moonroof") );
		
		//automobile2.getTotalPrice(modelname);
		*/
		// lab3
		//Fleetable automobile3 = new BuildAuto();
		//automobile3.find(modelname);
		//automobile3.updateFleetName(modelname, null);
		
		
		// LAB 4
		System.out.printf("\t\tStarting threads to change OptionSetName \n");

		//lab4
		EditThread automobile4 = new BuildAuto();
		String [] auto;
		///*
		// TEST 1: two synchronized methods
		System.out.printf("\n\n Test 1 - both threads call synchronized method \n");
		//synchronized
		auto = new String[] {modelname, "Color", "Color 1-1"};
		//changing the name of the optionSet
		automobile4.editAuto(1,1,auto);//synchronized1
		
		auto = new String[] {modelname, "Color", "Color 1-2"};
		 //synch
		automobile4.editAuto(2,1,auto);//synchronized2
		
		
		automobile.printAuto(modelname);
		a.updateOptionSetName(modelname, "Color 1-1", "Color");
		a.updateOptionSetName(modelname, "Color 1-2", "Color");
		//*/
		
		//automobile.printAuto(modelname);
		
		
		
		/*
		System.out.printf("\n\n Test 2 - both threads call unsynchronized method(with sleep)\n");
		// TEST 2: two unsynchronized methods
		auto = new String[] {modelname, "Color", "Color 2-1"};
		//changing the name of the optionSet
		automobile4.editAuto(3,2,auto);//unsynchronized
		//unsynchronized
		auto = new String[] {modelname, "Color", "Color 2-2"};
		automobile4.editAuto(4,4,auto);//unsynch with sleep
		
		
		
		automobile.printAuto(modelname);
		a.updateOptionSetName(modelname, "Color 2-1", "Color");
		a.updateOptionSetName(modelname, "Color 2-2", "Color");
		
		*/
		
		/*
		System.out.printf("\n\n Test 3 - one thread calls synchronized method; the other - unsynch. \n");
		// TEST 3: synchronized & unsynch methods
		
		auto = new String[] {modelname, "Color", "Colour 3-1"};
		//changing the name of the optionSet
		automobile4.editAuto(5,1,auto);//synchronized
		//unsynchronized
		auto = new String[] {modelname, "Color", "Colors 3-2"};
		automobile4.editAuto(6,2,auto);//unsynch
		automobile.printAuto(modelname);
		
		
		automobile.printAuto(modelname);
		*/
	}
}
