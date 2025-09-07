package com.quizgame.observer;

public interface TimerObserver {

    void onTimeUpdate(int timeRemaining);


    void onTimeUp();
}
