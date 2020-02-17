package com.tistory.jeongpro.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.AssertionErrors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 하나의 두 번의 기회가 주어지고
 * 10개의 핀을 모두 쓰러뜨리거나 두 번의 기회를 다 사용하면 종료된다.
 */
@SpringBootTest
public class FrameTest {
    private Frame frame;
    @BeforeEach
    private void init(){
        this.frame = new Frame();
    }
    /**
     * 하나의 프레임은 최초 2번의 기회를 갖는다
     */
    @Test
    public void whenInitialize_thenTwoChanceAndTenPins(){
       assertEquals(2, frame.getPins());
       assertEquals(10, frame.getPins());
    }

    /**
     * 쓰러트린 볼링핀의 개수를 받아 진행할 수 있다.
     */
    @Test
    public void givenPins_whenBowling_thenDecreasePins(){
        //given
        frame.bowl(5);
        //then
        assertEquals(5, frame.getPins());
        assertEquals(1, frame.getChance());
    }
    /**
     * 프레임이 종료되었는데 더 진행하려고 하면 안된다.
     */
    @Test
    public void givenTwoBowling_whenThereAreNoPins_thenReturnTrue(){
        //given
        frame.bowl(5);
        frame.bowl(3);
        assertTrue(frame.isEnd());
    }

}
