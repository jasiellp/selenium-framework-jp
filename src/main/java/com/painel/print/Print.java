package com.painel.print;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
 
public class Print extends JDialog
{
   
     
	private static final long serialVersionUID = -7232285518568158678L;

	public Print(final BufferedImage image){
    	 ImagePanel panel = new ImagePanel(image);
         ImageZoom zoom = new ImageZoom(panel);
         
         
     	setResizable(true);
		setModal(true);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setBounds(100, 100, 675, 527);
        
        
        getContentPane().add(zoom.getUIPanel(), "North");
        getContentPane().add(new JScrollPane(panel));
        
        
        
    }
}
 
class ImagePanel extends JPanel
{
   
	private static final long serialVersionUID = 1076014819181970383L;
	
	BufferedImage image;
    
	double scale;
 
    public ImagePanel(BufferedImage image)
    {
        loadImage(image);
        scale = 1.0;
        setBackground(Color.black);
    }
 
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        int w = getWidth();
        int h = getHeight();
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();
        double x = (w - scale * imageWidth)/2;
        double y = (h - scale * imageHeight)/2;
        AffineTransform at = AffineTransform.getTranslateInstance(x,y);
        at.scale(scale, scale);
        g2.drawRenderedImage(image, at);
    }
 
    
   
    public Dimension getPreferredSize()
    {
        int w = (int)(scale * image.getWidth());
        int h = (int)(scale * image.getHeight());
        return new Dimension(w, h);
    }
 
    public void setScale(double s)
    {
        scale = s;
        revalidate();      // update the scroll pane
        repaint();
    }
 
    private void loadImage(BufferedImage image)
    {
       
            this.image =image;
        
    }
}
 
class ImageZoom
{
    ImagePanel imagePanel;
 
    public ImageZoom(ImagePanel ip)
    {
        imagePanel = ip;
    }
 
    public JPanel getUIPanel()
    {
        
    	final JSlider spinner = new JSlider(JSlider.HORIZONTAL, 0, 100, 25);
    	spinner.setMinorTickSpacing(2);
    	spinner.setMajorTickSpacing(10);
    	spinner.setPaintTicks(true);
        spinner.setPaintLabels(true);

        // We'll just use the standard numeric labels for now...
        spinner.setLabelTable(spinner.createStandardLabels(10));
        spinner.setPreferredSize(new Dimension(230, spinner.getPreferredSize().height));
        spinner.addChangeListener(new ChangeListener()
        {
            public void stateChanged(ChangeEvent e)
            {
                double escala = spinner.getValue()/35.7;
                imagePanel.setScale(escala);
            }
        });
        JPanel panel = new JPanel();
        panel.add(new JLabel("Escala"));
        panel.add(spinner);
        return panel;
    }
}
