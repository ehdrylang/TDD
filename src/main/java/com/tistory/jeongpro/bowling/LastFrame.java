package com.tistory.jeongpro.bowling;

public class LastFrame extends BaseFrame {
    public LastFrame(){
        super(2);
    }
    public void bowl(int count){
        if(!isValidBowl(count)){return;}
        if(isEnd()){return;}
        chance--;
        pins -= count;
        score += count;
        //1구 스트라이크
        if(!isStrike && pins == 0 && chance == 1){
            pins = 10;
            isStrike = Boolean.TRUE;
            return;
        }
        //2구 스트라이크
        if(isStrike && pins == 0 && chance == 0){
            pins = 10;
        }
        //2구 스페어
        if(pins == 0 && chance == 1){
            pins = 10;
        }
    }
}
