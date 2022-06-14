package com.escapethemansion.model.menu;

import java.util.Arrays;
import java.util.List;

public class LevelComplete {
    private final List<String> entries;
    private int currentEntry = 0;
    private int pointsLevel;
    private int totalPoints;

    public LevelComplete(int points, int totalPoints) {
        this.entries = Arrays.asList("return to menu", "next level");
        this.pointsLevel = points;
        this.totalPoints = totalPoints;
    }

    public int getPoints() {
        return pointsLevel;
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

    public boolean isSelectedNextLevel() {
        return isSelected(1);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
