package edu.sjsu.cs49j.finalproject;

public class Card {
    private String description;
    private final String UNKNOWN = "Unknown";
    private static String shorthand;

    public Card(String shorthand) {
        Card.shorthand = shorthand;
        setDescription();
    }

    public String getDescription() {
        return description;
    }

    private void setDescription() {
        if (shorthand.length() < 2 || shorthand.length() > 3){
            description = UNKNOWN;
            return;
        }
        String rank = getRank();
        Character suit = getSuit();
        if(rank.equals(UNKNOWN)) description = UNKNOWN;
        else description = rank + " of " + suit;
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
