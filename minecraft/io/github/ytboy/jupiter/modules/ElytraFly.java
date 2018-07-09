package io.github.ytboy.jupiter.modules;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import io.github.ytboy.jupiter.event.EventPostUpdate;
import io.github.ytboy.jupiter.event.EventPreUpdate;
import io.github.ytboy.jupiter.module.Module;
import io.github.ytboy.jupiter.util.MovementUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.network.play.client.CPacketAnimation;

public class ElytraFly extends Module {
	public ElytraFly() {
		super("ElytraFly", "Elytra Fly", Keyboard.KEY_G, Category.MOVEMENT);

	}

	@Override
	public void onEnable() {
		EventManager.register(this);
	}

	@Override
	public void onDisable() {
		EventManager.unregister(this);
	}

	@EventTarget
	public void onPostUpdate(EventPostUpdate e) {
		EntityPlayerSP p = getMC().player;
		if (p.isElytraFlying()) {
			float a = p.rotationPitch < 0.5f ? 0.1f : -0.1f;
			p.motionY = a;
			MovementUtils.setSpeed(0.8);
		}
	}
}
