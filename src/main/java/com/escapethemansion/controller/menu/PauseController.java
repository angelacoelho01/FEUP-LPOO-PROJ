package com.escapethemansion.controller.menu;

import com.escapethemansion.Game;
import com.escapethemansion.controller.Controller;
import com.escapethemansion.controller.game.FloorController;
import com.escapethemansion.gui.GUI;
import com.escapethemansion.model.game.floor.FloorBuilder;
import com.escapethemansion.model.menu.Menu;
import com.escapethemansion.model.menu.Options;
import com.escapethemansion.model.menu.Pause;
import com.escapethemansion.state.GameState;
import com.escapethemansion.state.MenuState;
import com.escapethemansion.state.OptionState;

import java.io.IOException;

public class PauseController extends Controller<Pause> {
    public PauseController(Pause pause) {
        super(pause);
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
                if (getModel().isSelectedPlay()) game.setState(new GameState(getModel().getFloor()));
                if (getModel().isSelectedRestart()) {
                    game.getMansion().resetFloors();
                    getModel().getFloor().getTimer().endTimer();
                    game.setState(new GameState(game.getMansion().getFloors().get(game.getFloorInd())));
                }
                if (getModel().isSelectedQuit()) {
                    getModel().getFloor().getTimer().endTimer();
                    game.resetTotalPoints();
                    game.setState(new MenuState(new Menu()));
                }
                break;
        }
    }
}
