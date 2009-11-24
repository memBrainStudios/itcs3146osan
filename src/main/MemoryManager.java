package main;
/**
 * 
 * @author Mike Iannacone
 * @version Super Secret Alpha 1.0
 */
public class MemoryManager 
{

	public MemoryManager() 
	{	
	}
	
	/**
	 * This method compares the Command object of the job at the line indicated
	 * and checks to see if that Command is currently in cache memory of the 
	 * device passed, in this case Cache memory.
	 * 
	 * @param jobNumber
	 * @param lineNumber
	 * @param device
	 * @return boolean
	 */
	public boolean lineInCache(int jobNumber, int lineNumber, Device device)
	{
		//device.store is the array of Commands to be searched
		//G40SDemo.jobs is the ArrayList of Jobs
		
		for (Command c: device.getStore())
		{
			if (c.equals(G4OSDemo.getJobs().get(jobNumber-1).getLines().get(lineNumber-1)))
			return true;
		}
		
		return false;
	}
	
	/**
	 * Returns true if the specified line is in memory
	 * @param jobNumber
	 * @param lineNumber
	 * @return
	 */
	public boolean lineInMemory(int jobNumber, int lineNumber, Device device)
	{
		//returns true if the current line is in Memory, else return false
		return false;
	}
	
	/**
	 * Loads a line from secondary storage into main memory
	 * @param jobNumber
	 * @param lineNumber
	 */
	public void loadToMemory(int jobNumber, int lineNumber)
	{
		//loads the current Line into memory from secondary storage
	}
	
	/**
	 * Loads a line from main memory into cache if possible
	 * @param jobNumber
	 * @param lineNumber
	 */
	public void loadToCache(int jobNumber, int lineNumber, Device device)
	{
		//loads the current Line into memory from secondary storage
		
	}

	/**
	 * Gets the specified line from cache
	 * @param jobNumber
	 * @param lineNumber
	 */
	public Command getLine(int jobNumber, int lineNumber, Device device)
	{
		//returns the cache memory address of the specified line, and handles memory swapping
		return null;
	}
	
	
}