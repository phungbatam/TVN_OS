package Client.OS_Application.Apps.TaskBar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author supercoder
 */
public class showBlockBar extends JFrame {

    private static boolean canShutdown = true;

    private static JButton btnExit;

    Icon iconBtnShutdown = new ImageIcon("/home/supercoder/NetBeansProjects/Test/MainTest/src/Assets/pictureImage/TaskBottomIamge/shutdownBtn.png");

    public showBlockBar() {
        getContentPane().setBackground(new Color(0x2E3033));
        setBounds(0, 225, 700, 500);
        setUndecorated(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btnExit = new JButton(iconBtnShutdown);
        btnExit.setBackground(new Color(108, 122, 137, 4));
        btnExit.setBorder(BorderFactory.createEmptyBorder());
        btnExit.setBounds(280, 477, 80, 24);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random randShutdown = new Random();
                final int shutOff = randShutdown.nextInt(1000) + 100 / 2;
                try {
                    Thread.sleep(shutOff);
                    System.exit(0);
                } catch (InterruptedException io) {
                    io.printStackTrace();
                }
                dispose();
            }

        });
        add(btnExit);
        setLayout(null);
    }
}
