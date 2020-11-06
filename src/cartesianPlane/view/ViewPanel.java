package cartesianPlane.view;

import java.awt.Graphics;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import cartesianPlane.figures.Coords;
import cartesianPlane.figures.Polyg;

public class ViewPanel extends JPanel {

    private Point initialClick;
    private int figureX;
    private int figureY;
    private Timer timer;
    private boolean completed = false;

    private final CoordsListener listener;

    public ViewPanel(CoordsListener listener) {

        this.listener = listener;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                initialClick = e.getPoint();
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {

                moveFigure(e.getX(), e.getY());

                repaint();
            }
        });
    }

    private void moveFigure(int x, int y) {
        int thisX = figureX;
        int thisY = figureY;

        int xMoved = (thisX + x) - (thisX + initialClick.x);
        int yMoved = (thisY + y) - (thisY + initialClick.y);

        figureX = xMoved;
        figureY = yMoved;
    }

    public void animateFigure(int x, int y) {
        timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (figureX != x) {

                    if (figureX > x) {
                        figureX--;
                    } else {
                        figureX++;
                    }
                }

                if (figureY != y) {

                    if (figureY > y) {
                        figureY--;
                    } else {
                        figureY++;
                    }

                }

                if (figureX == x && figureY == y) {
                    completed = true;
                } else {
                    completed = false;
                }

                repaint();
            }

        });

        timer.start();
    }

    @Override
    public void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);

        graphics.translate(-50, -150);

        listener.onCoordsChanged(figureX, figureY);

        if (completed) {
            timer.stop();
            completed = false;
        }

        new Coords().draw(graphics);
        new Polyg().draw(graphics, figureX, figureY);
    }

    interface CoordsListener {

        void onCoordsChanged(int x, int y);
    }
}
