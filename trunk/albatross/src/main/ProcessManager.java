package main;

public class ProcessManager {
//	List list = new LinkedList();
	int pointer = 0;
	int timeQuantum = 10;
	public ProcessManager()
	{
		
		
	}
	public void newJob(Job activeJob)
	{
//		list.add(activeJob);
//		list.size = list.size + 1;
	}

	/**
	 * Returns true if the CPU is to continue processing the current job
	 * @param cpuCycle
	 * @return
	 */
	public boolean continueCurrentJob(int cpuCycle)
	{
//		if 
		//determine whether or not to continue processing the current job
		return false;
	}
	
	/**
	 * Tells the CPU which job to process next
	 * @return
	 */
	public int loadJob()
	{
		//returns the next job that will be processed by the cpu
		return -1;
	}
}