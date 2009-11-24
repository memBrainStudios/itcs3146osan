package main;
/*
 *      device.java
 *      
 * 	
 */


public class Device {
	String name;
	int responseTime;	//in cpu cycles

	public Device()
	{	
	}
	
	public Device(String inName, int inResponse)
	{
		name = inName;
		responseTime = inResponse;
	}
}
