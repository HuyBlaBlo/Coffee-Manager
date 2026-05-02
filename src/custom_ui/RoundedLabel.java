package custom_ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JLabel;

public class RoundedLabel extends JLabel {
    private static final long serialVersionUID = 1L;
    
    private int radius;
    private Color backgroundColor;

    // thêm nền, bo trong cho label có chữ
    public RoundedLabel(String text, int radius, Color backgroundColor) {
        super(text); // Gọi constructor của JLabel để set chữ
        this.radius = radius;
        this.backgroundColor = backgroundColor;
        setOpaque(false); 
    }
    
    // dùng để thêm nền và bo tronf cho label nhưng chỉ có icon
    public RoundedLabel(int radius, Color backgroundColor) {
        super(); // Gọi cha nhưng không truyền chữ gì cả
        this.radius = radius;
        this.backgroundColor = backgroundColor;
        setOpaque(false); 
    }

    @Override
    protected void paintComponent(Graphics g) {	
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (backgroundColor != null) {
            g2.setColor(backgroundColor);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        }
        g2.dispose();
        super.paintComponent(g);
    }
}