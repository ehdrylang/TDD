package com.tistory.jeongpro.bowling;

public class LastFrame extends Frame {
    public LastFrame(){
        this.score = new int[]{-1,-1,-1};
    }
    public boolean isEnd(){
        return (hasBonusBowl() && this.idx > 2) || (!hasBonusBowl() && this.idx > 1);
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
        score[idx] = count;
        idx++;
    }
    private boolean hasBonusBowl(){
        return isStrike() || isSpare();
    }
}
