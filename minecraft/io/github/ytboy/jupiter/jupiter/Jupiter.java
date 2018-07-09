package io.github.ytboy.jupiter.jupiter;

import java.util.ArrayList;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import io.github.ytboy.jupiter.Client;
import io.github.ytboy.jupiter.event.EventKeyPress;
import io.github.ytboy.jupiter.manager.ModuleManager;
import io.github.ytboy.jupiter.module.Module;
/*main class for jupiter*/
public class Jupiter extends Client{
	ModuleManager MODULE_MANAGER = new ModuleManager();

	public Jupiter() {
		super("Jupiter", "0.1");
	}
	@Override
	public void start() {
		EventManager.register(this);
		MODULE_MANAGER.MODS = new ArrayList();

		super.start();

	}
	@EventTarget
	public void keyPress(EventKeyPress key) {
		for(Module m : MODULE_MANAGER.MODS) {
			if(key.getKey() == m.getBind()) {
				m.setActive(!m.isActive());
			}
		}
	}
	

}
