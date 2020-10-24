/**
 * @author Maria Gorbunova
 * 35B 
 * Assignment Number 3 
 * Due Date Oct 30
 * Date Submitted Oct 30 
 */
package adapter;

public interface CreateAuto {
 // buildAuto
	//Given   a   text   file   name   a   method   called   BuildAuto  
	//can   be   written   to   build   an   instance   of 
	//Automobile.   This   method   does   not   have   to   return  
	//the   Auto   instance.
	public   void   BuildAuto(String   filename);
	
	
	//printAuto
	//This   function   searches   and   prints   the   
	//properties   of   a   given   Automodel.
	public   void   printAuto(String      Modelname);

}
