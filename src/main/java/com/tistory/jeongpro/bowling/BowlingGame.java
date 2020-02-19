package com.tistory.jeongpro.bowling;

import java.util.ArrayList;
import java.util.List;

/**
 * 볼링 게임
 * 객체 지향 설계 기반 개발이 가능하도록 구현한다.
 * 상속을 사용해 구현해야 한다. 예를 들어 1 ~ 9 프레임과 10 프레임의 동작 방식이 다른데 이 부분을 상속을 통해 해결해 본다.
 * 배열 대신 java의 collection(List, Map 등)을 사용해 구현해야 한다.
 * 중요한 로직에 대한 소스 코드는 junit 기반의 단위 테스트가 존재해야 한다.
 * indent(인덴트, 들여쓰기) depth를 2단계에서 1단계로 줄여라.
 * depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
 * else를 사용하지 마라.
 * 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
 * method가 한 가지 일만 하도록 최대한 작게 만들어라.
 */
public class BowlingGame {
    private List<BaseFrame> frames;
    private int currentFrame;

    public BowlingGame(){
        this.frames = new ArrayList<>();
        this.currentFrame = 0;
        for(int i=0;i<9;i++){
            frames.add(new Frame());
        }
        frames.add(new LastFrame());
    }
    public int getTotalFrameCount() {
        return this.frames.size();
    }

    public void progress(int i) {
        //게임이 종료되었으면 무시한다.
        if(isEnd()){return;}
        BaseFrame frame = frames.get(currentFrame);
        frame.bowl(i);
        //add bonus
        int pre = currentFrame - 1;
        int pre2 = currentFrame - 2;
        if(pre >= 0){
            frames.get(pre).addScore(i);
        }
        if(pre2 >= 0){
            frames.get(pre2).addScore(i);
        }
        if(frame.isEnd()){
            nextFrame();
        }
    }
    private void nextFrame(){
        this.currentFrame++;
    }

    public int getScore() {
        //종료되지 않았다면 0 리턴
        if(!isEnd()){
            return 0;
        }
        return calcScore();
    }
    private int calcScore(){
        int sum = 0;
        for(BaseFrame frame : frames){
            sum += frame.getScore();
        }
        return sum;
    }
    public int getChance(){
        return frames.get(currentFrame)
                    .getChance();
    }
    private boolean isEnd(){
        return frames.size() <= currentFrame;
    }
}
