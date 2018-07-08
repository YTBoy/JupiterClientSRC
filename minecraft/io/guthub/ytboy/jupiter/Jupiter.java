package io.guthub.ytboy.jupiter;

import org.lwjgl.opengl.Display;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import io.guthub.ytboy.Client;
import io.guthub.ytboy.jupiter.event.EventKeyPress;
import io.guthub.ytboy.jupiter.manager.ModuleManager;
/*main class for jupiter*/
public class Jupiter extends Client{
//	ModuleManager MODULE_MANAGER = new ModuleManager();

	public Jupiter() {
		super("Jupiter", "0.1");
	}
	@Override
	public void start() {
//		EventManager.register(this);
//		MODULE_MANAGER.addMods();
		super.start();
	}
	@EventTarget
	public void keyPress(EventKeyPress key) {
		System.out.println(key);
	}
	

}
