import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.Flow;

public class lab1_main {
    public static void main(String[] args) throws FileNotFoundException {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}

class MainFrame extends JFrame{
    JButton bnCon = new JButton("Continue");
    JButton bnCreater = new JButton("Creater");
    JButton bnExit = new JButton("Exit");
    JPanel subPanel = new JPanel(new GridLayout(3,0));
    JPanel mainPanel = new JPanel(new GridBagLayout());
    JPanel pnNorth = new JPanel(new BorderLayout());
    JPanel pnSouth = new JPanel(new BorderLayout());
    JPanel pnWest = new JPanel(new BorderLayout());
    JPanel pnEast = new JPanel(new BorderLayout());
    JLabel taTitle = new JLabel("PM2.5 Program", SwingConstants.CENTER);

    public MainFrame() {
        setSize(1500, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Main Program");
        mainPanel.setBackground(new Color(46,35,108));

        subPanel.add(bnCon);
        subPanel.add(bnCreater);
        subPanel.add(bnExit);
        
        subPanel.setPreferredSize(new Dimension(600,500));
        pnNorth.setPreferredSize(new Dimension(0,950));
        bnCreater.setFont(new Font("Roboto", Font.PLAIN, 150));
        bnCon.setFont(new Font("Roboto", Font.PLAIN, 135));
        bnExit.setFont(new Font("Roboto", Font.PLAIN, 150));

        bnCreater.setBackground(new Color(23,21,59));
        bnCon.setBackground(new Color(23,21,59));
        bnExit.setBackground(new Color(23,21,59));

        bnCreater.setForeground(new Color(255,255,255));
        bnCon.setForeground(new Color(255,255,255));
        bnExit.setForeground(new Color(255,255,255));


        pnNorth.setPreferredSize(new Dimension(40, 40));
        pnSouth.setPreferredSize(new Dimension(40, 40));
        pnEast.setPreferredSize(new Dimension(40, 100));
        pnWest.setPreferredSize(new Dimension(40, 100));

        pnEast.setBackground(new Color(67,61,139));
        pnWest.setBackground(new Color(67,61,139));
        pnNorth.setBackground(new Color(67,61,139));
        pnSouth.setBackground(new Color(67,61,139));

        taTitle.setFont(new Font("Roboto",Font.BOLD,150));
        taTitle.setForeground(new Color(255,255,255));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;  
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(10, 0, 10, 0);
        mainPanel.add(taTitle,gbc);

        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(subPanel, gbc);

        add(pnEast, BorderLayout.EAST);
        add(pnWest, BorderLayout.WEST);
        add(pnNorth, BorderLayout.NORTH);
        add(pnSouth, BorderLayout.SOUTH);
        add(mainPanel, BorderLayout.CENTER);

        bnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                setVisible(false);
            }
        });

        bnCon.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                lab1 myFrame = new lab1(MainFrame.this);
                myFrame.setVisible(true);
                dispose();
            }
            
        });

        addWindowListener(new WindowListener() {

            @Override
            public void windowActivated(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void windowClosed(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void windowClosing(WindowEvent e) {
                // TODO Auto-generated method stub
                setVisible(false);
                lab1 myFrame = new lab1(MainFrame.this);
                myFrame.setVisible(true);
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void windowIconified(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void windowOpened(WindowEvent e) {
                // TODO Auto-generated method stub
                
            }
            
        });
    }

}















