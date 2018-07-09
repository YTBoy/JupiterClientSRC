package io.github.ytboy.jupiter.ui.component;

public class Component {
	public int x;
	public int y;
	public int width;
	public int height;
	public String text;
	public int textcolor;
	public int bgcolor;

	public Component(int x, int y, int width, int height, String text, int textcolor, int bgcolor) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.text = text;
		this.textcolor = textcolor;
		this.bgcolor = bgcolor;
	}
	public void render() {}

}
