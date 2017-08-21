package com.libertymutual.blackjack.controllers;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.libertymutual.blackjack.models.Dealer;
import com.libertymutual.blackjack.models.Deck;
import com.libertymutual.blackjack.models.Gambler;
import com.libertymutual.blackjack.models.Hand;


@Controller
@RequestMapping("/blackjack")
public class BlackjackController {

	private Deck gameDeck;
	private Dealer dealer;
	private Gambler gambler;
	private double currentBet;

	public BlackjackController() {

		gameDeck = new Deck();
		dealer = new Dealer();
		gambler = new Gambler();

	}

	@GetMapping("")
	public ModelAndView Game() {
		if (gambler.isBust()) {
			currentBet = 0;
		}
		Hand gamblerhand = gambler.getHand();
		Hand dealerhand = dealer.getHand();
		ModelAndView mv = new ModelAndView("blackjack/blackjack");
		mv.addObject("gambler", gambler);
		mv.addObject("dealer", dealer);
		mv.addObject("gamblerhand", gamblerhand);
		mv.addObject("dealerhand", dealerhand);
		mv.addObject("currentBet", currentBet);
		mv.addObject("betState", currentBet == 0 && gambler.getAvailableCash() > 0);
		mv.addObject("roundState", currentBet != 0 && dealer.getNumberOfCardsLeft() > 0);
		
		return mv;
	}

	@PostMapping("operation/bet")
	public String bet(double bet) {
		gameDeck.shuffle();
		currentBet = gambler.placeBet(bet);
		dealer.startRound();
		dealer.giveCard(gambler);
		dealer.keepCard();
		dealer.giveCard(gambler);
		dealer.keepCard();
		return "redirect:/blackjack";
	}
	
	@PostMapping ("operation/reset")
	public String reset() {
		dealer = new Dealer();
		gambler = new Gambler();
		return "redirect:/blackjack";
	}
	

	@PostMapping("operation/deal")
	public String deal() {
		gameDeck = new Deck();
		dealer = new Dealer();
		gambler = new Gambler();
		return "blackjack/blackjack";

	}

	@PostMapping("operation/hit")
	public String hit() {
		dealer.giveCard(gambler);
		return "redirect:/blackjack";

	}

	@PostMapping("operation/stand")
	public String Stand() {
		dealer.finishRound();
		if (dealer.isBust()) {
			gambler.payout(currentBet * 2);
		} else if (gambler.hasBlackjack() && !dealer.hasBlackjack()) {
			gambler.payout(currentBet + currentBet / 2);
		} else if (gambler.getBestScore() == dealer.getBestScore()) {
			gambler.payout(currentBet);
		} else if (gambler.getBestScore() > dealer.getBestScore()) {
			gambler.payout(currentBet * 2);
		}

		currentBet = 0;
		return "redirect:/blackjack";
	}

	@PostMapping("operation/surrender")
	public String surrender() {
		gambler.payout(currentBet / 2);
		currentBet = 0;
		return "blackjack/blackjack";

	}

}
