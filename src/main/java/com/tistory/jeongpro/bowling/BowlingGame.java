package com.tistory.jeongpro.bowling;

import java.util.ArrayList;
import java.util.List;

/**
 * 볼링 게임
 * 게임은 10번의 프레임을 갖고 게임을 진행한다.
 */
public class BowlingGame {
    private List<Frame> frames;

    public BowlingGame(){
        this.frames = new ArrayList<>();
        for(int i=0;i<10;i++){
            frames.add(new Frame());
        }
    }

    public int getTotalFrameCount() {
        return 10;
    }
}
