package main;

public class MemoryManager {

	public MemoryManager() {	
	}
	
	/**
	 * Returns true if the specified line is in cache
	 * @param jobNumber
	 * @param lineNumber
	 * @return
	 */
	public boolean lineInCache(int jobNumber, int lineNumber)
	{
		//returns true if the current line is in cache, else return false
		return false;
	}
	
	/**
	 * Returns true if the specified line is in memory
	 * @param jobNumber
	 * @param lineNumber
	 * @return
	 */
	public boolean lineInMemory(int jobNumber, int lineNumber)
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
	public void loadToCache(int jobNumber, int lineNumber)
	{
		//loads the current Line into memory from secondary storage
	}

	/**
	 * Gets the specified line from cache
	 * @param jobNumber
	 * @param lineNumber
	 */
	public Command getLine(int jobNumber, int lineNumber)
	{
		//returns the cache memory address of the specified line, and handles memory swapping
		return null;
	}
	
	
}