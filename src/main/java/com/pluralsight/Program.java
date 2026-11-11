package com.pluralsight;

public class Program {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand hand1 = new Hand();
        deck.shuffle();

        for (int count = 1; count <= 2; count = count + 1) {
            // get a card from the deck
            Card card = deck.deal();
            // deal that card to the hand
            hand1.deal(card);
        }

        System.out.println(deck.getSize());
        System.out.println(hand1.getSize());

        int handValue = hand1.getValue();
        System.out.println("This hand is worth " + handValue);
    }
}
