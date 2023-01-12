package Client.RunOs.Features;

import java.awt.Point;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;

import java.awt.event.MouseEvent;

public class FrameDragListener extends MouseAdapter{
    private final JFrame frame;
    private Point mouseDragCoords = null;

    public FrameDragListener(JFrame frame) {
        this.frame = frame;
    }

    public void mouseReleased(MouseEvent e) {
        mouseDragCoords = null;
    }

    public void mousePressed(MouseEvent e) {
        mouseDragCoords = e.getPoint();
    }

    public void mouseDragged(MouseEvent e) {
        Point currentCoords = e.getLocationOnScreen();
        frame.setLocation(currentCoords.x - mouseDragCoords.x, currentCoords.y - mouseDragCoords.y);
    }
}