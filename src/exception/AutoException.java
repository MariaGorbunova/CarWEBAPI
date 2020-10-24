/**
 * @author Maria Gorbunova
 * 35B 
 * Assignment Number 3 
 * Due Date Oct 30
 * Date Submitted Oct 30 
 */
package exception;

import java.text.*;// writing the log
import java.util.Date;// writing the log
import java.io.*;

public class AutoException  extends Exception implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int errorNo;
	private String errorMsg;	
	private FixHelper f1;
	
	
	// Constructors
	
	public AutoException(String message) {
		super(message);
	}
	
	public AutoException(int errorNo, String errorMsg) {
		this.errorNo = errorNo;
		this.errorMsg = errorMsg;
		writeErrLog();
	}
	
	
	
	public String fix(int errorNo, String line) {
		f1 = new FixHelper();

		String temp="";
		switch (errorNo) {
		case 1:
			return f1.fix1(line);
		case 2:
			return f1.fix2(line);//return f1.fix2(line);
		case 3:
			//System.out.print(" =========> " + line + "\n");
			return f1.fix3(line);
		case 4:
			return f1.fix4(line);
		case 5:
			return f1.fix5(line);
		case 6:
			System.out.print( "Exception catched! Not an int! ");
		}
		return temp;
	}
	
	/*
	 * AutoException   should   have   following   features:
1. Ability   to   track   error   no   and   error   message.
2. Contain   an   enumeration   of   all   possible   error   numbers   and  
 messages,   which   can   be   used,   when AutoException   is   instantiated.
3. Ability   to   log   AutoException   with   timestamps   into   a   log   file  
 (you   do   not   need   to   implement   any   complex logging   mechanism).
4. Write   helper   classes   to   delegate   fixes   for   each   method.   
For   example,   if   exception   number   1   to   100   is assigned   to   model  
 package,   you   might   author   a   class   called   Fix1to100   as   a   helper  
  class   for AutoException,   which   contains   fix   methods   for   exceptions   
  raised   in   the   model   package.
5. AutoException   should   have   following   implementation   of   fix   method, 
  which   can   be   used   for   fixing   any exception   in   entire   application.
	 * */
	 

	 /*
	  * public   void   fix(int   errno) {

		Fix1to100   f1   =   new   Fix1to100(); switch(errno)
		{
				case   1:   f1.fix1(errno);break; ...
			}
		}
	  */

	
	
	
	
	
	
	public void writeErrLog() {
		try {
			DateFormat d1 = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
			Date date = new Date();
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("errLog.txt", true)));
			writer.printf("[" + d1.format(date) + "] " + "Error #: " + errorNo + "; " + "Error Message: " + errorMsg + ";\n");
			writer.close();
		}
		catch (IOException e) {
			System.out.printf("IO Error, try restarting the process");
			System.exit(1);
		}
		finally {
			//
		}
	}
	
}
