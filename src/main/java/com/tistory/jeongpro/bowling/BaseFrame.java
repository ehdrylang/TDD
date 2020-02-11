package com.tistory.jeongpro.bowling;

public interface BaseFrame {
    public void bowl(int count);
    public void addBonusScore(int bonusScore);
    public boolean isEnd();
}
