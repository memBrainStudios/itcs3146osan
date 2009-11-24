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
	 * will proccess the next line in the job
	 */
	public void proccessLine()
	{
		if(lines[currentLine].getName().equals("proccess command"))
		{
			currentLine++;
		}
		else if(lines[currentLine].getName().equals("loop for"))
		{
			if (lines[currentLine].iArg[1]-- < 0)
			{
				currentLine = lines[currentLine].iArg[0];
			}
			else
			{
				currentLine++;
			}
		}
		else if(lines[currentLine].getName().equals("device call"))
		{
			//finish this logic
		}
	}
}
