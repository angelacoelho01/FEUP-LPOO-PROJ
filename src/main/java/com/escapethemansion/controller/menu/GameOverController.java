package com.escapethemansion.controller.menu;

import com.escapethemansion.Game;
import com.escapethemansion.controller.Controller;
import com.escapethemansion.gui.GUI;
import com.escapethemansion.model.game.floor.FloorBuilder;
import com.escapethemansion.model.menu.GameOver;
import com.escapethemansion.model.menu.Menu;
import com.escapethemansion.state.GameState;
import com.escapethemansion.state.MenuState;

import java.io.IOException;

public class GameOverController extends Controller<GameOver> {
    public GameOverController(GameOver gameOver) {
        super(gameOver);
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
                if (getModel().isSelectedRestart()){
                    game.getMansion().resetFloors();
                    game.setState(new GameState(game.getMansion().getFloors().get(game.getFloorInd())));
                } //reiniciar o nível que se perdeu
                if (getModel().isSelectedQuit()){
                    game.resetTotalPoints();
                    game.setState(new MenuState(new Menu()));
                }
                break;
        }
    }
}

