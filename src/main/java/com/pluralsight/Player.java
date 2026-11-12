package com.pluralsight;
import java.util.*;

public class Player {

    private String playerName;
    private Hand hand;

    public Player(String playerName) {
        this.playerName = playerName;
        this.hand = new Hand();
    }

    public String getPlayerName() {
        return playerName;
    }

    public Hand getHand() {
        return hand;
    }
}
