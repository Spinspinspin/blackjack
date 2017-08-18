package com.libertymutual.blackjack.controllers;

import java.util.ArrayList;
import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.blackjack.commands.BetCommand;
import com.libertymutual.blackjack.commands.Undoable;
import com.libertymutual.blackjack.models.Card;
import com.libertymutual.blackjack.models.Dealer;
import com.libertymutual.blackjack.models.Deck;
import com.libertymutual.blackjack.models.Gambler;
import com.libertymutual.blackjack.models.Hand;





@Controller
@RequestMapping("/blackjack")
public class BlackjackController {
	
	
		private Deck  gamedeck;
		private Dealer dealer;
		private Gambler gambler;
		
			public BlackjackController() {
		
				gamedeck = new Deck();
				dealer = new Dealer();
				gambler = new Gambler();
				
			
		}
	
	

	@GetMapping("")
	public ModelAndView Game() {
	Hand hand = new Hand();
	ModelAndView mv = new ModelAndView("/blackjack/blackjack");
	mv.addObject("hand", hand);
	return mv;
	}
	
	
	@PostMapping("operation/bet")
	public String bet() {
		Card cardToDeal = gamedeck.getCard();
		gambler.giveCard(cardToDeal);
		cardToDeal = gamedeck.getCard();
		dealer.giveCard(cardToDeal);
		cardToDeal = gamedeck.getCard();
		gambler.giveCard(cardToDeal);
		cardToDeal = gamedeck.getCard();
		dealer.giveCard(cardToDeal);
		return "redirect:/blackjack";
	}

//	@PostMapping("operation/deal")
//	public String deal() {
//		return "redirect:/blackjack";
		
//	}
	


	@PostMapping("operation/hit")
	public String hit() {
		return "redirect:/blackjack";
		
	}
	
	@PostMapping("operation/stand")
	public String stand() {
		return "redirect:/blackjack";
		
	}
	
	@PostMapping("operation/double")
	public String doubledown() {
		return "redirect:/blackjack";
		
	}
	
	@PostMapping("operation/split")
	public String split() {
		return "redirect:/blackjack";
		
	}
	
	@PostMapping("operation/surrender")
	public String surrender() {
		return "redirect:/blackjack";
		
	}
	
	@PostMapping("operation/over")
	public String reset() {
		return "redirect:/blackjack";
		
	}
}


