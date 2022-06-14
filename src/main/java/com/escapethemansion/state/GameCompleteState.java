package com.escapethemansion.state;

import com.escapethemansion.controller.Controller;
import com.escapethemansion.controller.menu.GameCompleteController;
import com.escapethemansion.model.menu.GameComplete;
import com.escapethemansion.viewer.Viewer;
import com.escapethemansion.viewer.menu.GameCompleteViewer;

public class GameCompleteState extends State<GameComplete>{

    public GameCompleteState(GameComplete model) {
        super(model);
    }

    @Override
    protected Viewer<GameComplete> getViewer() {
        return new GameCompleteViewer(getModel());
    }

    @Override
    protected Controller<GameComplete> getController() {
        return new GameCompleteController(getModel());
    }
}
