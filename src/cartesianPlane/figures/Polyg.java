package cartesianPlane.figures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Polyg {

    public void draw(Graphics graphics, int x, int y) {

        int c = 25;

        Polygon p = new Polygon();
        p.addPoint(16 * c, 14 * c);

        p.addPoint(12 * c, 14 * c);
        p.addPoint(14 * c, 16 * c);

        p.addPoint(12 * c, 18 * c);

        p.addPoint(8 * c, 14 * c);

        p.addPoint(12 * c, 10 * c);

        graphics.setColor(Color.ORANGE);
        graphics.translate(x, y);
        graphics.fillPolygon(p);

    }

}
