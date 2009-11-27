package main;

import java.io.*;
import java.util.*;

public class SystemLoader {
	
	/**
	 * Gets the jobs stored in the directory given. Returns an array
	 * of jobs equal to the number of valid jobs in the directory.
	 * @param directory Directory the jobs to be loaded are located
	 * @return Array of jobs equal to the number of jobs stored in directory
	 * @throws IOException
	 */
	public Job[] getJobs(String directory) throws IOException {
		File dir = new File(directory);
		
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return !name.startsWith(".");
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
				jobs.add(loadJob(filename));
			}
			
			Job[] temp = new Job[jobs.size()];
			return jobs.toArray(temp);
		} else {
			return null;
		}
	}
	
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
			if (current.countTokens() < 1 || current.countTokens() > 3) {
				System.out.println("Current line %i is not formatted correctly.  Ignoring");
			}
		}
		return job;
	}
}
