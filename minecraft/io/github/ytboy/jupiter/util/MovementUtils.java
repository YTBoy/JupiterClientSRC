package io.github.ytboy.jupiter.util;

import net.minecraft.client.Minecraft;
import net.minecraft.util.math.MathHelper;

public class MovementUtils {
	private static Minecraft mc = Minecraft.getMinecraft();

	public static float getDirection() {
		float yaw = mc.player.rotationYawHead;
		float forward = mc.player.moveForward;
		float strafe = mc.player.moveStrafing;
		yaw += (forward < 0.0F ? 180 : 0);
		if (strafe < 0.0F) {
			yaw += (forward < 0.0F ? -45 : forward == 0.0F ? 90 : 45);
		}
		if (strafe > 0.0F) {
			yaw -= (forward < 0.0F ? -45 : forward == 0.0F ? 90 : 45);
		}
		return yaw * 0.017453292F;
	}

	public static double square(double in) {
		return in * in;
	}

	public static double getSpeed() {
		return Math.sqrt(square(mc.player.motionX) + square(mc.player.motionZ));
	}

	public static void setSpeed(double speed) {
		mc.player.motionX = (-MathHelper.sin(getDirection()) * speed);
		mc.player.motionZ = (MathHelper.cos(getDirection()) * speed);
	}

	public static boolean isMoving() {
		return (mc.player.moveForward != 0.0F) || (mc.player.moveStrafing != 0.0F);
	}

}
