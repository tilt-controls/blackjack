package com.pluralsight;

import java.util.Scanner;

public class Program {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        Deck deck = new Deck();
//        Hand hand1 = new Hand();
//        deck.shuffle();
//
//        for (int count = 1; count <= 2; count = count + 1) {
//            // get a card from the deck
//            Card card = deck.deal();
//            // deal that card to the hand
//            hand1.deal(card);
//        }
//
//        System.out.println(deck.getSize());
//        System.out.println(hand1.getSize());
//
//        int handValue = hand1.getValue();
//        System.out.println("This hand is worth " + handValue);
//    }
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

    }
    public static String promptForString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("This can't be blank.");
            } else if (input.contains("|")) {
                System.out.println("Please don't use the | character.");
            } else {
                return input;
            }
        }
    }
}
