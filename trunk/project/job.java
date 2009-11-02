/*
 *      job.java
 *      
 *      
 */


public class job {
	command[] lines;

	public job(int numLines)
	{		
		lines = new command[numLines];
	}
	
	public command getLine(int lineNum)
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
	
	public void loadLine(int lineNum, command inCommand)
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
}
