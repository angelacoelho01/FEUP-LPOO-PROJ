package com.escapethemansion.model.menu;

import com.escapethemansion.model.game.floor.Floor;

import java.util.Arrays;
import java.util.List;

public class Pause {
    private final Floor floor;
    private final List<String> entries;
    private int currentEntry = 0;

    public Pause(Floor floor) {
        this.entries = Arrays.asList("resume", "Grestart", "return to menu");
        this.floor = floor;
    }

    public Floor getFloor() {
        return this.floor;
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedPlay() {
        return isSelected(0);
    }

    public boolean isSelectedRestart() { return isSelected(1);}

    public boolean isSelectedQuit() {
        return isSelected(2);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
