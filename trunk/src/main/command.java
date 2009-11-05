package main;
/*
 *      command.java
 *      
 *      This will be a command that can be called from a line of a program
 */


public class command {
	String name;
	int iArg;
	String sArg;

	public command(String inCommand)
	{		
		name = inCommand;
	}

	public command(String inCommand, int inIntArg)
	{		
		name = inCommand;
		iArg = inIntArg;
	}

	public command(String inCommand, String inStringArg)
	{		
		name = inCommand;
		sArg = inStringArg;
	}
}
