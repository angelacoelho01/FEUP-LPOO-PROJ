package com.escapethemansion.viewer.game;

import com.escapethemansion.gui.GUI;
import com.escapethemansion.model.game.element.Element;
import com.escapethemansion.model.game.floor.Floor;

public class ElementViewer<T extends Element> {
    void drawElement(GUI gui, T element) {
        gui.drawElement(element);
    }
}
