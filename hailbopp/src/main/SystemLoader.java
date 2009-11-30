package main;

import java.io.*;
import java.util.*;

/**
 * Loads the system configuration from directories provided.
 * @author Mark McKinney
 */
public class SystemLoader {

	public SystemLoader() {
		// Shell constructor for instantiation
	}

	/**
	 * Gets the jobs stored in the directory given. Returns an array
	 * of jobs equal to the number of valid jobs in the directory.
	 * @author Mark McKinney
	 * @param directory Directory the jobs to be loaded are located
	 * @return Array of jobs equal to the number of jobs stored in directory
	 * @throws IOException
	 */
	public Job[] getJobs(String directory) throws IOException {
		// Create the new directory to look through
		File dir = new File(directory);

		// Filter out unwanted generic directory structures
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return !(name.startsWith(".")||name.startsWith("_"));
			}
		};

		// Get all files in the directory
		String[] filesInDirectory = dir.list(filter);

		// If there are files in the directory read files
		if (filesInDirectory != null) {
			ArrayList<Job> jobs = new ArrayList<Job>();

			// Get jobs for each file in the directory
			for (int i = 0; i < filesInDirectory.length; i++) {
				// Get the next file in the directory
				String filename = filesInDirectory[i];

				// Add new job to jobs list
				jobs.add(loadJob(directory + "\\" + filename));
			}

			Job[] temp = new Job[jobs.size()];
			jobs.toArray(temp);
			return temp;
		} else {
			return null;
		}
	}

	/**
	 * Gets the commands stored in file provided and returns a
	 * Job object created from the file.
	 * @author Mark McKinney
	 * @param filename The file to create Job from
	 * @return Job created from file
	 * @throws IOException
	 */
	public Job loadJob(String filename) throws IOException {
		// Job to be returned after parsing file
		Job job;
	
		// List to store lines read from file
		ArrayList<String> lines = new ArrayList<String>();

		// Read file and send to BufferedReader
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);

		// Read first line in file
		String line = br.readLine();

		// Continue to read files until EOF
		while (line != null) {
			lines.add(line);
			line = br.readLine();
		}
		
		// Clean up list to remove unnecessary null elements generated
		// during file read.
		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i) == null) {
				lines.remove(i);
			}
		}

		// Close file
		br.close();
		fr.close();

		// Add new job to jobs list
		job = new Job(lines.size());

		// Parse lines to commands for job
		for (int j = 0; j < lines.size(); j++) {
			StringTokenizer current = new StringTokenizer(lines.get(j));
			if (current.countTokens() == 1) {
				job.addCommand(j, new Command(current.nextToken()));
			}
			if (current.countTokens() == 2) {
				job.addCommand(j, new Command(current.nextToken(),
											  current.nextToken()));
			}
			if (current.countTokens() == 3) {
				job.addCommand(j, new Command(current.nextToken(),
											  Integer.parseInt(current.nextToken()),
											  Integer.parseInt(current.nextToken())));
			}
			if (current.countTokens() == 0) {
				
			}
			if (current.countTokens() < 0 || current.countTokens() > 3) {
				System.out.println("Current line %i is not formatted correctly.  Ignoring");
			}
		}
		return job;
	}

	/**
	 * Gets the devices from files stored in the specified directory
	 * @author Mark McKinney
	 * @param directory Directory containing device configuration files
	 * @return Array of devices made from configuration files
	 * @throws IOException
	 */
	public Device[] getDevices(String directory) throws IOException {
		// Create the new directory to look through
		File dir = new File(directory);

		// Filter out unwanted generic directory structures
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return !(name.startsWith(".")||name.startsWith("_"));
			}
		};

		// Get all files in the directory
		String[] filesInDirectory = dir.list(filter);

		// If there are files in the directory read files
		if (filesInDirectory != null) {
			ArrayList<Device> devices = new ArrayList<Device>();

			// Get devices for each file in the directory
			for (int i = 0; i < filesInDirectory.length; i++) {
				// Get the next file in the directory
				String filename = filesInDirectory[i];

				// Add new device to device list
				devices.add(loadDevice(directory + "\\" + filename));
			}

			Device[] temp = new Device[devices.size()];
			return devices.toArray(temp);
		} else {
			return null;
		}
	}

	/**
	 * Gets the device configuration stored in the file given
	 * @author Mark McKinney
	 * @param filename name of file the device configuration is stored
	 * @return The device stored in the file
	 * @throws IOException
	 */
	public Device loadDevice(String filename) throws IOException {
		// Device to be returned after parsing file
		Device device;

		// List to store lines read from file
		ArrayList<String> lines = new ArrayList<String>();

		// Read file and send to BufferedReader
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);

		// Read first line in file
		String line = br.readLine();

		// Continue to read files until EOF
		while (line != null) {
			lines.add(line);
			line = br.readLine();
		}

		// Close file
		br.close();
		fr.close();

		// Create new device
		device = new Device(lines.get(0), Integer.parseInt(lines.get(1)));

		return device;
	}

	/**
	 * Creates and loads the computer environment
	 * @author Mark McKinney
	 * @param filename File to create computer from
	 * @param dList list of available devices to call
	 * @return computer and device configuration for current run
	 * @throws IOException
	 */
	public Computer loadComputer(String filename, Device[] dList) throws IOException {
		// Computer to be returned after parsing file
		Computer computer = null;

		// List to store lines read from file
		ArrayList<String> lines = new ArrayList<String>();

		// Read file and send to BufferedReader
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);

		// Read first line in file
		String line = br.readLine();

		// Continue to read files until EOF
		while (line != null) {
			lines.add(line);
			line = br.readLine();
		}

		// Close file
		br.close();
		fr.close();

		// Parse stored lines into computer configuration info.
		int memorySize = 0;
		int cacheSize = 0;
		int memAccess = 0;
		int storageAccess = 0;
		int[] devices = null;

		for (int i = 0; i < lines.size(); i++) {
			StringTokenizer current = new StringTokenizer(lines.get(i));
			String test = current.nextToken();
			if (test.equals("memory-size")) {
				memorySize = Integer.parseInt(current.nextToken());
			}
			if (test.equals("cache-size")) {
				cacheSize = Integer.parseInt(current.nextToken());
			}
			if (test.equals("memory-access-time")) {
				memAccess = Integer.parseInt(current.nextToken());
			}
			if (test.equals("storage-access-time")) {
				storageAccess = Integer.parseInt(current.nextToken());
			}
			if (test.equals("device")) {
				devices = new int[current.countTokens()];
				int j = 0;
				while(current.hasMoreTokens()) {
					devices[j] = Integer.parseInt(current.nextToken());
					j++;
				}
			}
		}

		// Create new Computer
		computer = new Computer(memorySize, cacheSize, memAccess, storageAccess);

		// Load devices
		computer.initDevices(devices.length);

		for (int i = 0; i < devices.length; i++) {
			computer.addDevice(i, dList[devices[i]-1]);
		}

		return computer;
	}
}
