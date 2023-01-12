package resourceOS;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author supercoder
 */
public class Shutdown extends JFrame{
    final Icon shutdownClickOS = new ImageIcon("/home/supercoder/NetBeansProjects/Test/MainTest/src/Assets/pictureImage/Shutdown.gif");
    public Shutdown(){
        JLabel labelShutdown = new JLabel(shutdownClickOS);
        labelShutdown.setBounds(610,590,100,100);
        
        getContentPane().add(labelShutdown);
        setUndecorated(true);
        setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);
    }
}
