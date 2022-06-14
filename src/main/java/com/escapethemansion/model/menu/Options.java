package com.escapethemansion.model.menu;

import com.escapethemansion.gui.GUI;
import com.escapethemansion.gui.LanternaGUI;
import com.escapethemansion.model.game.element.Key;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.*;

public class Options {
    private final List<String> entries;
    private int currentEntry = 0;
    private LanternaGUI gui;
    private boolean selectedJumpWASD;
    private boolean currentSelectedJump;

    public Options(LanternaGUI gui) {
        this.entries = Arrays.asList("jump with arrow keys", "jump with wasd", "return to menu");
        this.gui = gui;
        this.selectedJumpWASD = true;
        this.currentSelectedJump = true; //if true Jump with WASD else Jump with Arrow Keys
    }

    public boolean getSelectedJumpWASD() {
        return this.selectedJumpWASD;
    }

    public void setSelectedJumpWASD(boolean newSelectedJumpWASD) {
        this.selectedJumpWASD = currentSelectedJump;
    }

    public void setCurrentSelectedJump(boolean newCurrentSelectedJump) {
        this.currentSelectedJump = newCurrentSelectedJump;
    }

    public void updateJumpKeysWASD() {
        gui.getKeyAction().replace(KeyType.ArrowUp, GUI.ACTION.UP);
        gui.getKeyAction().replace(KeyType.ArrowDown, GUI.ACTION.DOWN);
        gui.getKeyAction().replace(KeyType.ArrowLeft, GUI.ACTION.LEFT);
        gui.getKeyAction().replace(KeyType.ArrowRight, GUI.ACTION.RIGHT);

        gui.getCharAction().replace('w', GUI.ACTION.JUMPUP);
        gui.getCharAction().replace('s', GUI.ACTION.JUMPDOWN);
        gui.getCharAction().replace('a', GUI.ACTION.JUMPLEFT);
        gui.getCharAction().replace('d', GUI.ACTION.JUMPRIGHT);
    }

    public void updateJumpKeysArrows() {
        gui.getKeyAction().replace(KeyType.ArrowUp, GUI.ACTION.JUMPUP);
        gui.getKeyAction().replace(KeyType.ArrowDown, GUI.ACTION.JUMPDOWN);
        gui.getKeyAction().replace(KeyType.ArrowLeft, GUI.ACTION.JUMPLEFT);
        gui.getKeyAction().replace(KeyType.ArrowRight, GUI.ACTION.JUMPRIGHT);

        gui.getCharAction().replace('w', GUI.ACTION.UP);
        gui.getCharAction().replace('s', GUI.ACTION.DOWN);
        gui.getCharAction().replace('a', GUI.ACTION.LEFT);
        gui.getCharAction().replace('d', GUI.ACTION.RIGHT);

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

    public boolean isSelectedJumpArrowKeys() {
        return isSelected(0);
    }

    public boolean isSelectedJumpWASD() {
        return isSelected(1);
    }

    public boolean isSelectedQuit() {
        return isSelected(2);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}
