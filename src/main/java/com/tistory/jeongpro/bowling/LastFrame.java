package com.tistory.jeongpro.bowling;

public class LastFrame extends BaseFrame {
    public LastFrame(){
        super(2);
    }
    public void bowl(int count){
        if(!isValidBowl(count)){
            throw new RuntimeException("Invalid Count");
        }
        if(isEnd()){
            throw new RuntimeException("You can't proceed any more");
        }
        chance--;
        pins -= count;
        score += count;
        //1구 스트라이크
        if(!isStrike && pins == 0 && chance == 1){
            pins = 10;
            isStrike = Boolean.TRUE;
            chance++;
            return;
        }
        //1구 스트라이크 이후 2구 스트라이크
        if(isStrike && pins == 0 && chance == 1){
            pins = 10;
        }
        //스페어
        if(!isStrike && pins == 0 && chance == 0){
            isSpare = Boolean.TRUE;
            pins = 10;
            chance++;
        }
    }
}
