package com.libertymutual.blackjack.models;

public class FaceCard  implements Card{
	
	private String suit;
	private String visualRep;

	public FaceCard(String visualRep, String suit) {
		this.suit = suit;
		this.visualRep = visualRep;
	}
	
	@Override
	public String toString() {
		return this.getVisualRep() + " of " + this.getSuit();
		
	}
	
	
	public String getVisualRep() {
		return visualRep;
	}
	public String getSuit() {
		return suit;
	}
	
	public int[] getValues() {
		return new int[] {10,10};
	}

}
