package Bai24_25;

import java.awt.*;

public abstract class Shape {
	protected int x1, y1;
	protected Color color;
	protected boolean filled;

	public Shape(int x1, int y1, Color color, boolean filled) {
		this.x1 = x1;
		this.y1 = y1;
		this.color = color;
		this.filled = filled;
	}

	public abstract void resize(int x, int y);

	public abstract void draw(Graphics g);
}
