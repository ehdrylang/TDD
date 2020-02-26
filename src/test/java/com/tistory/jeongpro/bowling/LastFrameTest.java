package com.tistory.jeongpro.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LastFrameTest {
    private LastFrame lastFrame;
    @BeforeEach
    private void init(){
        this.lastFrame = new LastFrame();
    }
    /**
     * 스트라이크를 하면 보너스로 2번의 기회가 생긴다.
     */
    @Test
    public void whenStrike_thenTwoBonusChance(){
        //when
        lastFrame.bowl(10);
        assertTrue(lastFrame.isStrike());
        //then
        lastFrame.bowl(5);
        assertFalse(lastFrame.isEnd());
        lastFrame.bowl(5);
        assertTrue(lastFrame.isEnd());
    }
    /**
     * 스페어처리를 하면 보너스로 1번의 기회가 생긴다.
     */
    @Test
    public void whenSpare_thenOneBonusChance(){
        //when
        lastFrame.bowl(5);
        lastFrame.bowl(5);
        assertTrue(lastFrame.isSpare());
        //then
        assertFalse(lastFrame.isEnd());
        lastFrame.bowl(5);
        assertTrue(lastFrame.isEnd());
    }

    /**
     * 스트라이크도 스페어도 못했으면 보너스 기회가 없다.
     */
    @Test
    public void givenNeitherStrikeNorSpare_whenBowl_thenException(){
        //when
        lastFrame.bowl(3);
        lastFrame.bowl(2);
        //then
        assertThrows(RuntimeException.class, ()->lastFrame.bowl(5));
    }
    @Test
    public void givenZeroChance_whenProgressFrame_thenException(){
        //when
        lastFrame.bowl(10);
        lastFrame.bowl(10);
        lastFrame.bowl(10);
        //then
        assertThrows(RuntimeException.class, ()->lastFrame.bowl(3));
    }
}