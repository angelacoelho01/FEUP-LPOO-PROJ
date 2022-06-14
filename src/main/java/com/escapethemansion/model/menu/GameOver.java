package com.escapethemansion.model.menu;

import com.escapethemansion.model.game.floor.Floor;

import java.util.Arrays;
import java.util.List;

public class GameOver {

    private final List<String> entries;
    private int currentEntry = 0;

    public GameOver() {
        this.entries = Arrays.asList("restart level", "return to menu");
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

    public boolean isSelectedRestart() {
        return isSelected(0);
    }

    public boolean isSelectedQuit() {
        return isSelected(1);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}

