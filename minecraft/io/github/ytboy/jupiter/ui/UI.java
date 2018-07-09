package io.github.ytboy.jupiter.ui;

import org.lwjgl.opengl.GL11;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import io.github.ytboy.jupiter.event.Event2DRender;
import io.github.ytboy.jupiter.manager.ModuleManager;
import io.github.ytboy.jupiter.module.Module;
import io.github.ytboy.jupiter.ui.component.components.ArrayListComponent;
import io.github.ytboy.jupiter.ui.component.components.NameComponent;
import io.github.ytboy.jupiter.ui.component.components.TextComponent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.world.gen.layer.GenLayerRemoveTooMuchOcean;

public class UI extends Gui {
	public UI() {
		EventManager.register(this);
	}
	@EventTarget
	public static void render(Event2DRender e) {
		ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
		Minecraft mc = Minecraft.getMinecraft();
		int y = 0;
		if(mc.objectMouseOver.typeOfHit != null && mc.objectMouseOver.typeOfHit == Type.ENTITY) {
			EntityLivingBase ent = (EntityLivingBase) mc.objectMouseOver.entityHit;
			TextComponent text = new TextComponent(sr.getScaledWidth() / 2, sr.getScaledHeight()/2 + 10, 100, 10, ent.getName() + " H:" + ent.getHealth(), -1, 0x40000000);
			text.render();
		}
		NameComponent name = new NameComponent(1, 1, 40, 10, "§cJup§7iter", -1, 0x40000000);
		GL11.glPushMatrix();
		GL11.glScalef(2, 2, 2);
		name.render();
		GL11.glPopMatrix();
		for (Module m : ModuleManager.MODS) {
			if (m.isActive()) {
				ArrayListComponent mod = new ArrayListComponent(1, 23 + y,
						2 + Minecraft.getMinecraft().fontRendererObj.getStringWidth(m.getName()), 10, m.getName(), -1,
						0x40000000);
				mod.render();
				y += 10;
			}
		}
	}
}
