package Client.OS_Application.DisplayOS;

import Client.OS_Application.Apps.FuncSetting.Other_Setting.Manage_Setting;
import Client.OS_Application.Apps.TaskBar.taskBarBottom;
import Client.OS_Application.DisplayOS.Function.ThisPC.RunnerThisPcOS;
import com.bennavetta.jconsole.DemoConsole;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

/**
 *
 * @author supercoder OS System
 */
public class Display extends JFrame implements MouseListener, MouseMotionListener{

    final Icon pcIconDeskTop = new ImageIcon("/home/supercoder/NetBeansProjects/Test/MainTest/src/Assets/pictureImage/pcIconDesktop.png");
    final Icon folderIconDeskTop = new ImageIcon("/home/supercoder/NetBeansProjects/Test/MainTest/src/Assets/pictureImage/folderDeskTop.png");
    final Icon recycleBinDeskTop = new ImageIcon("/home/supercoder/NetBeansProjects/Test/MainTest/src/Assets/pictureImage/dustbinDeskTop.png");
    final Icon terminalIcon = new ImageIcon("/home/supercoder/NetBeansProjects/Test/MainTest/src/Assets/pictureImage/terminalIcon.png");
    final Icon iconSecurity = new ImageIcon("/home/supercoder/NetBeansProjects/Test/MainTest/src/Assets/pictureImage/securityImage.png");
    final Icon iconDeskTop = new ImageIcon("/home/supercoder/NetBeansProjects/Test/MainTest/src/Assets/pictureImage/Clover.jpg");
    private Random randAll = new Random();
    final int systemRandl = randAll.nextInt(100) + (1000) / 2;
    private JMenu ApplicationMenu, PlacesOS, System;
    private JMenuItem SecurityItem, programmingOSJava, libExcel, libWord;
    private JMenuItem terminalDisrect;
    private JMenuItem optionSetting, optionFolder,Othersetting;
    private JMenu Programming, Security, Office, systemTools;
    private Font fontTextApp, fontSubMenuItem;

    private JButton btnIconDeskTop, folIconDeskTop, btnRecycleBinDeskTop;
    private JLabel labelBtnIconPCDeskTop, labelBtnIconfolder, labelRecycleBinDeskTop;

    private JMenuItem clickCreateFolder, openTerminal, changeBackground;
    private Point startPonit;
    taskBarBottom taskBottom;

