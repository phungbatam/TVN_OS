package Client.OS_Application.DisplayOS.ApplicationFrom;

import Client.RunOs.Features.FrameDragListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author supercoder
 */
public class ApplicationOS extends JFrame {

    FrameDragListener frameDrag = new FrameDragListener(this);

    Icon iconCloseApp = new ImageIcon("/home/supercoder/NetBeansProjects/Test/MainTest/src/Assets/pictureImage/closeApp.png");
    
    private static JButton closeApp;

    public ApplicationOS() {

        JPanel panelBackgrond = new JPanel();
        panelBackgrond.setBounds(0, 0, 1120, 24);
        panelBackgrond.setOpaque(true);
        panelBackgrond.setBackground(Color.black);
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1000, 500);
        dispose();
        add(panelBackgrond);

        closeApp = new JButton(iconCloseApp);
        closeApp.setBounds(977, 0, 24, 24);
        closeApp.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
            }

            private void close() {
                dispose();
            }
            
        });
        add(closeApp);
        addMouseListener(frameDrag);
        addMouseMotionListener(frameDrag);
        setVisible(true);

    }

    public static void main(String[] args) {
        new ApplicationOS();
    }
}
