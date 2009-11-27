package main;

/**
 * @author Mark A McKinney
 * @version 1.0 Alpha 20091120
 */
public class G4OSDemoDriver implements Runnable {
	static Thread G4OSDemo_thread = new Thread(new G4OSDemoDriver());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		G4OSDemo_thread.start();			// starts the thread and calls run()
	}

	/**
	 * 
	 */
	@Override
	public void run() {
		G4OSDemo.Start();
	}
}
