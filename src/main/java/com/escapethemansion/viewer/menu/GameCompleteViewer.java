package com.escapethemansion.viewer.menu;

import com.escapethemansion.gui.GUI;
import com.escapethemansion.model.game.Position;
import com.escapethemansion.model.menu.GameComplete;
import com.escapethemansion.viewer.Viewer;

public class GameCompleteViewer  extends Viewer<GameComplete> {
    public GameCompleteViewer(GameComplete gameComplete) {
        super(gameComplete);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(14, 5), "game complete", "#FCA52B");

        //total score of game
        drawPoints(gui);

        gui.drawText(new Position(10, 11), "thank you for playing", "#FFFFFF");
        gui.drawText(new Position(11, 12), "escape the mansion!", "#FFFFFF");

        gui.drawText(new Position(11, 17), "Xfeup-lpoo-2021-g11", "#FFFFFF");
        gui.drawText(new Position(12, 19) , "ana matilde barra", "#FFFFFF");
        gui.drawText(new Position(14, 20) , "angela coelho", "#FFFFFF");
        gui.drawText(new Position(15, 21) , "nuno castro", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            Position toDraw = new Position(13, 24 + 2 * i);

            gui.drawText(
                    toDraw,
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FCA52B" : "#FFFFFF");
        }
    }

    private void drawPoints(GUI gui){
        gui.drawText(new Position(11, 8), "total points: " + getModel().getTotalPoints(), "#FFFFFF");
    }
}
