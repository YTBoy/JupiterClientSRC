package io.github.ytboy.jupiter.module;

import net.minecraft.client.Minecraft;

public class Module {
	 Minecraft mc = Minecraft.getMinecraft();
	String name;
	int bind;
	String description;
	Category category;
	boolean active;
	
	public Module(String name, String description, int bind, Category category) {
		this.name = name;
		this.description = description;
		this.bind = bind;
		this.category = category;
	}

	public enum Category {
		COMBAT, MOVEMENT, RENDER, PLAYER
	}
	public void update() {}
	public void onEnable() {}
	public void onDisable() {}
	public void onToggle() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBind() {
		return bind;
	}
	public void setBind(int bind) {
		this.bind = bind;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		onToggle();
		if(active) {
			onEnable();
		}else {
			onDisable();
		}
		this.active = active;
	}
	
	public Minecraft getMC() {
		return Minecraft.getMinecraft();
	}
}
