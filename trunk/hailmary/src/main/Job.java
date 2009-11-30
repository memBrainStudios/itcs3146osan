package main;

/*
 *      job.java
 *      
 *      
 */


public class Job {
	private Command[] lines;
	public int currentLine;

	public Job(int numLines)
	{		
		lines = new Command[numLines];
		currentLine = 0;
	}
	
	/**
	 * Access method to allow addition of new command lines to Command[] lines.
	 *
	 * Added method to allow access to Command[] lines so that a line can be added
	 * to lines.  Otherwise, no lines will ever be added to lines and the array
	 * will always be empty.
	 * 
	 * @author Mark McKinney
	 */
	public void addCommand(int index, Command command) {
		lines[index] = command;
	}
	
	/*
	 * returns the command at a specific line of code
	 */
	public Command getLine(int lineNum)
	{
		if(lineNum<lines.length)
		{
			return lines[lineNum];
		}
		else
		{
			System.err.println("Out of Bounds Exception in job.java: getLine(int lineNum)\n\t(lineNum = "+lineNum+") >= (lines.length = "+lines.length+")");
			return null;
		}
	}
	
	/*
	 * used to load in the next line of code
	 */
	public void loadLine(int lineNum, Command inCommand)
	{
		if(lineNum<lines.length)
		{
			lines[lineNum] = inCommand;
		}
		else
		{
			System.err.println("Out of Bounds Exception in job.java: loadLine(int lineNum, command inCommand)\n\t(lineNum = "+lineNum+") >= (lines.length = "+lines.length+")");
		}
	}
	
	/*
	 * returns whether or not the job is complete
	 */
	public boolean isComplete()
	{
		//System.out.println("got here");
		if(currentLine >= lines.length)
			return true;
		return false;
	}
	
	/*
	 * returns the current lines command
	 */
	public Command getCurrentLine()
	{
		return lines[currentLine];
	}
	
	/*
	 * will process the next line in the job
	 */
	public void proccessLine()
	{
		if(lines[currentLine].getName().equals("process-command"))
		{
			currentLine++;
		}
		else if(lines[currentLine].getName().equals("loop-for"))
		{
			if (lines[currentLine].iArg[1]-- >= 0)
			{
				currentLine = lines[currentLine].iArg[0];
			}
			else
			{
				currentLine++;
			}
		}
		else if(lines[currentLine].getName().equals("device-call"))
		{
			//finish this logic
			//fix this
			//fix this
			//fix this
			//fix this
			//fix this
			//fix this
			currentLine++;
		}
	}
}
