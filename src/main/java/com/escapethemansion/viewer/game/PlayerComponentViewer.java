package com.escapethemansion.viewer.game;

import com.escapethemansion.gui.GUI;
import com.escapethemansion.model.game.element.component.PlayerComponent;

public class PlayerComponentViewer<T extends PlayerComponent> {
    void drawPlayerComponent(GUI gui, T playerComponent) {
        gui.drawPlayerComponent(playerComponent);
    }

}
