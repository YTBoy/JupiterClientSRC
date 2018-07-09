package io.github.ytboy.jupiter.modules;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;

import io.github.ytboy.jupiter.event.Event3DRender;
import io.github.ytboy.jupiter.module.Module;
import io.github.ytboy.jupiter.util.RenderUtils;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;

public class ESP extends Module {
	private final ArrayList<Entity> players = new ArrayList<>();
	int playerBox;

	public ESP() {
		super("ESP", "", Keyboard.KEY_J, Category.RENDER);
	}

	@Override
	public void onEnable() {
		playerBox = GL11.glGenLists(1);
		GL11.glNewList(playerBox, GL11.GL_COMPILE);
		AxisAlignedBB bb = new AxisAlignedBB(-0.5, 0, -0.5, 0.5, 1, 0.5);
		RenderUtils.drawOutlinedBox(bb);
		GL11.glEndList();
		EventManager.register(this);
		super.onEnable();
	}

	@Override
	public void onDisable() {
		EventManager.unregister(this);
		super.onDisable();
	}

	@EventTarget
	public void on3D(Event3DRender e) {
		for (Entity en : getMC().world.loadedEntityList) {
			if (en instanceof EntityLivingBase) {

				if (en.getName() == getMC().player.getName()) {

				} else {
					players.add(en);
				}
			}
		}
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glLineWidth(2);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);

		GL11.glPushMatrix();
		GL11.glTranslated(-getMC().getRenderManager().renderPosX, -getMC().getRenderManager().renderPosY,
				-getMC().getRenderManager().renderPosZ);

		// draw boxes
		renderBoxes(e.pticks());

		GL11.glPopMatrix();

		// GL resets
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_LINE_SMOOTH);
	}

	private void renderBoxes(double partialTicks) {
		for (Entity e : players) {
			// set position
			GL11.glPushMatrix();
			GL11.glTranslated(e.prevPosX + (e.posX - e.prevPosX) * partialTicks,
					e.prevPosY + (e.posY - e.prevPosY) * partialTicks,
					e.prevPosZ + (e.posZ - e.prevPosZ) * partialTicks);
			GL11.glScaled(e.width + 0.1, e.height + 0.1, e.width + 0.1);

			// set color
			float f = getMC().player.getDistanceToEntity(e) / 20F;
			GL11.glColor4f(2 - f, f, 0, 0.5F);

			// draw box
			GL11.glCallList(playerBox);

			GL11.glPopMatrix();
		}
	}

	private void renderTracers(double partialTicks) {
		// Vec3d start = RotationUtils.getClientLookVec().addVector(0,
		// getMC().player.getEyeHeight(), 0).addVector(
		// getMC().getRenderManager().renderPosX, getMC().getRenderManager().renderPosY,
		// getMC().getRenderManager().renderPosZ);
		//
		// GL11.glBegin(GL11.GL_LINES);
		// for (EntityPlayer e : players) {
		// Vec3d end = e.getEntityBoundingBox().getCenter().subtract(new Vec3d(e.posX,
		// e.posY, e.posZ)
		// .subtract(e.prevPosX, e.prevPosY, e.prevPosZ).scale(1 - partialTicks));
		//
		// float f = getMC().player.getDistanceToEntity(e) / 20F;
		// GL11.glColor4f(2 - f, f, 0, 0.5F);
		//
		// GL11.glVertex3d(start.xCoord, start.yCoord, start.zCoord);
		// GL11.glVertex3d(end.xCoord, end.yCoord, end.zCoord);
		// }
		// GL11.glEnd();
	}

}
