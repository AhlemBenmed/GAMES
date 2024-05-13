import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import  java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends JFrame {
    public static final Color FRAME_COLOR = Color.decode("#000814");
    public static final Color TEXT_COLOR = Color.WHITE;
    
    public Menu() {
        super("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 800);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(false);
        getContentPane().setBackground(FRAME_COLOR);
        addGUIComponent();
    }

    private void addGUIComponent() {
        JLabel img = new JLabel(loadImage("src/assets/2.jpg"));
        img.setBounds(0, 20, getWidth() - 30, 200);
        add(img);
        JButton RPS = new JButton("Rock Paper Scissor Game");
        RPS.setFont(new Font("Dialog", Font.BOLD, 18));
        RPS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        RPS.setBackground(Color.WHITE);
        RPS.setForeground(new Color(255, 171, 63));  
        RPS.setBounds(60, 310, 360, 50);
        RPS.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked( MouseEvent e) {
                dispose();
                new RockPaperScissorGUI().setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                RPS.setForeground(new Color(255, 171, 63));
            }
            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}
        });
        JButton HG = new JButton("HangMan Game");
        HG.setFont(new Font("Dialog", Font.BOLD, 18));
        HG.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        HG.setBackground(Color.WHITE);
        HG.setForeground(new Color(255, 171, 63));
        HG.setBounds(60, 240, 360, 50);
        HG.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                
                new Hangman().setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                RPS.setForeground(new Color(255, 171, 63));
            }

             
            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}
        });
        JButton TIC= new JButton("TicTacToe Game");
        TIC.setFont(new Font("Dialog", Font.BOLD, 18));
        TIC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        TIC.setBackground(Color.WHITE);
        TIC.setForeground(new Color(255, 171, 63));  
        TIC.setBounds(60, 380, 360, 50);
        TIC.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                
                new TicTacToeGui().setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                RPS.setForeground(new Color(255, 171, 63));
            }

             
            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}
        });
        JButton Cookie = new JButton("Cookie Clicker Anti-Stress Game");
        Cookie.setFont(new Font("Dialog", Font.BOLD, 18));
        Cookie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Cookie.setBackground(Color.WHITE);
        Cookie.setForeground(new Color(255, 171, 63));  
        Cookie.setBounds(60, 520, 360, 50);
        Cookie.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                
                new CookieClicker().setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                RPS.setForeground(new Color(255, 171, 63));
            }

             
            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}
        });
        JButton Paint = new JButton("Paint Application");
        Paint.setFont(new Font("Dialog", Font.BOLD, 18));
        Paint.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Paint.setBackground(Color.WHITE);
        Paint.setForeground(new Color(255, 171, 63));  
        Paint.setBounds(60, 590, 360, 50);
        Paint.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                
                new PaintGui().setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                RPS.setForeground(new Color(255, 171, 63));
            }

             
            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}
        });
        JButton Music = new JButton("MP3 Music Player APP");
        Music.setFont(new Font("Dialog", Font.BOLD, 18));
        Music.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Music.setBackground(Color.WHITE);
        Music.setForeground(new Color(255, 171, 63));  
        Music.setBounds(60, 450, 360, 50);
        Music.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                
                new MusicPlayerGUI().setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                RPS.setForeground(new Color(255, 171, 63));
            }

             
            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}
        });
        JButton Notep = new JButton("Notepad text editor");
        Notep.setFont(new Font("Dialog", Font.BOLD, 18));
        Notep.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Notep.setBackground(Color.WHITE);
        Notep.setForeground(new Color(255, 171, 63));  
        Notep.setBounds(60, 660, 360, 50);
        Notep.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                
                new NotepadGUI().setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                RPS.setForeground(new Color(255, 171, 63));
            }

             
            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}
        });
        JLabel registerLabel = new JLabel("Want to Log out? Click Here!");
        Paint.setFont(new Font("Dialog", Font.BOLD, 18));
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.setForeground(CommonConstants.SECONDARY_COLOR);
        registerLabel.setBounds(60, 705, 360, 50);
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new LoginFormGUI().setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                registerLabel.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                registerLabel.setForeground(CommonConstants.SECONDARY_COLOR);
            }
        });
        add(TIC);
        add(Notep);
        add(Music);
        add(Paint);
        add(Cookie);
        add(HG);
        add(RPS);
        add(registerLabel);
    }

    private ImageIcon loadImage(String imagePath) {
        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            return new ImageIcon(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
