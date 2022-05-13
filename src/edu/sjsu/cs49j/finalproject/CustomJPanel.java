package edu.sjsu.cs49j.finalproject;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * This class creates a custom version of JPanel that makes it easy to draw images on the panel.
 */
public class CustomJPanel extends JPanel {

    BufferedImage image = null;

    /**
     * @param g The image being drawn
     * This function draws an image in a JPanel
     */
    @Override
    public void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        //Make the panel the color of a poker table
        this.setBackground(Color.decode("#35654d"));
        super.paintComponent(g);
        //the x and y are the width and height divided by 4 so that the image is drawn in the center of the panel
        g.drawImage(image, this.getWidth() / 4, this.getHeight() / 4, this.getWidth() / 2, this.getHeight() / 2, this);
    }

    /**
     * @param image The image being drawn
     * This function sets the image that will be drawn onto the JPanel
     */
    public void setImage(BufferedImage image) {
        this.image = image;
        repaint();
    }
}