    public Display() {

        taskBottom = new taskBarBottom();
        taskBottom.setAlwaysOnTop(true);

        Border emtyBorder = BorderFactory.createEmptyBorder();

        JLabel labelImage = new JLabel(iconDeskTop);
        labelImage.setBounds(0, -500, 1600, 1600);

        this.getContentPane().add(labelImage);

        setUndecorated(true);
        this.setJMenuBar(MenuDisplay());
        setExtendedState(this.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("/home/supercoder/NetBeansProjects/Test/MainTest/src/Assets/pictureImage/MouseCursor.png");
        Point hotspot = new Point(0, 0);
        Cursor cursor = toolkit.createCustomCursor(image, hotspot, "pencil");
        setCursor(cursor);

        labelBtnIconPCDeskTop = new JLabel("PC");
        btnIconDeskTop = new JButton(pcIconDeskTop);
        btnIconDeskTop.setToolTipText("");
        btnIconDeskTop.setBounds(25, 25, 64, 64);
        btnIconDeskTop.setBackground(new Color(255, 255, 255, 1));
        btnIconDeskTop.setFocusable(true);
        btnIconDeskTop.setFocusPainted(false);
        btnIconDeskTop.setBorder(emtyBorder);
        btnIconDeskTop.addMouseListener(this);
        btnIconDeskTop.addMouseMotionListener(this);
        btnIconDeskTop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random randIconBtn = new Random();
                int loadingRandom = (int) (randIconBtn.nextInt(1000) + (Math.sin(10)) + 1000);
                try {
                    Thread.sleep(loadingRandom);
                    RunnerThisPcOS runPCOS = new RunnerThisPcOS();
                    runPCOS.setVisible(true);
                } catch (Exception ex) {

                }

            }
        });
        btnIconDeskTop.revalidate();
        btnIconDeskTop.repaint();
        btnIconDeskTop.add(labelBtnIconPCDeskTop);

        labelBtnIconfolder = new JLabel("Super coder");
        folIconDeskTop = new JButton(folderIconDeskTop);
        folIconDeskTop.setToolTipText("");
        folIconDeskTop.setBounds(25, 120, 64, 64);
        folIconDeskTop.setBackground(new Color(255, 255, 255, 1));
        folIconDeskTop.setFocusable(true);
        folIconDeskTop.setFocusPainted(false);
        folIconDeskTop.setBorder(emtyBorder);
        folIconDeskTop.add(labelBtnIconfolder);

        labelRecycleBinDeskTop = new JLabel("Recycle Bin");
        btnRecycleBinDeskTop = new JButton(recycleBinDeskTop);
        btnRecycleBinDeskTop.setToolTipText("");
        btnRecycleBinDeskTop.setBounds(25, 210, 64, 64);
        btnRecycleBinDeskTop.setBackground(new Color(255, 255, 255, 1));
        btnRecycleBinDeskTop.setFocusable(true);
        btnRecycleBinDeskTop.setFocusPainted(false);
        btnRecycleBinDeskTop.setBorder(emtyBorder);
        btnRecycleBinDeskTop.add(labelBtnIconfolder);

        add(folIconDeskTop);
        add(btnIconDeskTop);
        add(btnRecycleBinDeskTop);

        JPopupMenu clickPopDisplay = new JPopupMenu();
        clickCreateFolder = new JMenuItem();
        clickCreateFolder.setText("Create Folder\n          ");
        clickCreateFolder.setBackground(Color.WHITE);

        openTerminal = new JMenuItem();
        openTerminal.setText("Open Terminal\n           ");
        openTerminal.setBackground(Color.WHITE);
        
        changeBackground = new JMenuItem();
        changeBackground.setText("Change Background Focus       ");
        changeBackground.setBackground(Color.WHITE);

        clickPopDisplay.add(clickCreateFolder);
        clickPopDisplay.add(openTerminal);
        clickPopDisplay.add(changeBackground);
        JPanel panelClickMouseDisplay = new JPanel();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) {
                    clickPopDisplay.show(panelClickMouseDisplay, e.getX(), e.getY());
                }
            }

        });

        panelClickMouseDisplay.add(clickPopDisplay);
        add(panelClickMouseDisplay);
        setLayout(null);
        setVisible(true);
    }

    public JMenuBar MenuDisplay() {
        fontTextApp = new Font("Arial", Font.PLAIN, 15);
        JMenuBar dispBarMenu = new JMenuBar();
        dispBarMenu.setBackground(new Color(108, 122, 137));
        ApplicationMenu = new JMenu("Application");

        ApplicationMenu.setForeground(Color.WHITE);
        ApplicationMenu.setFont(fontTextApp);
        ApplicationMenu.setToolTipText("Browse and run installs applications");

        fontSubMenuItem = new Font("Arial", Font.ROMAN_BASELINE, 15);
        Security = new JMenu("\tSecurity           " );
        Security.setFont(fontTextApp);
        Security.setOpaque(true);
        Security.setToolTipText("Application Security");
        Security.setBackground(new Color(0xffffff));

        SecurityItem = new JMenuItem("Security      ",iconSecurity);
        SecurityItem.setToolTipText("");
        SecurityItem.setFont(fontSubMenuItem);
        SecurityItem.setBackground(Color.WHITE);

        systemTools = new JMenu("System Tools");
        systemTools.setFont(fontTextApp);
        systemTools.setToolTipText("System Tools");
        systemTools.setOpaque(true);
        systemTools.setBackground(Color.WHITE);

        Office = new JMenu("\tOffice");
        Office.setFont(fontSubMenuItem);
        Office.setToolTipText("Office");
        Office.setOpaque(true);
        Office.setBackground(new Color(0xffffff));

        libExcel = new JMenuItem("libre Excel");
        libExcel.setToolTipText("");
        libExcel.setFont(fontSubMenuItem);
        libExcel.setBackground(Color.WHITE);

        libWord = new JMenuItem("libre Word");
        libWord.setToolTipText("");
        libWord.setFont(fontTextApp);
        libWord.setBackground(Color.WHITE);

        Programming = new JMenu("Programming");
        Programming.setToolTipText("Application Programming super");
        Programming.setFont(fontTextApp);
        Programming.setOpaque(true);
        Programming.setBackground(new Color(0xffffff));

        programmingOSJava = new JMenuItem("\t Programming Java vs code    ");
        programmingOSJava.setToolTipText("Java Program");
        programmingOSJava.setFont(fontTextApp);
        programmingOSJava.setBackground(Color.WHITE);

        Othersetting = new JMenuItem("\tOther Setting OS");
        Othersetting.setToolTipText("Setting");
        Othersetting.setFont(fontTextApp);
        Othersetting.setBackground(Color.WHITE);
        Othersetting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Manage_Setting settingMange = new Manage_Setting();
                settingMange.setVisible(true);
            }

        });
        ApplicationMenu.add(Security);
        ApplicationMenu.add(systemTools);
        ApplicationMenu.add(Office);
        ApplicationMenu.add(Programming);

        Security.add(SecurityItem);
        Office.add(libExcel);
        Office.add(libWord);
        Programming.add(programmingOSJava);
        ApplicationMenu.add(Othersetting);
        /**
         * @Infomation MenuTask
         */
        PlacesOS = new JMenu("Places");
        PlacesOS.setForeground(Color.WHITE);
        PlacesOS.setFont(fontTextApp);
        PlacesOS.setToolTipText("Acces docs, folders and network places");

        terminalDisrect = new JMenuItem("Terminal", terminalIcon);
        terminalDisrect.setToolTipText("MATE Terminal Use the command line");
        terminalDisrect.setBackground(Color.WHITE);
        terminalDisrect.setFont(fontTextApp);
        terminalDisrect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
               if(e.getSource() == terminalDisrect){
                    dispose();
                    DemoConsole console = new DemoConsole();
               }
                
            }

        });

        PlacesOS.add(terminalDisrect);

        System = new JMenu("System");
        System.setForeground(Color.WHITE);
        System.setFont(fontTextApp);
        System.setToolTipText("Change desktop appearance and behavior, get help, or log out");

        optionSetting = new JMenuItem("Option System");
        optionSetting.setToolTipText("Setting Option Panel");
        optionSetting.setBackground(Color.WHITE);
        optionSetting.setFont(fontTextApp);
        optionSetting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }

        });

        System.add(optionSetting);

        optionFolder = new JMenuItem("Option Folder");
        optionFolder.setToolTipText("Setting Option Panel");
        optionFolder.setBackground(Color.WHITE);
        optionFolder.setFont(fontTextApp);
        optionFolder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }

        });

        System.add(optionFolder);

        dispBarMenu.add(ApplicationMenu);
        dispBarMenu.add(PlacesOS);
        dispBarMenu.add(System);

        return dispBarMenu;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPonit = SwingUtilities.convertPoint(btnIconDeskTop, e.getPoint(), btnIconDeskTop.getParent());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        startPonit = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point localtion = SwingUtilities.convertPoint(btnIconDeskTop, e.getPoint(), btnIconDeskTop.getParent());
        if(btnIconDeskTop.getParent().getBounds().contains(localtion)){
            Point newLocaltion = btnIconDeskTop.getLocation();
            newLocaltion.translate(localtion.x - startPonit.x,localtion.y - startPonit.y);
            newLocaltion.x = Math.max(newLocaltion.x,0);
            newLocaltion.y = Math.max(newLocaltion.y, 0);
            newLocaltion.x = Math.min(newLocaltion.x,btnIconDeskTop.getParent().getWidth() - btnIconDeskTop.getWidth());
            newLocaltion.y = Math.min(newLocaltion.y,btnIconDeskTop.getParent().getHeight() - btnIconDeskTop.getHeight()); 
            btnIconDeskTop.setLocation(newLocaltion);
            startPonit = localtion;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
