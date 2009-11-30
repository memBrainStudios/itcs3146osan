package main;
import java.util.ArrayList;
import java.util.Queue;


public class DeviceManager {
	   
    ArrayList<Integer> updateCount; //ArrayList of integers to be decremented per update() call
	ArrayList<Queue<Integer>> deviceQueues; //ArrayList of queues that holds the job #'s waiting to be updated
	Queue<Integer> finishedDevice; //Queue holding the job numbers that are finished with their device
	ArrayList<Integer> deviceList; //ArrayList holding the response times with the index as the device #

   
    public void deviceManager(ArrayList<Integer> inList)
    {
        deviceList = inList;
        
        for(int i = 0; i < deviceList.size(); i++)
        {
        	deviceQueues.add(null); //DOES THIS WORK FOR CREATING THE QUEUES?????
        	updateCount.set(i, -1);
        }
    }

   
    /*
     * schedule a call to device when device is available
     */
    public void callToDevice(int jobNumber, int deviceNumber)
    {
    	deviceQueues.get(deviceNumber).add(jobNumber); //Adds job number into Queue at index of deviceNumber in the ArrayList
    	return;
    }
    
    /*
     * update device connections
     * 
     * updateCount is initially set to -1 at all indexes implying that no decrementing is required.
     * updateCount at index i will be set to its device's responseTime retrieved from the deviceList
     * when the queue has a job requesting a device with the corresponding index. It will decrement with
     * each update call until the updateCount at that index reaches 0 causing the corresponding job in
     * that queue to be removed and sent to the finishedDevice queue and the updateCount at that
     * index will be set to -1 again.
     */
    public void update()
    {
        for(int i = 0; i < deviceQueues.size(); i++)
        {
        	if(!(deviceQueues.get(i).isEmpty()) && (updateCount.get(i) == -1))
        	{
        		updateCount.set(i, deviceList.get(i));
        	}
        	if(!(deviceQueues.get(i).isEmpty()) && (updateCount.get(i) > 0))
        	{
        		updateCount.set(i, (updateCount.get(i)-1));
        	}
        	if(!(deviceQueues.get(i).isEmpty()) && (updateCount.get(i) == 0))
        	{
        		finishedDevice.add(deviceQueues.get(i).poll());
        		updateCount.set(i, -1);
       		}
        }
    }

    /*
     * returns finished job numbers
     */
	public int jobsDeviceCallFinished()
	{
		if(finishedDevice.isEmpty())
		{
			return -1;
		}
		else
		{
			return finishedDevice.poll();
		}
	}
}
