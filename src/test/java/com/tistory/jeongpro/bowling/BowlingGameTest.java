package com.tistory.jeongpro.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * 볼링 게임
 * 게임은 10번의 프레임을 갖고 게임을 진행한다.
 */
@SpringBootTest
public class BowlingGameTest {
    private BowlingGame bowlingGame;
    @BeforeEach
    private void init(){
        this.bowlingGame = new BowlingGame();
    }

    /**
     * 게임을 생성할 수 있다
     */
    @Test
    public void createBowlingGame(){
        assertNotNull(this.bowlingGame);
    }
    /**
     * 하나의 게임은 10개의 프레임을 갖고 있다.
     */
    @Test
    public void givenCreatedBowlingGame_whenGetTotalFrame_thenReturnTenFrame(){
        BowlingGame bowlingGame = new BowlingGame();
        assertEquals(10, bowlingGame.getTotalFrameCount());
    }

    /**
     * 쓰러진 볼링핀 수를 입력하여 게임을 진행할 수 있다.
     */
    @Test
    public void givenPins_whenProgress(){
        bowlingGame.progress(1);
    }

    /**
     * 모든 프레임의 기회에서 한 개도 핀을 쓰러트리지 못했을 때 0점이다
     */
    @Test
    public void givenZeroPins_whenEveryFrame_thenScoreIsZero(){
        for(int i=0;i<20;i++){
            bowlingGame.progress(0);
        }
        assertEquals(0, bowlingGame.getScore());
    }

    /**
     * 모든 프레임에서 스트라이크를 했다면 300점이다
     */
    @Test
    public void givenPerfect_whenEveryFrame_thenScoreIsThreeHundred(){
        for(int i=0;i<12;i++){
            bowlingGame.progress(10);
        }
        assertEquals(300, bowlingGame.getScore());
    }
    /**
     * 마지막 프레임에서 스트라이크를 했다면 2번의 추가 기회가 주어진다.
     */
    public void givenStrike_whenLastFrame_thenGetTwoChance(){
        for(int i=0;i<18;i++){
            bowlingGame.progress(3);
        }
        bowlingGame.progress(10);
        assertEquals(2, bowlingGame.getRemaingChance());
    }
}