package com.escapethemansion.state;


import com.escapethemansion.controller.Controller;
import com.escapethemansion.controller.menu.PauseController;
import com.escapethemansion.model.menu.Pause;
import com.escapethemansion.viewer.menu.PauseViewer;
import com.escapethemansion.viewer.Viewer;

public class PauseState extends State<Pause>{

    public PauseState(Pause model) {
        super(model);
    }

    @Override
    protected Viewer<Pause> getViewer() {
        return new PauseViewer(getModel());
    }

    @Override
    protected Controller<Pause> getController() {
        return new PauseController(getModel());
    }
}
