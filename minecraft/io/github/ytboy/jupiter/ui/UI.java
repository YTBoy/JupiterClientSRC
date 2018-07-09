package io.github.ytboy.jupiter.ui;

import io.github.ytboy.jupiter.manager.ModuleManager;
import io.github.ytboy.jupiter.module.Module;
import io.github.ytboy.jupiter.ui.component.components.ArrayListComponent;
import io.github.ytboy.jupiter.ui.component.components.NameComponent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class UI extends Gui {
	public static void render() {
		int y = 0;
		NameComponent name = new NameComponent(1, 1, 40, 10, "Jupiter", -1, 0x40000000);
		name.render();
		for (Module m : ModuleManager.MODS) {
			if (m.isActive()) {
				ArrayListComponent mod = new ArrayListComponent(1, 30 + y,
						Minecraft.getMinecraft().fontRendererObj.getStringWidth(m.getName()), 10, m.getName(), -1,
						0x40000000);
				mod.render();
				y += 10;
			}
		}
	}
}
