package com.escapethemansion.state;

import com.escapethemansion.controller.Controller;
import com.escapethemansion.controller.menu.GameOverController;
import com.escapethemansion.model.menu.GameOver;
import com.escapethemansion.viewer.Viewer;
import com.escapethemansion.viewer.menu.GameOverViewer;

public class GameOverState extends State<GameOver>{

    public GameOverState(GameOver model) {
        super(model);
    }

    @Override
    protected Viewer<GameOver> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOver> getController() {
        return new GameOverController(getModel());
    }
}
