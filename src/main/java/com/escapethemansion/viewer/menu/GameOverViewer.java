package com.escapethemansion.viewer.menu;

import com.escapethemansion.gui.GUI;
import com.escapethemansion.model.game.Position;
import com.escapethemansion.model.menu.GameOver;
import com.escapethemansion.viewer.Viewer;

public class GameOverViewer extends Viewer<GameOver> {
    public GameOverViewer(GameOver gameOver) {
        super(gameOver);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(16, 5), "game over", "#CC0000");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5 + 20*i, 20),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#CC0000" : "#FFFFFF");
    }
}