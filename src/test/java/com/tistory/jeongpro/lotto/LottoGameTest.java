package com.tistory.jeongpro.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LottoGameTest {
    private LottoGame lottoGame;
    @BeforeEach
    public void init(){
        this.lottoGame = new LottoGame();
    }

    @Test
    public void givenZero_thenException(){
        assertThrows(RuntimeException.class, ()->lottoGame.create(0));
    }

}
