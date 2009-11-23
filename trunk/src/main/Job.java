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
	}
}
