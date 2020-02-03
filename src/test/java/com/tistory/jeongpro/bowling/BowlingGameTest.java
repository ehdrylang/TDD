package com.tistory.jeongpro.bowling;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 볼링 게임
 * 게임은 10번의 프레임을 갖고 게임을 진행한다.
 */
@SpringBootTest
public class BowlingGameTest {

    /**
     * 게임을 생성할 수 있다
     */
    @Test
    public void createBowlingGame(){
        BowlingGame bowlingGame = new BowlingGame();
    }
    /**
     * 하나의 게임은 10개의 프레임을 갖고 있다.
     */
    @Test
    public void givenCreatedBowlingGame_whenGetTotalFrame_thenReturnTenFrame(){
        BowlingGame bowlingGame = new BowlingGame();
        assertEquals(1, bowlingGame.getTotalFrameCount());
    }
}