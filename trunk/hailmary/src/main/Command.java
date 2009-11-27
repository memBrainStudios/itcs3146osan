package main;

/*
 *      command.java
 *      
 *      This will be a command that can be called from a line of a program
 */
public class Command {
	private String name;	//will be one of the following: "procces command", "device call", "loop for"
	public int iArg[] = new int[2];
	public String sArg;

	public Command(String inCommand)
	{		
		name = inCommand;
	}

	public Command(String inCommand, int inIntArg0, int inIntArg1)
	{		
		name = inCommand;
		iArg[0] = inIntArg0;	//this is the line number to jump to for the for loop
		iArg[1] = inIntArg1;	//this is the number of times to loop
	}

	public Command(String inCommand, String inStringArg)
	{		
		name = inCommand;
		sArg = inStringArg;
	}
	
	/*
	 * returns the name
	 */
	public String getName()
	{
		return name;
	}
}
