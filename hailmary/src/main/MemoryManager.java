package main;

/*
 *      memoryManager.java
 *      
 *      
 */


public class MemoryManager {

	public MemoryManager(Computer inComp)
	{	
	}
	
	/*
	 * returns true if the specified line is in cache
	 */
	public boolean lineInCache(int jobNumber, int lineNumber)
	{
		//returns true if the current line is in cache, else return false
		return false;
	}
	
	/*
	 * returns true if the specified line is in memory
	 */
	public boolean lineInMemory(int jobNumber, int lineNumber)
	{
		//returns true if the current line is in Memory, else return false
		return false;
	}
	
	/*
	 * loads a line from secondary storage into main memory
	 */
	public void loadToMemory(int jobNumber, int lineNumber)
	{
		//loads the current Line into memory from secondary storage
	}
	
	/*
	 * loads a line from main memory into cache if possible
	 */
	public void loadToCache(int jobNumber, int lineNumber)
	{
		//loads the current Line into memory from secondary storage
	}

	/*
	 * gets the specified line from cache
	 */
	public Command getLine(int jobNumber, int lineNumber)
	{
		//returns the cache memory address of the specified line, and handles memory swaping*/
		return new Command("");
	}
}
