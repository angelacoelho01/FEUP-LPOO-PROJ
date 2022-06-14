package com.escapethemansion.controller.menu;

import com.escapethemansion.Game;
import com.escapethemansion.controller.Controller;

import com.escapethemansion.gui.GUI;
import com.escapethemansion.model.menu.Menu;
import com.escapethemansion.model.menu.Options;
import com.escapethemansion.state.GameState;
import com.escapethemansion.state.MenuState;

import java.io.IOException;

public class OptionsController extends Controller<Options> {
    public OptionsController(Options model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedQuit()) {
                    game.setState(new MenuState(new Menu()));
                }
                if (getModel().isSelectedJumpArrowKeys()) {
                    getModel().updateJumpKeysArrows();
                    game.setState(new MenuState(new Menu()));
                }
                if (getModel().isSelectedJumpWASD()) {
                    getModel().updateJumpKeysWASD();
                    game.setState(new MenuState(new Menu()));
                }
                break;
        }
    }
}
