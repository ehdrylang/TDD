package com.tistory.jeongpro.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        bowlingGame.play(0);
    }

    /**
     * 모든 프레임의 기회에서 한 개도 핀을 쓰러트리지 못했을 때 0점이다
     * gutter
     */
    @Test
    public void givenZeroPins_whenEveryFrame_thenScoreIsZero(){
        playMany(20, 0);
        assertEquals(0, bowlingGame.getScore());
    }

    /**
     * 매 프레임에서 1개의 핀씩 쓰러트렸을 때 점수는 20점이다.
     */
    @Test
    private void allOnes(){
        playMany(20, 1);
        assertEquals(20, bowlingGame.getScore());
    }

    /**
     * 스페어가 한 번 발생했을 때 점수 계산
     */
    @Test
    public void oneSpare(){
        playSpare();
        bowlingGame.play(3);
        playMany(17, 0);
        assertEquals(16, bowlingGame.getScore());

    }

    private void playSpare() {
        bowlingGame.play(5);
        bowlingGame.play(5);
    }

    /**
     * 스트라이크가 한 번 발생했을 때 점수 계산
     */
    @Test
    public void oneStrike(){
        bowlingGame.play(10);
        bowlingGame.play(5);
        bowlingGame.play(3);
        playMany(16, 0 );
        assertEquals(26, bowlingGame.getScore());
    }

    /**
     * 메서드 추출한 것.
     * @param frameCount
     * @param pins
     */
    private void playMany(int frameCount, int pins) {
        for (int i = 0; i < frameCount; i++) {
            bowlingGame.play(pins);
        }
    }

    /**
     * 모든 프레임에서 스트라이크를 했다면 300점이다
     */
    @Test
    public void givenPerfect_whenEveryFrame_thenScoreIsThreeHundred(){
        playMany(12, 10);
        assertEquals(300, bowlingGame.getScore());
    }
    /**
     * 마지막 프레임에서 스트라이크를 했다면 2번의 추가 기회가 주어진다.
     */
    @Test
    public void givenStrike_whenLastFrame_thenGetTwoChance() {
        playMany(18, 3);
        bowlingGame.play(10);
        assertEquals(2, bowlingGame.getChance());
    }
}