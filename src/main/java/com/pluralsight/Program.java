package com.pluralsight;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        Game game = new Game();
        ArrayList<Hand> hands = game.createHands();

        for (Hand hand : hands) {
            Card card = deck.deal();
            hand.deal(card);
            Card card2 = deck.deal();
            hand.deal(card2);
        }

        for (Hand hand : hands) {
            System.out.printf("%s's hand: \n", hand.getPlayerName());
            hand.displayCards();
            System.out.printf("Value: %d\n", hand.getValue());
            System.out.println();
        }
        game.decideWinner();

        System.out.println();
    }
}
