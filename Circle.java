package Bai24_25;

import java.awt.*;

public class Circle extends Shape {
    private int radius;

    public Circle(int x1, int y1, Color color, boolean filled) {
        super(x1, y1, color, filled);
    }

    @Override
    public void resize(int x, int y) {
        this.radius = (int) Math.sqrt((x1 - x) * (x1 - x) + (y1 - y) * (y1 - y));
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x1 - 2, y1 - 2, 4, 4);
        if (filled)
            g.fillOval(x1 - radius,y1 - radius, radius * 2, radius * 2);
        else g.drawOval(x1 - radius,y1 - radius, radius * 2, radius * 2);
    }
}
