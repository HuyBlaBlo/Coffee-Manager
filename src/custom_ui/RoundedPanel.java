package custom_ui;

import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;


public class RoundedPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private int radius;

    public RoundedPanel(int radius) {
        this.radius = radius;
        setOpaque(false);
        // Thiết lập màu mặc định ban đầu nếu muốn
        setBackground(Color.WHITE); 
    }

    public Color darken(Color color, double fraction) {
        int red = (int) Math.max(0, color.getRed() * fraction);
        int green = (int) Math.max(0, color.getGreen() * fraction);
        int blue = (int) Math.max(0, color.getBlue() * fraction);
        return new Color(red, green, blue, color.getAlpha());
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // LẤY MÀU TỪ setBackground()
        Color startColor = getBackground(); 
        
        // Tạo màu kết thúc đậm hơn một chút (hoặc sáng hơn) để làm Gradient
        // Nếu bạn muốn màu phẳng (Solid), chỉ cần đặt endColor = startColor
//       Color endColor = startColor.darker(); 
        

        // Cách dùng trong paintComponent:
        Color endColor = darken(startColor, 0.4); // Đậm đi 40%

        GradientPaint gp = new GradientPaint(
                0, 0, startColor,      
                0, getHeight(), endColor
        );

        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        
        // Vẽ viền dựa trên độ đậm của màu nền
        g2.setStroke(new BasicStroke(1.5f)); 
        g2.setColor(startColor.darker().darker()); 
        g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, radius, radius);
        
        g2.dispose();
    }
}