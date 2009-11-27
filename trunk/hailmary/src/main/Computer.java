package main;

/*
 *      computer.java
 *      
 *      This file will create the virtual computer that the programs will be run on
 */

public class Computer {
	public Command[] memory;
	public Command[] cache;
	Device[] devices;
	int memAccessTime;
	int storageAccessTime;

	public Computer(int memSize, int cacheSize)
	{		
		init(memSize, cacheSize, 5, 30);
	}
	
	public Computer(int memSize, int cacheSize, int inMemoryAccessTime, int inStorageAccessTime)
	{		
		init(memSize, cacheSize, inMemoryAccessTime, inStorageAccessTime);
	}
	
	/*
	 * initialization
	 */
	private void init(int memSize, int cacheSize,  int inMemAccess, int inStoAccess)
	{
		this.memory = new Command[memSize];
		this.cache = new Command[cacheSize];
		memAccessTime = inMemAccess;
		storageAccessTime = inStoAccess;
	}
	
	public void initDevices(int size) {
		devices = new Device[size];
	}
	
	public void addDevice(int index, Device device) {
		devices[index] = device;
	}
}
