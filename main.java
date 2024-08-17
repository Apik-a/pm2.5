import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class main extends JFrame {
    private static final int GRID_WIDTH = 20; // ความกว้างของกริด
    private static final int GRID_HEIGHT = 10; // ความสูงของกริด
    private static final int MIN_DUST = 0; // ค่าฝุ่นต่ำสุด
    private static final int MAX_DUST = 250; // ค่าฝุ่นสูงสุด
    private int[][] dustLevels; // อาร์เรย์เก็บค่าระดับฝุ่นในแต่ละช่อง
    private JButton[][] buttons; // อาร์เรย์ของปุ่มในกริด
    private JTextArea statusArea; // พื้นที่แสดงสถานะ

    public main() {
        setTitle("ฝุ่น PM2.5"); // ตั้งชื่อหน้าต่าง
        setSize(1600, 800); // กำหนดขนาดหน้าต่าง
        setDefaultCloseOperation(EXIT_ON_CLOSE); // กำหนดการปิดโปรแกรมเมื่อกดปุ่มปิด
        setLayout(new BorderLayout()); // ใช้ BorderLayout ในการจัดวางองค์ประกอบ

        // จัดกึ่งกลางหน้าต่างบนหน้าจอ
        setLocationRelativeTo(null);

        // กำหนดค่าเริ่มต้นของระดับฝุ่น
        dustLevels = new int[GRID_WIDTH][GRID_HEIGHT];
        buttons = new JButton[GRID_WIDTH][GRID_HEIGHT];
        initializeDustLevels(); // เรียกใช้เมธอดเพื่อสุ่มค่าฝุ่น

        // สร้างแผงสำหรับกริด
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(GRID_HEIGHT, GRID_WIDTH)); // กำหนด layout แบบ Grid
        addGridButtons(gridPanel); // เพิ่มปุ่มลงในกริด

        // สร้างแผงสถานะ
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BorderLayout()); // กำหนด layout แบบ Border
        statusPanel.setPreferredSize(new Dimension(300, getHeight())); // กำหนดขนาดของแผง
        statusPanel.setBackground(new Color(46, 35, 108)); // ตั้งค่าสีพื้นหลังให้ตรงกับ MainFrame

        // สร้างพื้นที่แสดงสถานะ
        statusArea = new JTextArea();
        statusArea.setEditable(false); // ไม่อนุญาตให้แก้ไขข้อความในพื้นที่สถานะ
        statusArea.setFont(new Font("Roboto", Font.PLAIN, 16)); // กำหนดฟอนต์
        statusArea.setBackground(new Color(23, 21, 59)); // กำหนดสีพื้นหลัง
        statusArea.setForeground(Color.WHITE); // กำหนดสีของข้อความ
        statusPanel.add(new JScrollPane(statusArea), BorderLayout.CENTER); // เพิ่ม scroll pane ลงในแผงสถานะ

        // สร้างแผงควบคุม
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout()); // กำหนด layout แบบ Flow

        // สร้างปุ่มต่าง ๆ ในแผงควบคุม
        JButton cloudSeedingButton = new JButton("Cloud Seeding");
        controlPanel.add(cloudSeedingButton);
        JButton naturalRainingButton = new JButton("Natural Raining");
        controlPanel.add(naturalRainingButton);
        JButton goBack = new JButton("Go back");
        controlPanel.add(goBack);

        // เพิ่มองค์ประกอบลงในหน้าต่างหลัก
        add(statusPanel, BorderLayout.WEST); // เพิ่มแผงสถานะที่ด้านซ้าย
        add(gridPanel, BorderLayout.CENTER); // เพิ่มแผงกริดที่ตรงกลาง
        add(controlPanel, BorderLayout.SOUTH); // เพิ่มแผงควบคุมที่ด้านล่าง

        // กำหนดการทำงานของปุ่ม Cloud Seeding
        cloudSeedingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyCloudSeeding(); // เรียกใช้เมธอดลดฝุ่น
            }
        });

        // กำหนดการทำงานของปุ่ม Natural Raining
        naturalRainingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyNaturalRaining(); // เรียกใช้เมธอดลดฝุ่นด้วยฝนธรรมชาติ
            }
        });

        // กำหนดการทำงานของปุ่ม Go Back
        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goBackMenu(); // กลับไปที่เมนูหลัก
            }
        });
    }

    // เมธอดสุ่มค่าระดับฝุ่นในแต่ละช่องของกริด
    private void initializeDustLevels() {
        Random rand = new Random();
        for (int x = 0; x < GRID_WIDTH; x++) {
            for (int y = 0; y < GRID_HEIGHT; y++) {
                dustLevels[x][y] = rand.nextInt(MAX_DUST + 1); // สุ่มค่าฝุ่นในแต่ละช่อง
            }
        }
    }

    // เมธอดเพิ่มปุ่มในกริด
    private void addGridButtons(JPanel panel) {
        for (int x = 0; x < GRID_WIDTH; x++) {
            for (int y = 0; y < GRID_HEIGHT; y++) {
                JButton button = new JButton();
                updateButtonColor(button, dustLevels[x][y]); // ตั้งค่าสีของปุ่มตามระดับฝุ่น
                int finalX = x;
                int finalY = y;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleGridButtonClick(finalX, finalY); // กำหนดการทำงานเมื่อปุ่มถูกคลิก
                    }
                });
                buttons[x][y] = button;
                panel.add(button); // เพิ่มปุ่มลงในแผงกริด
            }
        }
    }

    // เมธอดเปลี่ยนสีของปุ่มตามระดับฝุ่น
    private void updateButtonColor(JButton button, int dustLevel) {
        if (dustLevel <= 50) {
            button.setBackground(Color.GREEN);
        } else if (dustLevel <= 100) {
            button.setBackground(Color.YELLOW);
        } else if (dustLevel <= 150) {
            button.setBackground(Color.ORANGE);
        } else {
            button.setBackground(Color.RED);
        }
    }

    // เมธอดทำงานเมื่อปุ่มในกริดถูกคลิก
    private void handleGridButtonClick(int x, int y) {
        buttons[x][y].setBackground(Color.BLUE); // เปลี่ยนสีปุ่มเมื่อถูกคลิก
        applyCloudSeedingForCell(x, y); // ใช้เมธอดลดฝุ่นในช่องที่คลิกและรอบๆ
    }

    // เมธอดลดฝุ่นในช่องที่ถูกคลิก
    private void applyCloudSeeding() {
        for (int x = 0; x < GRID_WIDTH; x++) {
            for (int y = 0; y < GRID_HEIGHT; y++) {
                if (buttons[x][y].getBackground() == Color.BLUE) {
                    applyCloudSeedingForCell(x, y); // ลดฝุ่นในช่องที่คลิก
                }
            }
        }
        refreshGrid(); // รีเฟรชกริดเพื่ออัปเดตสีของปุ่ม
        updateStatus("Applied Cloud Seeding"); // อัปเดตสถานะ
    }

    // เมธอดลดฝุ่นในช่องที่ถูกคลิกและรอบๆ
    private void applyCloudSeedingForCell(int x, int y) {
        if (x >= 0 && x < GRID_WIDTH && y >= 0 && y < GRID_HEIGHT) {
            int originalDustLevel = dustLevels[x][y]; // เก็บค่าระดับฝุ่นเดิมของช่องที่คลิก

            dustLevels[x][y] = Math.max(MIN_DUST, dustLevels[x][y] - (int) (0.5 * originalDustLevel)); // ลดฝุ่นในช่องที่คลิก 50%

            // ลดฝุ่นในช่องรอบๆ 30% ของระดับฝุ่นเดิมในช่องที่คลิก
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (dx != 0 || dy != 0) { // ไม่รวมช่องที่คลิกเอง
                        int nx = x + dx;
                        int ny = y + dy;
                        if (nx >= 0 && nx < GRID_WIDTH && ny >= 0 && ny < GRID_HEIGHT) {
                            dustLevels[nx][ny] = Math.max(MIN_DUST, dustLevels[nx][ny] - (int) (0.3 * originalDustLevel));
                        }
                    }
                }
            }
        }
    }

    // เมธอดลดฝุ่นทั่วทั้งกริดด้วยฝนธรรมชาติ
    private void applyNaturalRaining() {
        for (int x = 0; x < GRID_WIDTH; x++) {
            for (int y = 0; y < GRID_HEIGHT; y++) {
                dustLevels[x][y] = Math.max(MIN_DUST, dustLevels[x][y] - 50); // ลดฝุ่นในทุกช่องลง 50 หน่วย
            }
        }
        refreshGrid(); // รีเฟรชกริดเพื่ออัปเดตสีของปุ่ม
        updateStatus("Applied Natural Raining"); // อัปเดตสถานะ
    }

    // เมธอดรีเฟรชกริดเพื่ออัปเดตสีของปุ่มตามระดับฝุ่นใหม่
    private void refreshGrid() {
        for (int x = 0; x < GRID_WIDTH; x++) {
            for (int y = 0; y < GRID_HEIGHT; y++) {
                updateButtonColor(buttons[x][y], dustLevels[x][y]); // อัปเดตสีปุ่มตามค่าฝุ่นใหม่
            }
        }
    }

    // เมธอดอัปเดตสถานะในพื้นที่แสดงสถานะ
    private void updateStatus(String message) {
        statusArea.append(message + "\n"); // เพิ่มข้อความใหม่ในพื้นที่สถานะ
    }

    // เมธอดกลับไปที่เมนูหลัก
    private void goBackMenu() {
        dispose(); // ปิดหน้าต่างปัจจุบัน
        MainFrame mainFrame = new MainFrame(); // สร้างหน้าต่างเมนูหลักใหม่
        mainFrame.setVisible(true); // แสดงหน้าต่างเมนูหลัก
    }

    // เมธอดหลักที่เริ่มต้นโปรแกรม
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new main().setVisible(true); // สร้างและแสดงหน้าต่างหลัก
            }
        });
    }
}
