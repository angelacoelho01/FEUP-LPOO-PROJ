package com.escapethemansion.state;

import com.escapethemansion.controller.Controller;
import com.escapethemansion.controller.menu.LevelCompleteController;
import com.escapethemansion.model.menu.LevelComplete;
import com.escapethemansion.viewer.Viewer;
import com.escapethemansion.viewer.menu.LevelCompleteViewer;

public class LevelCompleteState extends State<LevelComplete>{

    public LevelCompleteState(LevelComplete model) {
        super(model);
    }

    @Override
    protected Viewer<LevelComplete> getViewer() {
        return new LevelCompleteViewer(getModel());
    }

    @Override
    protected Controller<LevelComplete> getController() {
        return new LevelCompleteController(getModel());
    }
}
