package com.escapethemansion.controller.menu;

import com.escapethemansion.Game;
import com.escapethemansion.controller.Controller;
import com.escapethemansion.gui.GUI;
import com.escapethemansion.model.menu.GameComplete;
import com.escapethemansion.model.menu.LevelComplete;
import com.escapethemansion.model.menu.Menu;
import com.escapethemansion.state.GameCompleteState;
import com.escapethemansion.state.GameState;
import com.escapethemansion.state.MenuState;

import java.io.IOException;

public class LevelCompleteController extends Controller<LevelComplete> {
    public LevelCompleteController(LevelComplete levelComplete) {
        super(levelComplete);
    }


    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case LEFT:
                getModel().previousEntry();
                break;
            case RIGHT:
                getModel().nextEntry();
                break;
            case SELECT:
                int nextLevel = game.getFloorInd() + 1;
                if (getModel().isSelectedQuit()) {
                    game.resetTotalPoints();
                    game.setState(new MenuState(new Menu()));
                }
                if (getModel().isSelectedNextLevel()) {
                    if (nextLevel >= game.getMansion().getFloors().size())
                        game.setState(new GameCompleteState(new GameComplete(game.getTotalPoints())));
                    else {
                        game.setFloorInd(nextLevel);
                        game.setState(new GameState(game.getMansion().getFloors().get(game.getFloorInd())));
                    }
                }
                break;
        }
    }
}
