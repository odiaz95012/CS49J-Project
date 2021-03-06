package edu.sjsu.cs49j.finalproject;

public class Card {
    private static String shorthand;

    public Card(String shorthand) {
        Card.shorthand = shorthand;
    }

    /**
     * @return The rank of the inputted shorthand.
     */
    public String getRank(){
        return shorthand.substring(0,shorthand.length() - 1);
    }

    /**
     * @return The suit of the inputted shorthand.
     */
    public Character getSuit(){
        return shorthand.charAt(shorthand.length()-1);
    }

    /**
     * @param rank Corresponding card's rank (A,2,3,...,10,J,Q,K)
     * @param suit Corresponding card's suit (C (clubs), H (hearts), D (diamonds), S (spades),J (Joker))
     * @return Address of the card's image
     */
    public static String generateImageAddress(String rank, Character suit){
        return "src/edu/sjsu/cs49j/finalproject/PNG-cards-1.3/" + rank + suit + ".png";
    }
    //MAKE A FUNCTION TO VALIDATE RANK

    //MAKE A FUNCTION TO VALIDATE SUIT
}
