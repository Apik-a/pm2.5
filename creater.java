import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class creater extends JFrame {

    JPanel createrMain = new JPanel(); // แพนแนลหลักสำหรับหัวข้อ "Creater"
    JPanel namePanel = new JPanel();  // แพนแนลใหม่สำหรับเก็บชื่อและรหัสนักศึกษา
    JButton goBackButton = new JButton("Go Back"); // ปุ่ม "Go Back" สำหรับกลับไปหน้าหลัก

    public creater() {
        setTitle("Creater"); // ตั้งชื่อหน้าต่าง
        setSize(1200, 750); // กำหนดขนาดของหน้าต่าง
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // ปิดหน้าต่างเมื่อกดปุ่มปิด
        setLocationRelativeTo(null); // จัดหน้าต่างให้อยู่กลางหน้าจอ
        setLayout(new BorderLayout());  // ใช้ BorderLayout เพื่อจัดวางแพนแนลต่างๆ

        // ตั้งค่าสีพื้นหลังให้มีลักษณะเป็น Gradient-like
        createrMain.setBackground(new Color(44, 62, 80)); // สีพื้นหลังเข้มสำหรับหัวข้อ
        namePanel.setBackground(new Color(52, 73, 94));   // สีพื้นหลังอ่อนลงเล็กน้อยสำหรับแพนแนลชื่อ

        // ตั้งค่า BoxLayout สำหรับ namePanel เพื่อให้ป้ายข้อความจัดเรียงในแนวตั้ง
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));

        // สร้าง JLabel สำหรับหัวข้อ "Creater"
        JLabel label = new JLabel("Creater", JLabel.CENTER);
        label.setForeground(new Color(236, 240, 241));  // กำหนดสีตัวอักษรเป็นสีเทาอ่อน
        label.setFont(new Font("Verdana", Font.BOLD, 90));  // ฟอนต์สมัยใหม่และขนาดใหญ่

        // สร้างป้ายข้อความสำหรับชื่อและรหัสนักศึกษาพร้อมทั้งกำหนดสไตล์
        JLabel name1 = new JLabel("1. Nititorn Thasana", JLabel.CENTER);
        name1.setForeground(new Color(189, 195, 199));  // กำหนดสีตัวอักษรเป็นสีเทาอ่อน
        name1.setFont(new Font("Verdana", Font.PLAIN, 50));  // ฟอนต์สมัยใหม่ขนาดกลาง

        JLabel sid1 = new JLabel("SID : 66011218402", JLabel.CENTER);
        sid1.setForeground(new Color(189, 195, 199)); // กำหนดสีตัวอักษรเป็นสีเทาอ่อน
        sid1.setFont(new Font("Verdana", Font.PLAIN, 50)); // ฟอนต์ขนาดกลาง

        JLabel name2 = new JLabel("2. Teerawit Khamseansuk", JLabel.CENTER);
        name2.setForeground(new Color(189, 195, 199)); // กำหนดสีตัวอักษรเป็นสีเทาอ่อน
        name2.setFont(new Font("Verdana", Font.PLAIN, 50)); // ฟอนต์ขนาดกลาง

        JLabel sid2 = new JLabel("SID : 66011218403", JLabel.CENTER);
        sid2.setForeground(new Color(189, 195, 199)); // กำหนดสีตัวอักษรเป็นสีเทาอ่อน
        sid2.setFont(new Font("Verdana", Font.PLAIN, 50)); // ฟอนต์ขนาดกลาง

        JLabel name3 = new JLabel("3. Patiphon Suwannamajo", JLabel.CENTER);
        name3.setForeground(new Color(189, 195, 199)); // กำหนดสีตัวอักษรเป็นสีเทาอ่อน
        name3.setFont(new Font("Verdana", Font.PLAIN, 50)); // ฟอนต์ขนาดกลาง

        JLabel sid3 = new JLabel("SID : 66011218405", JLabel.CENTER);
        sid3.setForeground(new Color(189, 195, 199)); // กำหนดสีตัวอักษรเป็นสีเทาอ่อน
        sid3.setFont(new Font("Verdana", Font.PLAIN, 50)); // ฟอนต์ขนาดกลาง

        // จัดกึ่งกลางป้ายข้อความภายใน namePanel
        name1.setAlignmentX(Component.CENTER_ALIGNMENT);
        sid1.setAlignmentX(Component.CENTER_ALIGNMENT);
        name2.setAlignmentX(Component.CENTER_ALIGNMENT);
        sid2.setAlignmentX(Component.CENTER_ALIGNMENT);
        name3.setAlignmentX(Component.CENTER_ALIGNMENT);
        sid3.setAlignmentX(Component.CENTER_ALIGNMENT);

        // เพิ่มป้ายข้อความลงใน namePanel พร้อมเว้นช่องว่าง
        namePanel.add(Box.createVerticalStrut(20));  // เพิ่มช่องว่างด้านบน
        namePanel.add(name1);
        namePanel.add(Box.createVerticalStrut(10));  // เพิ่มช่องว่างระหว่าง name1 และ sid1
        namePanel.add(sid1);
        namePanel.add(Box.createVerticalStrut(20));  // เพิ่มช่องว่างระหว่างชื่อแรกและชื่อที่สอง
        namePanel.add(name2);
        namePanel.add(Box.createVerticalStrut(10));  // เพิ่มช่องว่างระหว่าง name2 และ sid2
        namePanel.add(sid2);
        namePanel.add(Box.createVerticalStrut(20));  // เพิ่มช่องว่างระหว่างชื่อที่สองและชื่อที่สาม
        namePanel.add(name3);
        namePanel.add(Box.createVerticalStrut(10));  // เพิ่มช่องว่างระหว่าง name3 และ sid3
        namePanel.add(sid3);

        // จัดกึ่งกลางป้ายข้อความหัวข้อภายใน createrMain panel
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        createrMain.add(label);

        // ตั้งค่าปุ่ม "Go Back"
        goBackButton.setFont(new Font("Verdana", Font.BOLD, 30)); // ตั้งฟอนต์และขนาดของปุ่ม
        goBackButton.setBackground(new Color(41, 128, 185)); // ตั้งสีพื้นหลังของปุ่ม
        goBackButton.setForeground(Color.WHITE); // ตั้งสีตัวอักษรของปุ่มเป็นสีขาว
        goBackButton.setFocusPainted(false); // ปิดการแสดงกรอบโฟกัสเมื่อเลือกปุ่ม

        // เพิ่มตัวจัดการเหตุการณ์เมื่อกดปุ่ม "Go Back"
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame mainFrame = new MainFrame(); // เปิดหน้าต่างหลัก
                mainFrame.setVisible(true);
                dispose(); // ปิดหน้าต่างปัจจุบัน
            }
        });

        // เพิ่มส่วนประกอบต่างๆ ลงในหน้าต่างโปรแกรม
        add(createrMain, BorderLayout.NORTH); // เพิ่ม createrMain panel ในตำแหน่งด้านบน
        add(namePanel, BorderLayout.CENTER); // เพิ่ม namePanel ในตำแหน่งตรงกลาง
        add(goBackButton, BorderLayout.SOUTH); // เพิ่มปุ่ม "Go Back" ในตำแหน่งด้านล่าง
    }

    public static void main(String[] args) {
        creater mainCreater1 = new creater(); // สร้างหน้าต่าง "Creater"
        mainCreater1.setVisible(true); // แสดงหน้าต่าง
    }
}
