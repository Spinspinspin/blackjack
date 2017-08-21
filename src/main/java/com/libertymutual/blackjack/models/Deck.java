package com.libertymutual.blackjack.models;

public class Deck {

		private Card[] cards;
		private int currentCardIndex;
		
		public Deck() {
			String[] suits = new String [] {"Diamonds", "Hearts", "Clubs", "Spades"};
			int i = 0;
			cards = new Card[52];
			currentCardIndex = 0;
			
			for (String suit : suits) {
				cards[i] = new AceCard(suit);
				i += 1;
				
				cards [i] = new FaceCard("Jack", suit);
				i += 1;
				cards [i] = new FaceCard("Queen", suit);
				i += 1;
				cards [i] = new FaceCard("King", suit);
				i += 1;
				
				for (int j = 2; j < 11; j +=1) {
					cards[i] = new NumberCard(j, suit);
					i += 1;
				}
			}
		}

		public void printThis() {
			for(Card card : cards) {
				System.out.println(card);
			}
		}

		public Card getCard() {
			if(currentCardIndex >= cards.length) {
				return null;
			
		}

		Card cardToReturn = cards[currentCardIndex];
		currentCardIndex += 1;
		return cardToReturn;

	}	

	public void shuffle() {
		for (int doSeven = 0; doSeven < 7; doSeven +=1) {
			Card[] tempCardHold1 = new Card[26];
			Card[] tempCardHold2 = new Card[26];
			
			for (int i = 0; i < tempCardHold1.length; i +=1) {
				tempCardHold1[i] = cards[i];
				tempCardHold2[i] = cards[26 + i];
				
			}
			
			int hold1Index = 0;
			int hold2Index = 0;
			int bigIndex = 0;
			
			while (hold1Index < 26 || hold2Index < 26) {
				Card cardToMove;
				if (Math.random() < 0.5) {
					if (hold1Index < 26) {
						cardToMove = tempCardHold1[hold1Index];
						hold1Index += 1;
					
					}else {
						cardToMove = tempCardHold2[hold2Index];
						hold2Index += 1;
						
					}
					
				}else {
					if (hold2Index < 26) {
						cardToMove = tempCardHold2[hold2Index];
						hold2Index += 1;
					
					}else {
						cardToMove = tempCardHold1[hold1Index];
						hold1Index += 1;
						
					}	
				}
						cards[bigIndex] = cardToMove;
						bigIndex +=1;
			
			}
		}
	}
					public int getNumberOfCardsLeft() {
						return cards.length - currentCardIndex;
					}					
}


	
	





