package main;
/*
 *      device.java
 *      
 * 	
 */


public class device {
	String name;
	int responseTime;	//in cpu cycles

	public device()
	{	
	}
	
	public device(String inName, int inResponse)
	{
		name = inName;
		responseTime = inResponse;
	}
}
