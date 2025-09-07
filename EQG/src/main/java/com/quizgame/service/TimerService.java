package com.quizgame.service;

import com.quizgame.observer.TimerObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class TimerService {
    private Timer timer;
    private AtomicInteger timeRemaining;
    private final List<TimerObserver> observers;
    private boolean isRunning;

    public TimerService() {
        this.observers = new ArrayList<>();
        this.isRunning = false;
    }


    public void startTimer(int seconds) {
        if (isRunning) {
            stopTimer();
        }

        this.timeRemaining = new AtomicInteger(seconds);
        this.timer = new Timer();
        this.isRunning = true;

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                int remaining = timeRemaining.decrementAndGet();
                notifyObservers(remaining);

                if (remaining <= 0) {
                    stopTimer();
                    notifyTimeUp();
                }
            }
        };

        timer.scheduleAtFixedRate(task, 1000, 1000);
        notifyObservers(seconds);
    }


    public void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        isRunning = false;
    }

    public int getTimeRemaining() {
        return timeRemaining != null ? timeRemaining.get() : 0;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void addObserver(TimerObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TimerObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(int timeRemaining) {
        for (TimerObserver observer : observers) {
            observer.onTimeUpdate(timeRemaining);
        }
    }

    private void notifyTimeUp() {
        for (TimerObserver observer : observers) {
            observer.onTimeUp();
        }
    }
}
