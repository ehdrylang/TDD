package com.tistory.jeongpro.bowling;


public abstract class BaseFrame {
    protected int pins;
    protected int chance;
    protected int score;
    protected boolean isStrike;
    protected boolean isSpare;
    protected int bonusChance;

    public BaseFrame(int chance){
        this.chance = chance;
        this.pins = 10;
        this.score = 0;
        this.bonusChance = 0;
        this.isSpare = Boolean.FALSE;
        this.isStrike = Boolean.FALSE;
    }
    public int getChance(){
        return chance;
    }
    public int getPins() {
        return pins;
    }

    public void addScore(int score) {
        if(bonusChance > 0) {
            this.score += score;
            this.bonusChance--;
        }
    }
    public int getScore(){
        return score;
    }
    public void bowl(int count){
        //validation
        if(!isValidBowl(count)){
            throw new RuntimeException("Invalid count");
        }
        if(isEnd()){
            throw new RuntimeException("You can't proceed any more");
        }
        chance--;
        pins -= count;
        score += count;
        //스트라이크 처리
        if(!isStrike && pins == 0 && chance == 1){
            isStrike = Boolean.TRUE;
            bonusChance = 2;
            chance = 0;
            return;
        }
        //스페어 처리
        if(!isStrike && pins == 0 && chance == 0){
            isSpare = Boolean.TRUE;
            bonusChance = 1;
        }
    }
    public boolean isValidBowl(int count){
        return count >= 0 && count <= 10 && (pins - count) >= 0 && chance > 0;
    }
    public boolean isStrike() {
        return isStrike;
    }
    public boolean isSpare() {
        return isSpare;
    }
    public boolean isEnd(){
        return chance == 0;
    }
}
