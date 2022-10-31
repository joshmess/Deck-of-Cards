package deck_of_cards;

import java.util.Random;

/*
 * The deck class represents a standard 52-card playing deck.
 */
public class Deck {

	private Card[] deck;
	protected final char[] cardVals = {'A','2','3','4','5','6','7','8','9','T','J','Q','K'};
	protected final char[] suits= {'c','s','h','d'};
	private int dealt = -1;


	// Constructor initializes and populates a new deck
	public Deck() {

		deck = new Card[52];
		populateDeck();

	}

	// Populate a new deck
	private void populateDeck() {

		int cardCount = 0;

		for(int i = 0; i < cardVals.length; ++i) {

			for(int j = 0; j < suits.length; ++j) {

				deck[cardCount] = new Card(cardVals[i],suits[j]);
				++cardCount;

			}
		}
	}

	// Shuffle the deck
	protected void shuffle() {

		Random rand = new Random();

		for (int i = 0; i < deck.length; ++i)
		{
			// Select a random place in the deck not including spaces already considered
			int randNum = i + rand.nextInt(52 - i);

			// Swap with another random card (may swap with itself but that is allowed)
			Card temp = deck[randNum];
			deck[randNum] = deck[i];
			deck[i] = temp;

		}
	}
	
	// Deal one card to the caller
	protected Card dealOneCard() {
		
		if(dealt == 51) {
			throw new Error("\nAll cards have been dealt. Reset deck to deal again.");
		}		
		return deck[++dealt];
	}
	
	// Return all cards to deck and shuffle
	protected void resetDeck() {
		dealt = -1;
		shuffle();
	}

	// Print every card in the deck (dealt cards not displayed)
	protected void showDeck() {

		
		for(int i = dealt+1; i < deck.length; ++i) {
			System.out.print(deck[i].toString() + " ");
		}
	}
	
	// Return number of cards in the deck (not including dealt cards)
	protected int getSize() {
		
		if(dealt == -1) {
			return 52;
		}
		return 52 - (dealt+1);
	}






}
