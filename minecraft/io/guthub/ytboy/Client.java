package io.guthub.ytboy;

import org.lwjgl.opengl.Display;

public class Client {
	/*
	 * Main class for Jupiter.java to extend
	 */
	
	/* client name*/
	String NAME;
	/*client version*/
	String VERSION;
	/*constructor*/
	public Client(String name, String version) {
		this.NAME = name;
		this.VERSION = version;
		start();
		Display.setTitle(name + " " + version);
	}
	/*starting method*/
	public void start() {}
}
