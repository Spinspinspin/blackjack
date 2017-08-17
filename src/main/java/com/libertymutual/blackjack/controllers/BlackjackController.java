package com.libertymutual.blackjack.controllers;

import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.libertymutual.blackjack.commands.BetCommand;
import com.libertymutual.blackjack.commands.Undoable;





@Controller
@RequestMapping("/blackjack")
public class BlackjackController {
	
	Stack <Double> numberStack;
	private Stack<Undoable> commandHistory;

	@GetMapping("")
	public String blackjack(Model model) {
		model.addAttribute("stack", numberStack);	
		return "/blackjack/blackjack";
	
	}
	
	@PostMapping("operation/bet")
	public String bet(double theNumber) {
		BetCommand command = new BetCommand(theNumber, numberStack);
		command.execute();
		commandHistory.push(command);
		return "redirect:/blackjack";
	}

	@PostMapping("operation/deal")
	public String deal() {
		return "redirect:/blackjack";
		
	}
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


