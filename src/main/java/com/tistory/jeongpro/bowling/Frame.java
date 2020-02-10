package com.tistory.jeongpro.bowling;

public class Frame {
    private int count;
    private int pins;
    private int score;
    private boolean strike;
    private boolean spare;
    private int bonusCount;
    public Frame(){
        this.count = 2;
        this.pins = 10;
        this.score = 0;
        this.bonusCount = 0;
    }
    public int getRemaingChance() {
        return this.count;
    }

    public int getRemaingPins() {
        return this.pins;
    }
    private boolean isValidBowl(int bowl){
        return bowl >= 0 && bowl <= 10;
    }
    public void bowl(int downPins) {
        //score validation
        if(!isValidBowl(downPins)){
            return;
        }
        this.count--;
        this.pins -= downPins;
        score = score + downPins;
        //스트라이크일 때 처리
        if(downPins == 10 && count == 1) {
            strike = Boolean.TRUE;
            count = 0;
            bonusCount += 2;
            return;
        }
        //스페어일 때 처리
        if(pins == 0 && count == 0){
            spare = Boolean.TRUE;
            bonusCount += 1;
            return;
        }
    }
    public void addBonusScore(int bonus){
        if(bonusCount == 0){
            return;
        }
        bonusCount--;
        this.score += bonus;
    }
    public boolean isStrike(){
        return strike;
    }
    public boolean isSpare(){
        return spare;
    }
    public int getScore() {
        return score;
    }

    public boolean isEnd() {
        return count == 0;
    }
}
