package com.pluralsight;

import java.util.Scanner;

public class Program {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String winner;
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();
        Deck deck = new Deck();
        deck.shuffle();
        hand1.setPlayerName(promptForString("Enter player 1 name: "));
        hand2.setPlayerName(promptForString("Enter player 2 name: "));

        System.out.println("Dealing cards...");
        for (int i = 0; i < 2; i++) {
            Card card = deck.deal();
            hand1.deal(card);
            Card card2 = deck.deal();
            hand2.deal(card2);
        }
        System.out.printf("Player %s's hand: %d\n", hand1.getPlayerName(), hand1.getValue());
        hand1.displayCards();
        System.out.printf("Player %s's hand: %d\n", hand2.getPlayerName(),hand2.getValue());
        hand2.displayCards();

        System.out.println();
        if (hand1.getValue() > 21 && hand2.getValue() > 21) {
            winner = "Both players busted!";
        }
        else if (hand1.getValue() > 21) {
            winner = hand2.getPlayerName();
        } else if (hand2.getValue() > 21) {
            winner = hand1.getPlayerName();
        }
        else if (hand1.getValue() == hand2.getValue()) {
            winner = "A draw";
        }
        else if (hand1.getValue() > hand2.getValue()) {
            winner = hand1.getPlayerName();
        } else {
            winner = hand2.getPlayerName();
        }
        System.out.printf("The result is: %s!\n", winner);
    }
}
