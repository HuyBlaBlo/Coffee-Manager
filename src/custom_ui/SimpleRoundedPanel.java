package custom_ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class SimpleRoundedPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private int radius;
    private Color backgroundColor;
    private Color borderColor;

    /**
     * Khuôn tạo Panel bo tròn với màu trơn 
     * radius ddộ bo tròn góc
     * backgroundColor màu nền
     *  borderColor màu đường viền (nếu không muốn có viền thì truyền null)
     */
    public SimpleRoundedPanel(int radius, Color backgroundColor, Color borderColor) {
        this.radius = radius;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
      
        setOpaque(false); 
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (backgroundColor != null) {
            g2.setColor(backgroundColor);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        }

        if (borderColor != null) {
            g2.setStroke(new BasicStroke(1f)); 
            g2.setColor(borderColor);
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        }

        g2.dispose();
    }
}