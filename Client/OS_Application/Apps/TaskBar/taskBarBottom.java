package Client.OS_Application.Apps.TaskBar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author supercoder
 */
public class taskBarBottom extends JFrame {
    
    private Icon menuPanel = new ImageIcon("/home/supercoder/NetBeansProjects/Test/MainTest/src/Assets/pictureImage/blockchain.png");
    
    public taskBarBottom() {
        
        Font fontBtn = new Font("Arial", Font.PLAIN, 14);
        
        JPanel labelTaskBar = new JPanel();
        labelTaskBar.setBounds(0, 1000, 20000, 25);
        labelTaskBar.setOpaque(true);
        labelTaskBar.setBackground(Color.WHITE);
        
        JButton btnTaskBar = new JButton("Menu", menuPanel);
        btnTaskBar.setToolTipText("Menu toolKit");
        btnTaskBar.setFont(fontBtn);
        btnTaskBar.setBounds(0, 0, 80, 25);
        btnTaskBar.setBackground(new Color(255, 255, 255));
        btnTaskBar.setFocusable(true);
        btnTaskBar.setFocusPainted(false);
        btnTaskBar.setBorder(BorderFactory.createEmptyBorder());
        btnTaskBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showBlockBar Bar = new showBlockBar();
                Bar.setVisible(true);
            }
            
        });
        
        add(labelTaskBar);
        add(btnTaskBar);
        setLayout(null);
        setUndecorated(true);
        setBounds(0, 1000, 20000, 25);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new taskBarBottom();
    }
}
