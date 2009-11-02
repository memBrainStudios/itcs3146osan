/*
 *      G4Final.java
 *      
 * 		
 */


public class G4Final {
	public static job[] jList;
	public static computer setup;
	
	public static processManager pm;
	public static memoryManager mm;

	public static void main (String args[])
	{		
		jList = new job[5];
	}
	
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
			}
			else
			{
				currentJob=pm.loadJob();
			}
			
			//check with the memory manager to see if the next line of processable code from the current job is in the cache
			//if so process the current line
			//else start the process of getting it there
			
			//update cpuCycle
			cpuCycle++;
		}while(!jobsComplete());
	}
	
	public static boolean jobsComplete()
	{
		//determine if all completeable jobs are complete, if so return true
		return false;
	}
}
