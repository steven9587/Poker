package com.steven.poker;

public class Card {
    int value;
    char[] suits = {'\u2660', '\u2665', '\u2666', '\u2663'};

    public Card(int value) {
        this.value = value;
    }

    public String getCard() {
        return suits[value / 13] + " " + (value % 13 + 1);
    }
}
