package com.tistory.jeongpro.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.AssertionErrors;

import static org.junit.jupiter.api.Assertions.*;

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
        frame.bowl(5);
        assertFalse(frame.isEnd());
        frame.bowl(3);
        assertTrue(frame.isEnd());
    }

    /**
     * 스트라이크시 프레임은 종료된다.
     */
    @Test
    public void whenStrike_thenFrameEnd(){
        //when
        frame.bowl(10);
        //then
        assertTrue(frame.isEnd());
    }

    /**
     * 프레임이 종료되었을 때 계속해서 게임을 진행하려고하면 예외가 발생한다.
     */
    @Test
    public void givenFrameEnd_whenBowl_thenException(){
        //given
        frame.bowl(3);
        frame.bowl(3);
        //when then
        assertThrows(RuntimeException.class, ()->frame.bowl(3));
    }

    /**
     * 프레임이 종료되면 더 이상 진행할 수 없다.
     */
    @Test
    public void givenTwoBowling_whenThereAreNoPins_thenReturnTrue(){
        //given
        frame.bowl(5);
        frame.bowl(3);
        assertTrue(frame.isEnd());
        assertThrows(RuntimeException.class, ()->frame.bowl(4));
    }
    /**
     * 쓰러트린 핀수는 0에서 10사이의 값이어야하고 아닐 시에는 예외가 발생한다.
     */
    @Test
    public void givenElevenPins_whenBowl_thenThrowException(){
        assertThrows(RuntimeException.class, ()-> frame.bowl(11));
    }
}
