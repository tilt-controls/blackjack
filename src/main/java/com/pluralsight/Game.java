package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private int numPlayers;
    private ArrayList<Hand> hands;
    public static Scanner scanner = new Scanner(System.in);

    public Game() {
        this.numPlayers = 0;
        this.hands = new ArrayList<>();
    }

    public ArrayList<Hand> createHands() {
        numPlayers = promptForInt("Number of players: ");
        for (int i = 0; i < numPlayers; i++) {
           Hand hand = new Hand();
           hand.setPlayerName(promptForString("Enter player name: "));
           hands.add(hand);
        }
        return hands;
    }

    public void decideWinner() {
        int highestValue = 0;
        String winner = "";
        boolean tie = false;
       for (Hand hand : hands) {
           int value = hand.getValue();
           if (value  > highestValue && value <= 21) {
               highestValue = value;
               winner = hand.getPlayerName();
               tie = false;
           }
           else if (highestValue == value && value > 0 && value <= 21) {
               tie = true;
           }
       }
       if (tie) {
           winner = "A draw";
       }
        if (highestValue == 0) {
            winner = "All players busted";
        }
        System.out.printf("The result is: %s!\n", winner);
    }

    public static int promptForInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
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
