import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}

class MainFrame extends JFrame {
    JButton bnCon = new JButton("Continue"); // ปุ่ม "Continue"
    JButton bnCreater = new JButton("Creater"); // ปุ่ม "Creater"
    JButton bnExit = new JButton("Exit"); // ปุ่ม "Exit"
    JPanel subPanel = new JPanel(new GridLayout(3, 1)); // แพนแนลสำหรับวางปุ่ม
    JPanel mainPanel = new JPanel(new GridBagLayout()); // แพนแนลหลักของโปรแกรม
    JPanel pnNorth = new JPanel(new BorderLayout()); // แพนแนลด้านบน
    JPanel pnSouth = new JPanel(new BorderLayout()); // แพนแนลด้านล่าง
    JPanel pnWest = new JPanel(new BorderLayout()); // แพนแนลด้านซ้าย
    JPanel pnEast = new JPanel(new BorderLayout()); // แพนแนลด้านขวา
    JLabel taTitle = new JLabel("PM2.5 Program", SwingConstants.CENTER); // ป้ายข้อความหัวเรื่องของโปรแกรม

    public MainFrame() {
        setSize(1200, 800); // กำหนดขนาดของหน้าต่างโปรแกรม
        setDefaultCloseOperation(EXIT_ON_CLOSE); // ปิดโปรแกรมเมื่อกดปุ่มปิด
        setLocationRelativeTo(null); // จัดหน้าต่างให้อยู่กลางหน้าจอ
        setTitle("Main Program"); // กำหนดชื่อของโปรแกรม
        mainPanel.setBackground(new Color(46, 35, 108)); // ตั้งค่าสีพื้นหลังของแพนแนลหลักเป็นสีม่วงเข้ม

        // กำหนดฟอนต์และสีของปุ่มให้เหมือนกัน
        bnCon.setFont(new Font("Roboto", Font.PLAIN, 100));
        bnCreater.setFont(new Font("Roboto", Font.PLAIN, 100));
        bnExit.setFont(new Font("Roboto", Font.PLAIN, 100));

        bnCon.setBackground(new Color(23, 21, 59)); // กำหนดสีพื้นหลังเป็นสีน้ำเงินเข้ม
        bnCreater.setBackground(new Color(23, 21, 59)); // กำหนดสีพื้นหลังเป็นสีน้ำเงินเข้ม
        bnExit.setBackground(new Color(23, 21, 59)); // กำหนดสีพื้นหลังเป็นสีน้ำเงินเข้ม

        bnCon.setForeground(Color.WHITE); // กำหนดสีตัวอักษรของปุ่มเป็นสีขาว
        bnCreater.setForeground(Color.WHITE); // กำหนดสีตัวอักษรของปุ่มเป็นสีขาว
        bnExit.setForeground(Color.WHITE); // กำหนดสีตัวอักษรของปุ่มเป็นสีขาว

        // ตั้งค่าการวางตำแหน่งและขนาดของแพนแนลต่างๆ
        subPanel.add(bnCon); // เพิ่มปุ่ม "Continue" ลงในแพนแนล
        subPanel.add(bnCreater); // เพิ่มปุ่ม "Creater" ลงในแพนแนล
        subPanel.add(bnExit); // เพิ่มปุ่ม "Exit" ลงในแพนแนล
        subPanel.setPreferredSize(new Dimension(600, 300)); // กำหนดขนาดของแพนแนล

        pnNorth.setPreferredSize(new Dimension(0, 60)); // กำหนดขนาดของแพนแนลด้านบน
        pnSouth.setPreferredSize(new Dimension(0, 60)); // กำหนดขนาดของแพนแนลด้านล่าง
        pnEast.setPreferredSize(new Dimension(60, 0)); // กำหนดขนาดของแพนแนลด้านขวา
        pnWest.setPreferredSize(new Dimension(60, 0)); // กำหนดขนาดของแพนแนลด้านซ้าย

        // ตั้งค่าการวางตำแหน่งและสีพื้นหลังของแพนแนลข้างๆ
        pnEast.setBackground(new Color(67, 61, 139)); // กำหนดสีพื้นหลังของแพนแนลด้านขวา
        pnWest.setBackground(new Color(67, 61, 139)); // กำหนดสีพื้นหลังของแพนแนลด้านซ้าย
        pnNorth.setBackground(new Color(67, 61, 139)); // กำหนดสีพื้นหลังของแพนแนลด้านบน
        pnSouth.setBackground(new Color(67, 61, 139)); // กำหนดสีพื้นหลังของแพนแนลด้านล่าง

        taTitle.setFont(new Font("Roboto", Font.BOLD, 100)); // ตั้งค่าฟอนต์ของป้ายข้อความหัวเรื่อง
        taTitle.setForeground(new Color(255, 255, 255)); // กำหนดสีตัวอักษรของป้ายข้อความหัวเรื่องเป็นสีขาว

        GridBagConstraints gbc = new GridBagConstraints(); // กำหนดข้อจำกัดในการวางตำแหน่ง
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH; // จัดวางป้ายข้อความหัวเรื่องให้อยู่ด้านบน
        gbc.insets = new Insets(20, 0, 20, 0); // กำหนดขอบของป้ายข้อความหัวเรื่อง
        mainPanel.add(taTitle, gbc); // เพิ่มป้ายข้อความหัวเรื่องลงในแพนแนลหลัก

        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER; // จัดวางแพนแนลปุ่มให้อยู่ตรงกลาง
        mainPanel.add(subPanel, gbc); // เพิ่มแพนแนลปุ่มลงในแพนแนลหลัก

        // เพิ่มส่วนประกอบต่างๆ ลงในหน้าต่างโปรแกรม
        add(pnEast, BorderLayout.EAST);
        add(pnWest, BorderLayout.WEST);
        add(pnNorth, BorderLayout.NORTH);
        add(pnSouth, BorderLayout.SOUTH);
        add(mainPanel, BorderLayout.CENTER);

        // ตัวจัดการเหตุการณ์เมื่อกดปุ่ม "Exit"
        bnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // ซ่อนหน้าต่างโปรแกรม
                dispose(); // ปิดโปรแกรม
            }
        });

        // ตัวจัดการเหตุการณ์เมื่อกดปุ่ม "Continue"
        bnCon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main programFrame = new main(); // เปิดหน้าต่างโปรแกรมหลัก
                programFrame.setVisible(true);
                dispose(); // ปิดหน้าต่างปัจจุบัน
            }
        });

        // ตัวจัดการเหตุการณ์เมื่อกดปุ่ม "Creater"
        bnCreater.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // ปิดหน้าต่างปัจจุบัน
                creater createrFrame = new creater(); // เปิดหน้าต่างผู้สร้าง
                createrFrame.setVisible(true);
            }
        });
    }
}
