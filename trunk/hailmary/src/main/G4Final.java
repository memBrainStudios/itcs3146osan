package main;


/*
 *      G4Final.java
 *      
 * 		
 */
import java.io.*;


public class G4Final {
	public static Job[] jList;
	public static Device[] dList;
	public static Computer setup;
	public static String analysis;
	private static boolean detailedAnalysis = true;
	
	public static ProcessManager pm;
	public static MemoryManager mm;

	public static void main(String args[]) throws IndexOutOfBound
	{
		SystemLoader load = new SystemLoader();
		try
		{
			String dir = new java.io.File(".").getCanonicalPath();
			if(dir.contains("_svn"))
			{
				dir = new java.io.File("..").getCanonicalPath();
			}
			jList = load.getJobs(dir+"\\jobs");
			dList = load.getDevices(dir+"\\devices");
			setup = load.loadComputer(dir+"\\computers\\setup1.txt", dList);
		}
		catch (IOException e) {
			System.err.println("Caught IOException: " +  e.getMessage());
		}
		//testing
//		jList = new Job[2];
//		jList[0] = new Job(5);
//		jList[0].addCommand(0, new Command("procces command"));
//		jList[0].addCommand(1, new Command("procces command"));
//		jList[0].addCommand(2, new Command("procces command"));
//		jList[0].addCommand(3, new Command("procces command"));
//		jList[0].addCommand(4, new Command("procces command"));
//		jList[1] = new Job(3);
//		jList[1].addCommand(0, new Command("procces command"));
//		jList[1].addCommand(1, new Command("procces command"));
//		jList[1].addCommand(2, new Command("procces command"));
//		dList = new Device[2];
//		dList[0] = new Device("printer", 100);
//		dList[1] = new Device("sound card", 80);
//		setup = new Computer(2000, 200);
//		setup.initDevices(2);
//		setup.addDevice(0, dList[0]);
//		setup.addDevice(1, dList[1]);
		//testing
		mm = new MemoryManager(setup);
		pm = new ProcessManager();
		for (int i=0; i<jList.length; i++)
		{
			pm.newJob(i);
		}
		//begin first test
		addNonDetailedAnalysis("This is a non-detailed analysis");
		addDetailedAnalysis("This is a detailed analysis");
		addAnalysis(setup.basicInfoString());
		addAnalysis(setup.deviceInfoString());
		runSetup();
		System.out.println(analysis);
	}
	
	/*
	 * runs the current computer setup given the list of jobs
	 */
	public static void runSetup() throws IndexOutOfBound
	{
		//will run the current setup and provide an analysis
		int cpuCycle=0;
		int currentJob=pm.loadJob(cpuCycle);
		do
		{
			for(long i=0;i<200000000;i++);
			addDetailedAnalysis("Begining CPU cycle # " + cpuCycle);
			//determine whether or not to continue processing the current job;
			if(!pm.continueCurrentJob(cpuCycle))
			{
				addDetailedAnalysis("\tLoading Job: " + pm.loadJob(cpuCycle));
				currentJob=pm.loadJob(cpuCycle);
			}
			
			//check with the memory manager to see if the next line of processable code from the current job is in the cache
			if(mm.lineInCache(currentJob, jList[currentJob].currentLine))
			{
				//if so process the current line
				addDetailedAnalysis("Proccessing Job " + currentJob +
						", line number " + jList[currentJob].currentLine);
				jList[currentJob].proccessLine();
			}
			//else start the process of getting it there
			else if(mm.lineInMemory(currentJob, jList[currentJob].currentLine))
			{
				if(cpuCycle%setup.memAccessTime == 0)
				{
					mm.loadToCache(currentJob, jList[currentJob].currentLine);
					addDetailedAnalysis("The memory manager loaded in line " +
							jList[currentJob].currentLine +
							" of job " +
							currentJob +
							" from main memory into cache memory");
				}
				else
				{
					addDetailedAnalysis("Asked the memory manager to load in line " +
							jList[currentJob].currentLine +
							" of job " +
							currentJob +
							" from main memory into cache memory");
				}
			}
			else if(cpuCycle%setup.storageAccessTime == 0)
			{
				mm.loadToMemory(currentJob, jList[currentJob].currentLine);
				addDetailedAnalysis("The memory manager loaded in line " +
						jList[currentJob].currentLine +
						" of job " +
						currentJob +
						" from secondary storage into the main memory");
			}
			else 
			{
				addDetailedAnalysis("Asked the memory manager to load in line " +
						jList[currentJob].currentLine +
						" of job " +
						currentJob +
						" from secondary storage into the main memory");
			}
			//determine if current job is complete if so clear it out
			if(jList[currentJob].isComplete())
			{
				addDetailedAnalysis("Job number " + currentJob + " is Complete");
				addAnalysis("Job number " + currentJob + " finished in " + cpuCycle + " CPU cycles.");
				pm.jobFinished(currentJob);
				addDetailedAnalysis("\tLoading Job: " + pm.loadJob(cpuCycle));
				currentJob=pm.loadJob(cpuCycle);
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
		for(int i = 0; i<jList.length; i++)
		{
			if(!jList[i].isComplete())
			{
				return false;
			}
		}
		return true;
	}
	
	/*
	 * A way to add a line to the analysis printout
	 */
	private static void addAnalysis(String newLine)
	{
		System.out.println(newLine);
		analysis += "\n" + newLine;
	}
	
	/*
	 * Add a line of analysis to the printout if a detailed analysis is specified
	 */
	private static void addDetailedAnalysis(String newLine)
	{
		if(detailedAnalysis)
		{
			System.out.println(newLine);
			analysis += "\n" + newLine;
		}
	}
	
	/*
	 * Add a line of analysis to the printout if a non detailed analysis is specified
	 */
	private static void addNonDetailedAnalysis(String newLine)
	{
		if(!detailedAnalysis)
		{
			System.out.println(newLine);
			analysis += "\n" + newLine;
		}
	}
}
