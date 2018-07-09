package io.github.ytboy.jupiter.modules;

import org.lwjgl.input.Keyboard;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import io.github.ytboy.jupiter.event.EventPostUpdate;
import io.github.ytboy.jupiter.event.EventPreUpdate;
import io.github.ytboy.jupiter.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.network.play.client.CPacketEntityAction.Action;

public class Killaura extends Module {
	public Killaura() {
		super("Killaura", "Automatically hits enemies near you", Keyboard.KEY_R, Category.COMBAT);

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
		for (Entity ent : getMC().world.loadedEntityList) {
			if (checks(ent)) {
				EntityLivingBase en = (EntityLivingBase)ent;

				getMC().playerController.attackEntity(getMC().player, en);
				getMC().player.swingArm(EnumHand.MAIN_HAND);
			}else {
			}
		}
	}

	boolean checks(Entity en) {
		if(!(en instanceof EntityLivingBase)) {
			return false;
		}
		if (en == getMC().player) {
			return false;
		}
		if (en.isDead) {
			return false;
		}
		if (en.isInvisible()) {
			return false;
		}
		if (en.getDistanceToEntity(getMC().player) > 4) {
			return false;
		}
		if (getMC().player.getCooledAttackStrength(0) < 1f) {
			return false;
		}
		return true;

	}
}
