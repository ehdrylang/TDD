package com.tistory.jeongpro.bowling;

public class LastFrame extends Frame {
    public LastFrame(){
        this.score = new int[]{-1,-1,-1};
    }
    public boolean isEnd(){
        return this.idx > 2;
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
        if(isStrike()){
            pins = 10;
        }
        
    }
}
