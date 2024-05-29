package Bai24_25;

import java.awt.*;

public class Line extends Shape {
	private int x2, y2;

	public Line(int x1, int y1, Color color, boolean filled) {
		super(x1, y1, color, filled);
	}

	@Override
	public void resize(int x, int y) {
		this.x2 = x;
		this.y2 = y;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(x1, y1, x2, y2);
	}
}
