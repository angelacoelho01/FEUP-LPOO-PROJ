package com.escapethemansion.model.game.timer;

import com.escapethemansion.model.game.floor.Floor;
import com.escapethemansion.model.game.timer.Time;

import java.util.Timer;
import java.util.TimerTask;

public class FloorTimer {
    private final Time time;
    private final Timer timer;
    private boolean isPaused;
    private Floor floor;

    public FloorTimer(int min, int sec, Floor floor) {
        this.time = new Time(sec, min);
        this.timer = new Timer();
        this.isPaused = true;
        this.floor = floor;
    }

    public boolean isPaused() {
        return isPaused;
    }


    public void startTimer() {
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if(!isPaused)
                    setInterval();
            }
        }, 1000, 1000);
    }

    public boolean timeIsUp() {
        return time.getMinute() == 0 && time.getSecond() == 0;
    }

    public void pauseTimer() {
        isPaused = true;
    }

    public void resumeTimer() {
        isPaused = false;
    }

    public void endTimer() {
        timer.cancel();
    }

    public String getTime() {
        return String.format("%02d:%02d", time.getMinute(), time.getSecond());
    }


    private void setInterval(){
        if(!time.reduceTime(this.isPaused, this.floor)) timer.cancel();
    }
}

