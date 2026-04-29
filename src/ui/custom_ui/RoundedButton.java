package ui.custom_ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoundedButton extends JButton {
    private int radius;
    private Color colorHover;
    private Color colorNormal;
    private Color colorPressed;

    
    public RoundedButton(String text, int radius, Color bgColor) {
        super(text);
        this.radius = radius;
        this.colorNormal = bgColor;
        this.colorHover = bgColor.darker(); 
        this.colorPressed = bgColor.darker().darker(); 
        
        setBackground(bgColor);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(colorHover); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(colorNormal); 
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(colorPressed); 
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (getBounds().contains(e.getPoint())) {
                    setBackground(colorHover);
                } else {
                    setBackground(colorNormal);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.dispose();
        super.paintComponent(g);
    }
}



