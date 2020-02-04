package com.tistory.jeongpro.bowling;

public class Frame {
    private int count;
    private int pins;
    public Frame(){
        this.count = 2;
        this.pins = 10;
    }
    public int getRemaingChance() {
        return this.count;
    }

    public int getRemaingPins() {
        return this.pins
    }

    public void bowl(int i) {
        this.count--;
        this.pins -= i;
    }
}
