package ui.custom_ui;

import javax.swing.*;

import java.awt.*;

public class RoundedPasswordField extends JPasswordField {
    private int radius;
    private Icon icon; 
    private int iconPadding = 12; 

    public RoundedPasswordField(int radius) {
        this.radius = radius;
        setOpaque(false);
        updateCursorPadding();
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
        updateCursorPadding();
        repaint();
    }

    private void updateCursorPadding() {
        int left = 12; 
        if (icon != null) {
            left = iconPadding + icon.getIconWidth() + 10;
        }
        setBorder(BorderFactory.createEmptyBorder(8, left, 8, 12));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground()); 
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        if (icon != null) {
            int iconHeight = icon.getIconHeight();
            int x = iconPadding;
            int y = (getHeight() - iconHeight) / 2;
            icon.paintIcon(this, g2, x, y);
        }

        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(200, 200, 200));
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        g2.dispose();
    }
}