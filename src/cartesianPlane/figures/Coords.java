package cartesianPlane.figures;

import java.awt.Color;
import java.awt.Graphics;

public class Coords {

    public void draw(Graphics graphics) {

        graphics.setColor(Color.BLACK);

        //X
        graphics.drawLine(0, 350, 600, 350);

        //Y
        graphics.drawLine(300, -600, 300, 600);

        int xPo = 1;

        //X+
        for (int i = 308; i < 600; i += 51) {

            graphics.drawString(" " + xPo + " ", i, 350);
            xPo+=51;
        }

        int xNe = 0;

        //X-
        for (int i = 285; i > 0; i -= 51) {
            graphics.drawString(" " + xNe + " ", i, 350);
            xNe-=51;
        }

        int yPo = 1;

        //Y+
        for (int i = 370; i < 600; i += 51) {
            graphics.drawString(" " + yPo + " ", 280, i);
            yPo+=51;
        }

        int yNe = -1;
        //Y-
        for (int i = 330; i > 0; i -= 51) {
            graphics.drawString(" " + yNe + " ", 280, i);
            yNe-=51;
        }
    }

}
