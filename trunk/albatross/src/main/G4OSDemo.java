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
	}
	
	/**
	 * 
	 */
	public static void Update() {
		// TODO Continuously run update until exit condition
		// System is run from here
	}
}
