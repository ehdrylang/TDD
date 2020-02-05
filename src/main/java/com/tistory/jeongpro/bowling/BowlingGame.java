package com.tistory.jeongpro.bowling;

import java.util.ArrayList;
import java.util.List;

/**
 * 볼링 게임
 * 게임은 10번의 프레임을 갖고 게임을 진행한다.
 */
public class BowlingGame {
    private List<Frame> frames;
    private int currentFrame;

    public BowlingGame(){
        this.frames = new ArrayList<>();
        this.currentFrame = 0;
        for(int i=0;i<10;i++){
            frames.add(new Frame());
        }
    }
    public int getTotalFrameCount() {
        return this.frames.size();
    }

    public void progress(int i) {
        if(frames.size() == currentFrame){
            return;
        }
        Frame frame = frames.get(currentFrame);
        frame.bowl(i);

    }

    public int getScore() {
        //종료되었다면...
        int sum = 0;
        for(Frame frame : frames){
            sum += frame.getScore();
        }
        return sum;
    }

    public int getRemaingChance() {
        return frames.get(currentFrame).getRemaingChance();
    }
}
