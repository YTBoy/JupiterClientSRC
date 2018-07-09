package io.guthub.ytboy.jupiter.manager;

import java.util.ArrayList;
import java.util.List;

import io.guthub.ytboy.jupiter.module.Module;
import io.guthub.ytboy.jupiter.modules.Sprint;

public class ModuleManager {
	public static List<Module> MODS;
	public ModuleManager() {
		MODS = new ArrayList<>();
		this.MODS.add(new Sprint());
	}
	public void start() {
	}
	public void addMods() {
		
	}
}
