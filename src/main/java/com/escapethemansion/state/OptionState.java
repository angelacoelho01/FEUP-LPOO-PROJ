package com.escapethemansion.state;

import com.escapethemansion.controller.Controller;
import com.escapethemansion.controller.menu.OptionsController;
import com.escapethemansion.model.menu.Options;
import com.escapethemansion.viewer.Viewer;
import com.escapethemansion.viewer.menu.OptionsViewer;

public class OptionState extends State<Options>{
    public OptionState(Options model) {
        super(model);
    }

    @Override
    protected Viewer<Options> getViewer() {
        return new OptionsViewer(getModel());
    }

    @Override
    protected Controller<Options> getController() {
        return new OptionsController(getModel());
    }
}
