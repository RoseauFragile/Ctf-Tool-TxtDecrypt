package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
 
public class BackgroundPanel extends JPanel {
 
    private static final long serialVersionUID = 1L;
    private ImageIcon background;
   
    public BackgroundPanel(String fileName) {
        super();
        this.setLayout(new GridBagLayout());
        this.background = new ImageIcon(fileName);
    }
 
    public void setBackground(ImageIcon background) {
        this.background = background;
    }
 
    public void paintComponent(Graphics g) {
        BufferedImage scaledImage = getScaledImage();
        super.paintComponent(g);
        g.drawImage(scaledImage, 0, 0, this);
    }
    
    private BufferedImage getScaledImage(){
        BufferedImage image = new BufferedImage(getWidth(),getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = (Graphics2D) image.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(background.getImage(), 0, 0,getWidth(),getHeight(), null);

        return image;
    }
}