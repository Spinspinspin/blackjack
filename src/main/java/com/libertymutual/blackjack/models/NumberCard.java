package com.libertymutual.blackjack.models;

public class NumberCard implements Card {
	
	private String suit;
	private int value;

	public NumberCard(int value, String suit) {
		this.value = value;
		this.suit = suit;
		
	}
	
	@Override
	public String toString() {
		return this.getVisualRep() + " of " + this.getSuit();
			}
	
	public int[] getValues() {
		return new int[] {value, value };
	}
	
	public String getSuit() {
		return suit;
	}
	public String getVisualRep() {
		return String.valueOf(value);
	}
	
	
	
	
	

}
