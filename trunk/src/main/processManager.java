package main;
/*
 *      processManager.java
 *      
 * 	
 */


public class ProcessManager {

	public ProcessManager()
	{
	}
	
	/*
	 * returns true if the CPU is to continue processing the current job
	 */
	public boolean continueCurrentJob(int cpuCycle)
	{
		//determine whether or not to continue processing the current job
		return false;
	}
	
	/*
	 * tells the CPU which job to process next
	 */
	public int loadJob()
	{
		//returns the next job that will be processed by the cpu
		return -1;
	}
}
