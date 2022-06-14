package com.escapethemansion.model.game.timer;

import com.escapethemansion.model.game.floor.Floor;

import java.text.SimpleDateFormat;
import java.util.Objects;

public class Time {
    private int second;
    private int minute;
    private int counterInit;
    private int counter;

    public Time(int second, int minute) {
        this.second = second;
        this.minute = minute;
        this.counterInit = 30;
        this.counter = counterInit;
    }

    public int getSecond() {
        return second;
    }

    public int getMinute() {
        return minute;
    }

    public boolean reduceTime(boolean timerIsPaused, Floor floor) {
        if(timerIsPaused) return true;
        if (minute == 0 && second == 0) return false;

        if(this.counter == 0) {
            floor.getPlayer().getBattery().decreaseValue();
            floor.getPlayer().getFear().decreaseValue();
            this.counter = this.counterInit;
        }

        if (minute > 0 && second == 0) {
            minute--;
            second = 59;
            counter--;
            return true;
        }

        second--;
        counter--;

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return second == time.second && minute == time.minute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(second, minute);
    }
}
