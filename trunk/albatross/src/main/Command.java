package main;

/**
 * 
 * @author Mark A McKinney
 * @author Dustin Culler
 * @version 1.0 Alpha 20091120
 */
public class Command {
	// Fields
	private String command;
	private String argString;
	private int[] argInt;
	
	// Properties
	/**
	 * Sets the property of command.
	 * @param command Command to be acted upon.
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * Returns the property value stored in command.
	 * @return the command to be evaluated.
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * Sets the property of argString
	 * @param argString the argument evaluated by command.
	 */
	public void setArgString(String argString) {
		this.argString = argString;
	}

	/**
	 * Returns the property value stored in argString.
	 * @return the argument to be evaluated by command.
	 */
	public String getArgString() {
		return argString;
	}

	/**
	 * 
	 * @param position
	 * @param value
	 */
	public void setArgInt(int position, int value) {
		this.argInt[position] = value;
	}

	/**
	 * 
	 * @param position
	 * @return
	 */
	public int getArgInt(int position) {
		return argInt[position];
	}

	// Constructors
	/**
	 * 
	 * @param command
	 */
	private Command(String command) {
		Initialize(command, null, null, null);
	}
	
	/**
	 * 
	 * @param command
	 * @param argString
	 */
	private Command(String command, String argString) {
		Initialize(command, argString, null, null);
	}
	
	/**
	 * 
	 * @param command
	 * @param arg0
	 * @param arg1
	 */
	private Command(String command, Integer arg0, Integer arg1) {
		Initialize(command, null, arg0, arg1);
	}

	// Methods
	/**
	 * 
	 * @param command
	 * @param argString
	 * @param arg0
	 * @param arg1
	 */
	public void Initialize(String command, String argString, Integer arg0, Integer arg1) {
		this.setCommand(command);
		this.setArgString(argString);
		if (arg0 == null && arg1 == null) {
			this.argInt = null;
		} else {
			this.argInt = new int[2];
			if (arg0 == null) {
				this.setArgInt(0, 0);
			} else {
				this.setArgInt(0, arg0);
			}
			if (arg1 == null) {
				this.setArgInt(1, 0);
			} else {
				this.setArgInt(1, arg1);
			}
		}
	}
}
