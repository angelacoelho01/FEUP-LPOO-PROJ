package com.escapethemansion.viewer.menu;

import com.escapethemansion.gui.GUI;
import com.escapethemansion.model.game.Position;
import com.escapethemansion.model.menu.Pause;
import com.escapethemansion.viewer.Viewer;

public class PauseViewer extends Viewer<Pause> {
    public PauseViewer(Pause pause) {
        super(pause);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(18, 5), "paused", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++){
            Position toDraw = new Position(14, 12 + 3 * i);

            if (i == 0)
                toDraw = toDraw.addX(4);
            if (i == 1)
                toDraw = toDraw.addX(3);

            gui.drawText(
                    toDraw,
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#7E2199" : "#FFFFFF");
        }

    }
}
