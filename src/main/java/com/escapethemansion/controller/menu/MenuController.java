package com.escapethemansion.controller.menu;

import com.escapethemansion.Game;
import com.escapethemansion.controller.Controller;
import com.escapethemansion.gui.GUI;
import com.escapethemansion.model.game.floor.FloorBuilder;
import com.escapethemansion.model.menu.Options;
import com.escapethemansion.state.GameState;
import com.escapethemansion.model.menu.Menu;
import com.escapethemansion.state.OptionState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
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
                if (getModel().isSelectedPlay()){
                    game.getMansion().resetFloors();
                    game.setState(new GameState(game.getMansion().getFloors().get(0)));
                }
                if (getModel().isSelectedOptions()) game.setState(new OptionState(new Options(game.getGUI())));
                if (getModel().isSelectedQuit()) game.setState(null);
                break;
        }
    }
}