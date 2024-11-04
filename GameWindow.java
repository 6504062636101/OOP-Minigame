package com.mycompany.gameproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GameWindow extends JPanel {

    private Image backgroundImage;
    private JButton startButton;
    private JLabel gameNameLabel;

    public GameWindow() {
        backgroundImage = new ImageIcon("E:\\GameProject\\src\\main\\java\\com\\mycompany\\gameproject\\origbig.png").getImage();

        // โหลดฟอนต์ Press Start 2P
        Font customFont = null;
        try {
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("E:\\GameProject\\src\\main\\java\\com\\mycompany\\gameproject\\fonts\\PressStart2P.ttf")).deriveFont(36f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // สร้างฟอนต์ใหม่สำหรับปุ่ม
        Font buttonFont = null;
        try {
            buttonFont = Font.createFont(Font.TRUETYPE_FONT, new File("E:\\GameProject\\src\\main\\java\\com\\mycompany\\gameproject\\fonts\\PressStart2P.ttf")).deriveFont(24f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(buttonFont);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // สร้างปุ่มเริ่มเกม
        startButton = new JButton("Start Game");
        int buttonWidth = 300;
        int buttonHeight = 80;
        startButton.setFont(buttonFont); // ใช้ฟอนต์ใหม่สำหรับปุ่ม

        int buttonX = (800 - buttonWidth) / 2;
        int buttonY = (600 - buttonHeight) / 2 + 70;

        startButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Game Started!");
            }
        });

        // สร้าง JLabel สำหรับชื่อเกม
        gameNameLabel = new JLabel("DragonNest", SwingConstants.CENTER);
        int labelWidth = 640;
        int labelHeight = 150;

        int labelX = (800 - labelWidth) / 2;
        int labelY = (600 - labelHeight) / 2 - 20;

        gameNameLabel.setBounds(labelX, labelY, labelWidth, labelHeight);
        gameNameLabel.setForeground(Color.WHITE);
        gameNameLabel.setFont(customFont); // ใช้ฟอนต์ที่โหลดมา

        setLayout(null);
        add(startButton);
        add(gameNameLabel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Game");
        GameWindow gameWindow = new GameWindow();

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gameWindow);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
