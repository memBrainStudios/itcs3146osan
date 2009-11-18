package main;


/*
 *      G4Final.java
 *      
 * 		
 */
import java.io.*;


public class G4Final {
	public static job[] jList;
	public static device[] dList;
	public static computer setup;
	
	public static processManager pm;
	public static memoryManager mm;

	public static void main(String args[])
	{
		fileLoader load = new fileLoader();
		try
		{
			String dir = new java.io.File(".").getCanonicalPath();;
			jList = load.getJobs(dir+"/jobs");
			dList = load.getDeviceList(dir+"/devices");
		}
		catch (IOException e) {
			System.err.println("Caught IOException: " +  e.getMessage());
		}
	}
	
	/*
	 * runs the current computer setup given the list of jobs
	 */
	public static void runSetup()
	{
		//will run the current setup and provide an analysis
		int cpuCycle=0;
		int currentJob=-1;
		do
		{
			//determine whether or not to continue processing the current job;
			if(pm.continueCurrentJob(cpuCycle))
			{
				//we will continue to process a line of the current job
				jList[currentJob].proccessLine();
			}
			else
			{
				currentJob=pm.loadJob();
			}
			
			//check with the memory manager to see if the next line of processable code from the current job is in the cache
			if(mm.lineInCache(currentJob, jList[currentJob].currentLine))
			{
				//if so process the current line
			}
			//else start the process of getting it there
			else if(mm.lineInMemory(currentJob, jList[currentJob].currentLine))
			{
				mm.loadToCache(currentJob, jList[currentJob].currentLine);
			}
			else
			{
				mm.loadToMemory(currentJob, jList[currentJob].currentLine);
			}
			
			//update cpuCycle
			cpuCycle++;
		}while(!jobsComplete());
	}
	
	/*
	 * checks to see if all jobs in the list are complete
	 */
	public static boolean jobsComplete()
	{
		//determine if all completeable jobs are complete, if so return true
		return false;
	}
}
