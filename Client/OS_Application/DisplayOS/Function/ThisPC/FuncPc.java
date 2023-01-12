package Client.OS_Application.DisplayOS.Function.ThisPC;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

/**
 *
 * @author supercoder
 */
public class FuncPc extends JFrame {

    private JMenu Files, Edit, View, Go, Bookmac, Help;
    private JMenuItem MenuClick;
    private JFrame frameMessErr;
    private Font fontMenu;

    public FuncPc() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 700);
        setBackground(Color.WHITE);
    }

    String[] names = {"File", "Edit", "View", "Go", "Bookmac", "Help"};

    String[] toolKit = {
        "File directory"
    };

    public JMenuBar menuFrame() {
        frameMessErr = new JFrame();
        fontMenu = new Font("Arial", Font.BOLD, 13);
        JMenuBar menuPC = new JMenuBar();
        menuPC.setBackground(new Color(255, 255, 255));
        try {
            Files = new JMenu(names[0]);
            Files.setFont(fontMenu);
            Files.setToolTipText(toolKit[0]);

            Edit = new JMenu(names[1]);
            Edit.setFont(fontMenu);

            View = new JMenu(names[2]);
            View.setFont(fontMenu);

            Go = new JMenu(names[3]);
            Go.setFont(fontMenu);

            Bookmac = new JMenu(names[4]);
            Bookmac.setFont(fontMenu);

            Help = new JMenu(names[5]);
            Help.setFont(fontMenu);
        } catch (ExceptionInInitializerError errMenu) {
            JOptionPane.showInputDialog(frameMessErr, "Error: 0x125883003", "fsdfsdfsdf");
            frameMessErr.setVisible(true);
        }
        menuPC.add(Files);
        menuPC.add(Edit);
        menuPC.add(View);
        menuPC.add(Go);
        menuPC.add(Bookmac);
        menuPC.add(Help);
        JPopupMenu popClick = new JPopupMenu();
        MenuClick = new JMenuItem("open");

        // Error MouseListener PopMenu
        popClick.add(MenuClick);
        JPanel panelClickMouse = new JPanel();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e) && e.getClickCount()== 1) {
                    popClick.show(panelClickMouse, e.getX(), e.getY());
                }
            }

        });
        panelClickMouse.add(popClick);
        add(panelClickMouse);
        return menuPC;
    }
;
}
