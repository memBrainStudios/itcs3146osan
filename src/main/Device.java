package main;

import java.util.*;

/**
 * 
 * @author Mark A McKinney
 * @author Dustin Culler
 * @version 1.0 Alpha 20091120
 */
public class Device {
	// Fields
	private Object parent;
	private String name;
	private int delay;
	private ArrayList<Device> devices;
	private Command[] store;
	private boolean initialized;
	private boolean active;

	// Properties
	/**
	 * 
	 * @param parent
	 */
	private void setParent(Object parent) {
		this.parent = parent;
	}
	/**
	 * 
	 * @param name
	 */
	private void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @param delay
	 */
	private void setDelay(int delay) {
		this.delay = delay;
	}
	/**
	 * 
	 * @param devices
	 */
	private void setDevices(ArrayList<Device> devices) {
		this.devices = devices;
	}
	/**
	 * 
	 * @param store
	 */
	private void setStore(Command[] store) {
		this.store = store;
	}
	/**
	 * 
	 * @param value
	 */
	private void setInitialized(boolean value) {
		this.initialized = value;
	}
	/**
	 * 
	 * @param value
	 */
	public void setActive(boolean value) {
		this.active = value;
	}

	/**
	 * 
	 * @return
	 */
	public Object getParent() {
		return parent;
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
	public int getDelay() {
		return delay;
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<Device> getDevices() {
		return devices;
	}
	/**
	 * 
	 * @return
	 */
	public Command[] getStore() {
		return store;
	}
	/**
	 * 
	 * @return true when initialized
	 */
	public boolean isInitialized() {
		return initialized;
	}
	/**
	 * 
	 * @return true when active
	 */
	public boolean isActive() {
		return active;
	}

	// Constructors
	/**
	 * 
	 * @param name
	 * @param delay
	 */
	private Device(Object parent, String name, int delay) {
		Initialize(parent, name, delay, null);
	}
	
	/**
	 * 
	 * @param name
	 * @param delay
	 * @param size
	 */
	private Device(Object parent, String name, int delay, int size) {
		Initialize(parent, name, delay, size);
	}

	// Methods
	/**
	 * 
	 * @param name
	 * @param delay
	 * @param size
	 */
	private void Initialize(Object parent, String name, Integer delay, Integer size) {
		this.setParent(parent);
		this.setName(name);
		this.setDelay(delay);
		this.setDevices(null);
		if (size == null) {
			this.setStore(null);
		} else {
			this.setStore(new Command[size]);
		}
		setInitialized(true);
	}

	/**
	 * 
	 */
	public void Update() {
		// To do...
	}
}
