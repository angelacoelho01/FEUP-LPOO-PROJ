package com.escapethemansion.viewer.menu;

import com.escapethemansion.gui.GUI;
import com.escapethemansion.model.game.Position;
import com.escapethemansion.model.menu.Options;
import com.escapethemansion.viewer.Viewer;

public class OptionsViewer  extends Viewer<Options> {
    public OptionsViewer(Options options) {
        super(options);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(19, 5), "options", "#25BAF5");
        gui.drawText(new Position(8, 8), "select the keys used to jump", "#FFFFFF");

        gui.drawText(new Position(6, 10), "beware - the keys used to movement", "#FFFFFF");
        gui.drawText(new Position(5, 11) , "are used to control the menus as well", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            Position toDraw = new Position(15, 15 + 2 * i);

            if (i == 0)
                toDraw = toDraw.addX(-3);
            if (i == 2)
                toDraw = toDraw.addY(3);

            gui.drawText(
                    toDraw,
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#25BAF5" : "#FFFFFF");
        }
    }
}
