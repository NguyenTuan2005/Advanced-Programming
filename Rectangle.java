package Bai24_25;

import java.awt.*;

public class Rectangle extends Shape {
	private int x2, y2, weight, height;

	public Rectangle(int x1, int y1, Color color, boolean filled) {
		super(x1, y1, color, filled);
	}

	@Override
	public void resize(int x, int y) {
		this.weight = Math.abs(this.x1 - x);
		this.height = Math.abs(this.y1 - y);
		x2 = Math.min(x1, x);
		y2 = Math.min(y1, y);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		if (filled)
			g.fillRect(Math.min(x1, x2),Math.min(y1, y2), weight, height);
		else g.drawRect(Math.min(x1, x2),Math.min(y1, y2), weight, height);
	}
}
