package com.libertymutual.blackjack.models;

import java.util.List;

public class Gambler {

	private int availableCash;
	private Hand hand;

	public Gambler() {
		availableCash = 50;
		hand = new Hand();
	}
	
	public boolean isBust() {
		int[] values = hand.getValues();
		return values[0] > 21 && values[1] > 21;
	}
	
	public int getAvailableCash() {
		return availableCash;
	}
	
	public double placeBet(double bet) {
		hand = new Hand();
		bet = Math.min(bet, availableCash);
		availableCash -= bet;
		return bet;
	}
	
	
	public void takeCard(Card card) {
		hand.addCard(card);
	}
	
	public List<Card> getCards() {
		return hand.getCards();
	}

	public void payout(double d) {
		availableCash += d;
	}

	public boolean hasBlackjack() {
		return hand.isBlackjack();
	}

	public int getBestScore() {
		return hand.getHighestValidValue();
	}

	public Hand getHand() {
		
		return hand;
	}
	
}
