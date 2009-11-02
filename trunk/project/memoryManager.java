/*
 *      memoryManager.java
 *      
 *      
 */


public class memoryManager {

	public memoryManager()
	{	
	}
	
	public boolean lineInCache(int jobNumber, int lineNumber)
	{
		//returns true if the current line is in cache, else return false
		return false;
	}
	
	public boolean lineInMemory(int jobNumber, int lineNumber)
	{
		//returns true if the current line is in Memory, else return false
		return false;
	}
	
	public void loadToMemory(int jobNumber, int lineNumber)
	{
		//loads the current Line into memory from secondary storage
	}
	
	public void loadToCache(int jobNumber, int lineNumber)
	{
		//loads the current Line into memory from secondary storage
	}
	
	public command getLine(int jobNumber, int lineNumber)
	{
		//returns the cache memory address of the specified line, and handles memory swaping*/
		return new command("");
	}
}
