/*
 *      computer.java
 *      
 *      This file will create the virtual computer that the programs will be run on
 */

public class computer {
	command[] memory;
	command[] cache;
	int memAccessTime;
	int storageAccessTime;

	public computer(int memSize, int cacheSize)
	{		
		init(memSize, cacheSize, 5, 30);
	}
	
	public computer(int memSize, int cacheSize, int inMemoryAccessTime, int inStorageAccessTime)
	{		
		init(memSize, cacheSize, inMemoryAccessTime, inStorageAccessTime);
	}
	
	private void init(int memSize, int cacheSize,  int inMemAccess, int inStoAccess)
	{		
		memory = new command[memSize];
		cache = new command[cacheSize];
		memAccessTime = inMemAccess;
		storageAccessTime = inStoAccess;
	}
}