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
        assertEquals(2, lastFrame.getChance());
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
        assertEquals(1, lastFrame.getChance());
    }

    /**
     * 스트라이크도 스페어도 못했으면 보너스 기회가 없다.
     */
    @Test
    public void whenNeitherStrikeNorSpare_thenNoMoreChance(){
        //when
        lastFrame.bowl(3);
        lastFrame.bowl(2);
        //then
        assertEquals(0, lastFrame.getChance());
    }
    @Test
    public void whenThreeStrike_thenThirtyScore(){
        //when
        lastFrame.bowl(10);
        lastFrame.bowl(10);
        lastFrame.bowl(10);
        //then
        assertEquals(30, lastFrame.getScore());
    }
    @Test
    public void givenSpare_whenGetBonusFrame_thenSumBounsFrameScore(){
        //when
        lastFrame.bowl(6);
        lastFrame.bowl(4);
        lastFrame.bowl(5);
        //then
        assertEquals(15, lastFrame.getScore());
    }
    @Test
    public void givenZeroChance_whenProgressFrame_thenException(){
        //when
        lastFrame.bowl(10);
        lastFrame.bowl(10);
        lastFrame.bowl(10);
        assertEquals(0, lastFrame.getChance());
        assertThrows(RuntimeException.class, ()->lastFrame.bowl(3));
    }
}