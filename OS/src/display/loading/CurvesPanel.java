package display.loading;

import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class CurvesPanel {

    private RenderingHints hints;
    private int counter = 0;
    private Timer timer = new Timer(20, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
        }
    });

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public CurvesPanel() {

    }
}
