package main;

import java.util.*;

/**
 * The G4OSDemo is a Singleton Class run via a thread from the G4OSDemoDriver.
 * It maintains the principle components that derive and maintain the system.
 * @author Mark A McKinney
 * @author Dustin Culler
 * @version 1.0 Alpha 20091120
 */
public class G4OSDemo {
	// Fields
	private static G4OSDemo instance = null; // Only one instance will ever exist.
	
	private static ArrayList<Job> jobs;
	private static ArrayList<Device> computer;

	private static ProcessManager processManager;
	private static MemoryManager memoryManager;
	private static DeviceManager deviceManager;

	private static int cpuCycle;
	private static int currentJob;

	// Properties
	/**
	 * 
	 * @param jobs
	 */
	public static void setJobs(ArrayList<Job> jobs) {
		G4OSDemo.jobs = jobs;
	}
	/**
	 * 
	 * @param computer
	 */
	public static void setComputer(ArrayList<Device> computer) {
		G4OSDemo.computer = computer;
	}
	/**
	 * 
	 * @param processManager
	 */
	public static void setProcessManager(ProcessManager processManager) {
		G4OSDemo.processManager = processManager;
	}
	/**
	 * 
	 * @param memoryManager
	 */
	public static void setMemoryManager(MemoryManager memoryManager) {
		G4OSDemo.memoryManager = memoryManager;
	}
	/**
	 * 
	 * @param deviceManager
	 */
	public static void setDeviceManager(DeviceManager deviceManager) {
		G4OSDemo.deviceManager = deviceManager;
	}

	/**
	 * 
	 * @return
	 */
	public static G4OSDemo getInstance() {
		if (instance == null) {
			instance = new G4OSDemo();
		}
		return instance;
	}
	/**
	 * 
	 * @return
	 */
	public static ArrayList<Job> getJobs() {
		return jobs;
	}
	/**
	 * 
	 * @return
	 */
	public static ArrayList<Device> getComputer() {
		return computer;
	}
	/**
	 * 
	 * @return
	 */
	public static ProcessManager getProcessManager() {
		return processManager;
	}
	/**
	 * 
	 * @return
	 */
	public static MemoryManager getMemoryManager() {
		return memoryManager;
	}
	/**
	 * 
	 * @return
	 */
	public static DeviceManager getDeviceManager() {
		return deviceManager;
	}

	// Constructor
	/**
	 * 
	 */
	private G4OSDemo() {
		Initialize();
		LoadOS();
	}

	// Methods
	/**
	 * 
	 */
	public static void Start() {
		getInstance();
	}

	/**
	 * 
	 */
	public static void Initialize() {
		// TODO SystemLoader calls here.
	}

	/**
	 * 
	 */
	public static void LoadOS() {
		// TODO OS Manager Setup here.
		cpuCycle=0;
		currentJob=-1;
	}
	
	/**
	 * 
	 */
	public static void Update() {
		// TODO Continuously run update until exit condition
		// System is run from here		//will run the current setup and provide an analysis
		do
		{
			//determine whether or not to continue processing the current job;
			if(processManager.continueCurrentJob(cpuCycle))
			{
				//we will continue to process a line of the current job
				jobs.get(currentJob).proccessLine();
			}
			else
			{
				currentJob=processManager.loadJob();
			}
			
			//check with the memory manager to see if the next line of processable code from the current job is in the cache
			if(memoryManager.lineInCache(currentJob, jobs.get(currentJob).currentLine))
			{
				//if so process the current line
			}
			//else start the process of getting it there
			else if(memoryManager.lineInMemory(currentJob, jobs.get(currentJob).currentLine))
			{
				memoryManager.loadToCache(currentJob, jobs.get(currentJob).currentLine);
			}
			else
			{
				memoryManager.loadToMemory(currentJob, jobs.get(currentJob).currentLine);
			}
			
			//update cpuCycle
			cpuCycle++;
		}while(!jobsComplete());
	}	
	/*
	 * checks to see if all jobs in the list are complete
	 */
	public static boolean jobsComplete()
	{
		//determine if all completeable jobs are complete, if so return true
		return false;
	}
}
