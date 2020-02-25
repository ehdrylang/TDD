package com.tistory.jeongpro.bowling;


public class BaseFrame {
    protected int pins;
    protected int score[];
    private int idx;

    public BaseFrame(){
        this.pins = 10;
        this.score = new int[]{-1, -1};
        this.idx = 0;
    }
    public void bowl(int count){
        //validation
        if(!isValidBowl(count)){
            throw new RuntimeException("Invalid count");
        }
        //end
        if(isEnd()){
            throw new RuntimeException("You can't proceed any more");
        }
        pins -= count;
        score[idx] = count;
        idx++;
    }
    public boolean isValidBowl(int count){
        return count >= 0 && count <= 10 && (pins - count) >= 0;
    }
    public boolean isStrike() {
        return score[0] == 10;
    }
    public boolean isSpare() {
        return score[0] != 10 && score[0] + score[1] == 10;
    }
    public boolean isEnd(){
        return pins == 0 || idx > 1;
    }
    public int getScore(int bowl){
        return score[bowl];
    }
}
