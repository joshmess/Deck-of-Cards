package deck_of_cards;

/*
 * The Card class represents one single card.
 */
public class Card {
	
	private char value;
	private char suit;
	
	// Constructor will initialize the card's value and suit
	public Card(char v, char s) {
		
		value = v;
		suit = s;
	}
	
	// Accessor for card suit
	protected char getSuit() {
		return suit;
	}
	
	// Accessor for card value
	protected char getValue() {
		return value;
	}
	// toString overwrite
	public String toString() {
		
		return value + "" + suit;
	}

}
