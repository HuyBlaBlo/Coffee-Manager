package ui.custom_ui;

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
    }

    @Override
    protected void paintComponent(Graphics g) {
    	 super.paintComponent(g); 

    	    Graphics2D g2 = (Graphics2D) g.create();
    	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    	    GradientPaint gp = new GradientPaint(
    	            0, 0, Color.decode("#42231c"),      
//    	            0, getHeight(), Color.decode("#7b3b26") 
    	            0, getHeight(), Color.decode("#af8b6b")
    	    );

    	    g2.setPaint(gp);
    	    g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
    	    g2.setStroke(new BasicStroke(2f)); 
    	    g2.setColor(Color.decode("#451201"));           
    	    g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, radius, radius);
    	    g2.dispose();
    }
}