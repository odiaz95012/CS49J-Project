package edu.sjsu.cs49j.finalproject;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This class creates the GUI where the user is asked to enter a shorthand for a poker card and the corresponding poker card is displayed.
 */
public class CardGUI {
    /**
     * @throws IOException Exception is thrown when the image can't be found
     * This method creates the GUI.
     */
    public static void displayCard() throws IOException{
        //Window that holds the GUI contents
        JFrame window = new JFrame("Display A Card");
        //400 pixels x 600 pixels
        window.setSize(400,600);

        JPanel panel = new JPanel(new BorderLayout()); // This will hold the content of the window
        window.add(panel);
        //START OF INPUT AREA
        // Make a panel where all the input will be (Where the user will enter the shorthand and the button to get the card).
        JPanel input = new JPanel(new BorderLayout());
        //Make the input area the poker table color
        input.setBackground(Color.decode("#35654d"));

        //Instructs users to enter a shorthand
        JLabel inputLabel = new JLabel("Enter the shorthand: ");
        inputLabel.setForeground(Color.WHITE);
        inputLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        inputLabel.setBorder(new EmptyBorder(0,10,0,0));
        input.add(inputLabel, BorderLayout.WEST);

        //Where the user will enter the shorthand
        JTextField shortHand = new JTextField();
        input.add(shortHand, BorderLayout.CENTER);

        //User clicks to get corresponding card
        JButton button = new JButton("Get Card");
        input.add(button, BorderLayout.SOUTH);
        window.add(input, BorderLayout.NORTH);
        // END OF INPUT AREA

        // START OF CARD DISPLAY AREA
        CustomJPanel cardPanel = new CustomJPanel(); // Make a panel where the card will be displayed
        window.add(cardPanel);
        button.addActionListener(e -> {
            //Get the shorthand
            String sh = shortHand.getText();
            //Allows users to enter shorthand in lowercase
            sh = sh.toUpperCase();
            //Make a card object to get the rank and suit
            Card card = new Card(sh);
            //This will add the image to the card panel
            BufferedImage image = null;
            //Tries to create the image from the shorthand, if it fails it will pop up an error message
            try {
                //Make the image with the address of the image using the inputted rank and suit
                image = ImageIO.read(new File(Card.generateImageAddress(card.getRank(),card.getSuit())));
            } catch (IOException e1) {
                // Display error if image file isn't found (meaning invalid shorthand input)
                JOptionPane.showMessageDialog(window,"Invalid input. Please Try again", "Invalid Shorthand Input", JOptionPane.ERROR_MESSAGE);
            }
            //Draw the card to the panel
            cardPanel.setImage(image);
        });
        window.add(cardPanel);
        //END OF CARD AREA

        //FINISHING TOUCHES FOR GUI
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
