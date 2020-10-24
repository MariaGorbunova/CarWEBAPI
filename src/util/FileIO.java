/**
 * @author Maria Gorbunova
 * 35B 
 * Assignment Number 3 
 * Due Date Oct 30
 * Date Submitted Oct 30
 */
package util;

import exception.*;
import model.*;
import java.io.*; // when working with file systems (read from/write to)
import java.util.StringTokenizer;
import java.io.Serializable;
import java.util.Properties;

public class FileIO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fname = null; // filename
	private boolean DEBUG = false; // print info to see what's going on;
	private String nameSer = null;

	// FileIO() {}
	public FileIO(String fname) {
		this.fname = fname; // set the filename
		if (DEBUG)
			System.out.printf("\nFileIO Constructor ... \n");
	}

	// Reads the file and builds optionset array.
	public Automobile readFile(Automobile auto) {
		if (DEBUG)
			System.out.printf("\nreadFile method ... \n");

		try {
			FileReader file = new FileReader(fname);
			BufferedReader buff = new BufferedReader(file);
			boolean eof = false;
			boolean firstLine = true;
			int idxOptionSet = 0; // track # of optionsets

			while (!eof) {
				String line = buff.readLine();
				if (DEBUG) {
					System.out.printf("\nPrint read line from the file: \n");
					System.out.printf(line + "\n");
				}
				if (line == null)
					eof = true;
				else {
					if (firstLine) {
						auto = modelTokenizer(auto, line);
						if (DEBUG) {
							// auto.printAutomotive();
							System.out.print("\nPrint auto.getName() in automotive: " + auto.getMake() + "\n");
						}
						firstLine = false;
					} else {
						auto = optionTokenizer(auto, line, idxOptionSet);
						// if (DEBUG)
						// auto.printOptionSet(idxOptionSet);
						idxOptionSet++;
					}
				}
			}
			buff.close();
		} catch (IOException e) {
			System.out.printf("Error -- " + e.toString());
		}
		if (DEBUG)
			auto.printOptionSet();
		return auto;
	}

	public Automobile modelTokenizer(Automobile auto, String temp) {
		String[] s1 = temp.split(",");

		String make = "";
		String modelName = "";
		String year = "";
		String baseprice = "";

		if (DEBUG)
			System.out.printf("\n     START \n");

		// try catch block for checking if the
		// name of the automobile is in the file
		// if not, calling fix method for inserting "No name"

		try {
			make = checkName(s1[0]);
			if (DEBUG) {
				System.out.printf("\n make: \n");
				System.out.printf(s1[0] + "\n");
			}
		} catch (AutoException e) {
			make = e.fix(2, s1[0]);
		}

		try {
			if (DEBUG) {
				System.out.printf("\n     before checkName \n");
				System.out.printf(s1[1] + "\n");
			}
			modelName = checkName(s1[1]);
			if (DEBUG)
				System.out.printf("\n   in try " + modelName + " \n");

		} catch (AutoException e) {
			modelName = e.fix(1, s1[1]);
			if (DEBUG)
				System.out.printf("\n   in catch:  " + modelName + " \n");
		}

		year = s1[2];

		if (DEBUG)
			System.out.printf("\n     out of the second catch \n");
		// try catch block for checking if the
		// baseprice of the automobile is in the file
		// if not, calling fix method for inserting hardcoded value
		try {
			baseprice = checkBasePrice(s1[3]);
			if (DEBUG)
				System.out.printf("\n    check baseprice " + baseprice + "\n");
		} catch (AutoException e) {
			baseprice = e.fix(2, s1[3]);
			if (DEBUG)
				System.out.printf("\n    catch baseprice \n");
		}

		if (DEBUG)
			System.out.printf("\n     out of the second catch \n");

		// try catch block for checking if the
		// numberOfOptions of the automobile is in the file
		// if not, calling fix method for inserting hardcoded value

		// if (DEBUG)
		// System.out.printf("\n check num of options " + s1[2] + "\n");

		/*
		 * try { if (s1.length == 4) year = checkYear(s1[2]); else throw new
		 * AutoException(3, "No options"); if (DEBUG)
		 * System.out.printf("\n    check num of options: " + year + "\n"); } catch
		 * (AutoException e) { if (DEBUG)
		 * System.out.printf("\n    catch num of options \n"); year = e.fix(3, "-1"); }
		 */

		auto = new Automobile(make, modelName, year, Float.parseFloat(baseprice));
		if (DEBUG) {
			System.out.print("modelTokenizer calls printAutomotive: \n");
			auto.printAutomotive();
		}
		return auto;
	}

	// Check automobile name
	public String checkName(String line) throws AutoException {
		// if the line is empty,
		// assign default name
		if (line.isEmpty()) {
			throw new AutoException(1, "Missing name");
		}
		return line;
	}

	// Check automobile basprice
	public String checkBasePrice(String line) throws AutoException {
		if (line.isEmpty()) {
			throw new AutoException(2, "No basePrice");
		}
		return line;
	}
	/*
	 * // Check year public String checkYear(String line) throws AutoException { if
	 * (DEBUG) System.out.print("Check year  " + line + "\n"); if (line.isEmpty()) {
	 * throw new AutoException(3, "No year"); } return line; }
	 */

	public Automobile optionTokenizer(Automobile auto, String temp, int idxOptionSet) {
		String optionSetName = null;
		// String numOfOptions = null;
		// String numOfOptions = null; //for new parser
		String optionName = null;
		float optionprice = 0;

		/*
		 * //new parser String[] tokens = temp.split(",");
		 * 
		 * 
		 * try { optionSetName = checkOptionSetName(optionSetName); if (DEBUG)
		 * System.out.printf("\n    check optionSetName " + optionSetName + "\n"); }
		 * catch (AutoException e) { optionSetName = e.fix(4, optionSetName); if (DEBUG)
		 * System.out.printf("\n    catch baseprice \n"); }
		 * 
		 * 
		 * try { numOfOptions = checkNumOfOptsInOptSet(tokens[1]); } catch
		 * (AutoException e) { numOfOptions = e.fix(5, tokens[1]); }
		 * 
		 * 
		 * auto.addOptionSet(optionSetName, Integer.parseInt(numOfOptions),
		 * idxOptionSet);
		 * 
		 * 
		 * for (int idxOpt = 0; idxOpt < Integer.parseInt(numOfOptions); idxOpt++) {
		 * optionName = st.nextToken();
		 * 
		 * optionprice = Float.parseFloat(st.nextToken());
		 * 
		 * auto.addOption(optionName, optionprice, idxOptionSet, idxOpt);
		 * 
		 * }
		 * 
		 */

		// old parser
		StringTokenizer st = new StringTokenizer(temp, ",");
		// st.setReturnEmptyTokens(true);
		while (st.hasMoreTokens()) {
			// save the name of the option:
			optionSetName = st.nextToken();
			try {
				optionSetName = checkOptionSetName(optionSetName);
				if (DEBUG)
					System.out.printf("\n    check optionSetName " + optionSetName + "\n");
			} catch (AutoException e) {
				optionSetName = e.fix(4, optionSetName);
				if (DEBUG)
					System.out.printf("\n    catch optionSet name \n");
			}

			if (DEBUG)
				System.out.print("===========>>>>>>>>>  " + optionSetName + "\n");

			/*
			 * numOfOptions = st.nextToken();
			 * 
			 * try { numOfOptions = checkNumOfOptsInOptSet(numOfOptions); } catch
			 * (AutoException e) { numOfOptions = e.fix(5, numOfOptions); }
			 * 
			 * if (DEBUG) System.out.print("Number of Options: " + numOfOptions + "\n");
			 * 
			 * if (DEBUG) { System.out.print("OptionTokenizer method: \nOptionsetName and" +
			 * " numOfOptions:" + optionSetName + " " + numOfOptions + "\n"); }
			 */
			auto.addOptionSet(optionSetName);
			// start the loop for processing price and options
			/*
			 * for (int idxOpt = 0; idxOpt < Integer.parseInt(numOfOptions); idxOpt++) {
			 * optionName = st.nextToken();
			 * 
			 * optionprice = Float.parseFloat(st.nextToken());
			 * 
			 * auto.addOption(optionName, optionprice, idxOptionSet); if (DEBUG) {
			 * System.out.print("optionName: " + optionName + "    optionPrice:" +
			 * optionprice + "\n");} }
			 */

			while (st.hasMoreTokens()) {
				optionName = st.nextToken();

				optionprice = Float.parseFloat(st.nextToken());

				auto.addOption(optionName, optionprice, idxOptionSet);
			}
		}
		return auto;
	}

	public String checkOptionSetName(String line) throws AutoException {
		boolean isFormatted = true;// if the line is empty,
		// assign default name

		if (line.isEmpty()) {
			throw new AutoException(4, "No OptionSet name");
		}

		for (int i = 0; i < line.length(); i++) {
			if (Character.isLetter(line.charAt(i)) || Character.isDigit(line.charAt(i)) || line.charAt(i) == '-'
					|| line.charAt(i) == ' ' || line.charAt(i) == '/') {
				isFormatted = true;
			} else {
				isFormatted = false;
				break;
			}
		}

		if (isFormatted == true) {
			return line;
		} else {
			throw new AutoException(4, "Wrong OptionSet name format");
		}
	}

	public String checkNumOfOptsInOptSet(String line) throws AutoException {
		// if the line is empty,
		// assign default name
		if (DEBUG)
			System.out.print(" ======> checkNumOfOptsInOptSet: " + line + "\n");

		if (line.isEmpty()) {
			throw new AutoException(5, "No number of options for OptionSet");
		}
		if (!isNumeric(line)) {
			System.out.print(" checkNumOfOptsInOptSet: " + line + "\n");

			throw new AutoException(5, "Data for the number of options is not correct");
		}
		return line;
	}

	public boolean isNumeric(String str) throws AutoException {
		int i = 0;
		// System.out.print(" 1isNumeric: " + str + "\n");
		try {
			// System.out.print(" 2isNumeric: " + str + "\n");
			i = Integer.parseInt(str);
			// System.out.print(" 2.5isNumeric: " + str + "\n");
		} catch (NumberFormatException nfe) {
			// System.out.print(" 3isNumeric: " + str + "\n");
			throw new AutoException(6, "Invalid value");
		}
		return true;
	}

	public void serialize(Automobile auto) {

		nameSer = new String(auto.getMake() + ".ser");
		ObjectOutputStream out;

		try {

			if (DEBUG) {
				System.out.printf("\nSerializing file... \n");
				System.out.printf(nameSer + "\n");
			}

			out = new ObjectOutputStream(new FileOutputStream(nameSer));
			out.writeObject(auto);
			out.close();

		} catch (IOException e) {
			System.out.printf(" Error -- " + e.toString()); //
			e.printStackTrace();
		}
	}

	public Automobile deserialize() {
		if (DEBUG)
			System.out.printf("\nDeserializing\n");

		ObjectInputStream in;
		try {

			if (DEBUG) {
				System.out.printf("Deserializing file: ");
				System.out.printf(nameSer + "\n");
			}

			in = new ObjectInputStream(new FileInputStream(nameSer));
			Automobile b1 = (Automobile) in.readObject(); // return an Object
			b1.printAutomotive();
			b1.printOptionSet();
			in.close();
			return b1;
		} catch (Exception e) {
			System.out.printf(" Error -- " + e.toString());
			e.printStackTrace();
		}
		return null;
	}

	public Automobile readProp(Automobile a1) {

		try {
			FileInputStream in = new FileInputStream(fname);
			Properties props = new Properties(); //
			props.load(in); // This loads the entire file in memory.
			String CarMake = props.getProperty("CarMake"); // this is how you read a property. It is like gettting a
															// value from HashTable.
			if (!CarMake.equals(null)) {
				String CarModel = props.getProperty("CarModel");
				String CarYear = props.getProperty("CarYear");
				String CarPrice = props.getProperty("CarPrice");
				String Option1 = props.getProperty("Option1");
				String OptionValue1a = props.getProperty("OptionValue1a");
				String OptionValue1b = props.getProperty("OptionValue1b");

				String Option2 = props.getProperty("Option2");
				String OptionValue2a = props.getProperty("OptionValue2a");
				String OptionValue2b = props.getProperty("OptionValue2b");

				if (DEBUG)
					System.out.println(CarPrice);

				a1 = new Automobile(CarMake, CarModel, CarYear, Float.parseFloat(CarPrice));
				a1.addOptionSet(Option1);
				String[] options = { OptionValue1a, OptionValue1b };
				float[] price = { 0, 0 };
				a1.addOptions(Option1, options, price);
				a1.addOptionSet(Option2);
				String[] options2 = { OptionValue2a, OptionValue2b };
				a1.addOptions(Option2, options2, price);

				return a1;
			}
		} catch (IOException e) {
			System.out.println("Exception: " + e);
		}
		return null;
	}

}
