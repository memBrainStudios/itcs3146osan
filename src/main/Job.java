package main;

import java.util.*;

/**
 * 
 * @author Mark A McKinney
 * @author Dustin Culler
 * @version 1.0 Alpha 20091120
 */
public class Job {
	// Fields
	private String name;
	private ArrayList<Command> lines;
	public int currentLine;


	// Properties
	/**
	 * 
	 * @param name
	 */
	private void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @param lines
	 */
	private void setLines(ArrayList<Command> lines) {
		this.lines = lines;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<Command> getLines() {
		return lines;
	}

	// Constructors
	/**
	 * 
	 * @param name
	 */
	public Job(String name) {
		Initialize(name, null);
	}
	
	/**
	 * 
	 * @param name
	 * @param lines
	 */
	public Job(String name, ArrayList<Command> lines) {
		Initialize(name, lines);
	}

	// Methods
	/**
	 * 
	 * @param name
	 * @param lines
	 */
	private void Initialize(String name, ArrayList<Command> lines) {
		this.setName(name);
		this.setLines(lines);
	}

	/**
	 * 
	 * @param command
	 */
	public void addCommand(Command command) {
		lines.add(command);
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public Command removeCommand(int index) {
		return lines.remove(index);
	}	/*
	 * will proccess the next line in the job
	 */
	public void proccessLine()
	{
		if(lines.get(currentLine).getCommand().equals("proccess command"))
		{
			currentLine++;
		}
		else if(lines.get(currentLine).getCommand().equals("loop for"))
		{
			lines.get(currentLine).setArgInt(1, lines.get(currentLine).getArgInt(1)-1);
			if (lines.get(currentLine).getArgInt(1) < 0)
			{
				currentLine = lines.get(currentLine).getArgInt(0);
			}
			else
			{
				currentLine++;
			}
		}
		else if(lines.get(currentLine).getCommand().equals("device call"))
		{
			//finish this logic
		}
	}
}
