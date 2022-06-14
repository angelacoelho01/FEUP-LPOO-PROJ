package com.escapethemansion.viewer.menu;

import com.escapethemansion.gui.GUI;
import com.escapethemansion.model.menu.Menu;
import com.escapethemansion.model.game.Position;
import com.escapethemansion.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(12, 5), "escape the mansion", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++){
            Position toDraw = new Position(19, 12 + 3 * i);

            if (i == 1)
                toDraw = toDraw.addX(-2);

            gui.drawText(
                    toDraw,
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}
