package com.libertymutual.blackjack.commands;

import java.util.Stack;


public class BetCommand implements Undoable {
    
    private Stack<Double> numberStack;
    private double valueToBet;

    public BetCommand(double valueToBet, Stack<Double> numberStack) {
        this.numberStack = numberStack;
        this.valueToBet = valueToBet;
    }
    
    public void execute() {
        numberStack.push(valueToBet);
    }
    
    @Override
    public void undo() {
        numberStack.pop();
    }
    
}
