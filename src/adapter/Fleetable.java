package adapter;

import model.Automobile;

public interface Fleetable {
	public void deleteAuto(String modelname);
	public void deleteAll(String modelname);
	public void find(String modelname) ;
	public void updateFleetName(String modelname, Automobile newAuto) ;

}
