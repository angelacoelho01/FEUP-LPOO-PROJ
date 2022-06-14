package com.escapethemansion.controller.menu;

import com.escapethemansion.Game;
import com.escapethemansion.controller.Controller;
import com.escapethemansion.gui.GUI;
import com.escapethemansion.model.menu.GameComplete;
import com.escapethemansion.model.menu.Menu;
import com.escapethemansion.state.MenuState;

import java.io.IOException;

public class GameCompleteController extends Controller<GameComplete> {
    public GameCompleteController(GameComplete model) {
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
                    game.resetTotalPoints();
                    game.setState(new MenuState(new Menu()));
                }
                break;
        }
    }
}
