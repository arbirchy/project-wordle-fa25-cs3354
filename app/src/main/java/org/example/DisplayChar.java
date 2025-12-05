package app.src.main.java.org.example;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class DisplayChar extends JLabel implements KeyListener {
    private char value = 0;

    public DisplayChar() {
        super();
        super.setOpaque(true);
        super.setBackground(Color.DARK_GRAY);
        super.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        super.setFocusable(true);
        super.addKeyListener(this);
        super.setFocusTraversalKeysEnabled(false);
        super.setVerticalAlignment(JLabel.CENTER);
        super.setHorizontalAlignment(JLabel.CENTER);
        super.setForeground(Color.WHITE);
    }

    // KeyListener functions
    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed");
    }
    public void keyReleased(KeyEvent e) {
        System.out.println("Key released");
    }
    public void keyTyped(KeyEvent e) {
        setLetter(e);
    }

    public void setFullySolved() {
        super.setForeground(Color.WHITE);
        super.setBackground(Color.GREEN);
    }
    public void setPartiallySolved() {
        super.setForeground(Color.WHITE);
        super.setBackground(Color.ORANGE);
    }
    public void setBlankFocused() {
        super.setForeground(Color.WHITE);
        super.setBackground(Color.GRAY);
    }
    public void setBlankUnfocused() {
        super.setForeground(Color.WHITE);
        super.setBackground(Color.DARK_GRAY);
    }
    public void setLetter(KeyEvent e) {
        char temp = e.getKeyChar();
        if(temp >= 'a' && temp <= 'z') {
            value = Character.toUpperCase(temp);
        } else if(temp >= 'A' && temp <= 'Z') {
            value = temp;
        }
        super.setText(String.valueOf(value));
    }
    public char getLetter() {
        return value;
    }
}
