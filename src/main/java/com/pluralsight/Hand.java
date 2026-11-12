package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;


public class Hand {
    private ArrayList<Card> cards;
    private String playerName;

    public Hand() {
        cards = new ArrayList<>();
        this.playerName = "";
    }

    // A Card is dealt to the Hand and the Hand is responsible
    // to store the card
    public void deal(Card card) {
        cards.add(card);
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getSize() {
        return cards.size();
    }

    // The Hand uses the methods of each card to determine
    // the value of each card - and adds up all values
    public int getValue() {
        int value = 0;

        for (Card card : cards) {
            card.flip(); // turn the card over to see the value
            value = value + card.getPointValue();
            card.flip(); // hide the card again
        }

        return value;
    }

    public void displayCards() {
        for (Card card : cards) {
            card.flip();
            System.out.printf("%s of %s\n", card.getValue(), card.getSuit());
            card.flip();
        }
    }

}