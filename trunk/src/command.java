/**
 * 
 * @author Dustin
 *
 */

public class command {
	public enum type {proccessLine, jump, calldevice}
	public String name;
	public int jumpTo;
	public int iterations;
	public String deviceCalled;
}
