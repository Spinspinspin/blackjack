package com.libertymutual.blackjack.models;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

private Hand hand;
private boolean hideACard;
private Deck deck;
	
	public Dealer() {
		hand = new Hand();
		deck = new Deck();
		deck.shuffle();
	}
	
	public int getNumberOfCardsLeft() {
		return deck.getNumberOfCardsLeft();
}
	public boolean isBust() {
		int[] values = hand.getValues();
		return values[0] > 21 && values[1] > 21;
	}
	
	public void startRound() {
		hideACard = true;
		hand = new Hand();
	}
	
	public void finishRound() {
		hideACard = false;
		int[] values = hand.getValues();
		if (values[0] == 21 || values[1] == 21) {
			return;
		}
		while (values[0] < 17 || values[1] < 17) {
			keepCard();
			values = hand.getValues();
		}
	}

		public List<Card> getCards() {
			List<Card> cards = hand.getCards();
			if (!hideACard || cards.size() == 0) {
				return cards;
			}
		

			Card firstCard = cards.get(0);
			List <Card> cardsToShow = new ArrayList<Card>();
			cardsToShow.add(firstCard);
			cardsToShow.add(new HoleCard());
			return cardsToShow;
		}
		
	
	
	public void giveCard(Gambler gambler) {
		Card card = deck.getCard();
		if (card != null) {
		gambler.takeCard(card);
		}
	}

	public void keepCard() {
		Card card = deck.getCard();
		if (card != null) {
		hand.addCard(card);
		}
	}
	
public Hand getHand() {
		
		return hand;
	}
	
		 public boolean hasBlackjack() {
			 return hand.isBlackjack();
		  }
		 
		 public int getBestScore() {
			 return hand.getHighestValidValue();
		 }
	}
	
	


