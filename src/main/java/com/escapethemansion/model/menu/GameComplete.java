package com.escapethemansion.model.menu;

import java.util.Arrays;
import java.util.List;

public class GameComplete {

    private final List<String> entries;
    private int currentEntry = 0;
    private int totalPoints;

    public GameComplete(int totalPoints) {
        this.entries = Arrays.asList("return to menu");
        this.totalPoints = totalPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
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

    public boolean isSelectedQuit() {
        return isSelected(0);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
