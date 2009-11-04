/**
 * 
 * @author Dustin
 *
 */

public class computer {
	command[] memory;	//main memory
	command[] cache;	//cache memory
	device[] deviceList;	//device memory
	job[] jobList;
	//also need to add in a MemoryManager
	//also need to add in a ProcessManager
	//also need to add in a DeviceManager
	
	public computer(int memorySize, int cacheSize)
	{
		memory = new command[memorySize];
		cache = new command[cacheSize];
	}
	
	/**
	 * Run through one cpu cycle of the computer
	 *
	 */
	public void update()
	{
		//write update logic
	}
}
