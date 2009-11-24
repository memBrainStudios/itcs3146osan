package main;
/*
 *      processManager.java
 *      
 * 	
 */


public class processManager {
	LinkedList() list = new LinkedList();
	int pointer = 0;
	int lastPoint = 0;
	int timeQuantum = 10;
	int endCycle;
	
	public processManager()
	{
		
		
	}
	public void newJob(int activeJob){
		list.addLast(activeJob);
		list.size = list.size + 1;
		lastPoint = list.size - 1;
	}
	public void deleteJob(int deleteJob){
		int jobCounter = 0;
		if jobCounter < list.size
			if list.get(jobCounter) =! deleteJob
				jobCounter= jobCounter + 1;
			else
				if jobCounter > pointer
					
	}
	/*
	 * returns true if the CPU is to continue processing the current job
	 */
	public boolean continueCurrentJob(int cpuCycle)
	{
		if cpuCycle = endCycle{
		//determine whether or not to continue processing the current job
			if pointer < list.size{
				pointer = pointer + 1;
				return false;
			}
			else{
				pointer = 0;
			return false;
			}
		
		else 
			return true;
		}
	}
	
	/*
	 * tells the CPU which job to process next
	 */
	public int loadJob()
	{
		if list == null
			return -1;
		else{
		return list.get(pointer);
		endCycle = cpuCycle + timeQuantum;
		
		}
		//returns the next job that will be processed by the cpu
	}
}
