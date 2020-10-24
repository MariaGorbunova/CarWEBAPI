package model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Iterator;

public class Fleet {

	private static LinkedHashMap<String, Automobile> lhm = new LinkedHashMap<String, Automobile>();
	
	//public Fleet(Automobile a1) {};

	public void put(String makenamemodel, Automobile a1) {
		lhm.put(makenamemodel, a1);
	}

	public Automobile find(String makenamemodel) {
		// Automobile temp=null;
		for (Iterator<Map.Entry<String, Automobile>> it = lhm.entrySet().iterator(); it.hasNext();) {
			Map.Entry<String, Automobile> entry = it.next();
			if (entry.getKey().equals(makenamemodel)) {
				//System.out.print(makenamemodel + "----------" + entry.getKey() + "\n");
				return entry.getValue();
			}
		}
		System.out.print( "\nIn find: The object was not found! \n");
		return null;
	}

	public void updateAuto(String makenamemodel,  Automobile newA1) {
		if (find(makenamemodel)!=null)
			lhm.put(makenamemodel, newA1); // put replaces the value if the key is already in the LinkedHashMap
		else 
			System.out.print("\nIn update: The object was not found!");
	}
	
	

	public void printAuto(String makenamemodel) {
		// find(makenamemodel).printAutomotive();
		lhm.get(makenamemodel).printAutomotive();
	}

	public void printAll() {
		Map.Entry<String, Automobile> entry = null;
		for (Iterator<Map.Entry<String, Automobile>> it = lhm.entrySet().iterator(); it.hasNext();) {
			entry = it.next();
			entry.getValue().printAutomotive();
		}
	}

	public void delete(String makenamemodel, Automobile a1) {
		// find(makenamemodel);
		System.out.print(makenamemodel);
		if (find(makenamemodel)!=null) {
			lhm.remove(makenamemodel, find(makenamemodel));
			System.out.print(" in delete:");}
		else 
			System.out.print("\nIn delete: The object was not found!");
	}
	

	public void deleteMap() {
		lhm.clear();
	}

}
