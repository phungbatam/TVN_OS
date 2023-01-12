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
public class Loading extends JFrame{
    Icon iconLoadingWindow = new ImageIcon("/home/supercoder/NetBeansProjects/Test/MainTest/src/Assets/pictureImage/Loading.gif");
    
    private JLabel labelOS = new JLabel();
    
    public Loading() {
        JLabel labelWindowLoading = new JLabel(iconLoadingWindow);
        labelWindowLoading.setBounds(610,590,100,100);
      
        getContentPane().add(labelWindowLoading);
        
        setUndecorated(true);
        setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);
    }
}
