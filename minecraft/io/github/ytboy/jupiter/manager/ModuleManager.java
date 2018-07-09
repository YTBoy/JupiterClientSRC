package io.github.ytboy.jupiter.manager;

import java.util.ArrayList;
import java.util.List;

import io.github.ytboy.jupiter.module.Module;
import io.github.ytboy.jupiter.modules.Sprint;

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
