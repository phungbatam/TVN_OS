package Client.OS_Application.DisplayOS.Function.ThisPC;

import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

/**
 *
 * @author supercoder
 */
public class RunnerThisPcOS extends FuncPc {

    public RunnerThisPcOS() {
        getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.updateComponentTreeUI(this);
        setJMenuBar(menuFrame());
        setLocationRelativeTo(null);
        setUndecorated(true);
        setLayout(null);
    }

}
