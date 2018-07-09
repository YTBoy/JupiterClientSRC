package io.github.ytboy.jupiter.ui.component.components;

import io.github.ytboy.jupiter.ui.component.Component;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class NameComponent extends Component {

	public NameComponent(int x, int y, int width, int height, String text, int textcolor, int bgcolor) {
		super(x, y, width, height, text, textcolor, bgcolor);
	}

	@Override
	public void render() {
		FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;
		Gui.drawRect(x, y, x + width, y + height, bgcolor);
		fr.drawString(text, x, y, textcolor);
		super.render();
	}

}
