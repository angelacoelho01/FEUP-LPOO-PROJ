package com.escapethemansion.state;

import com.escapethemansion.controller.Controller;
import com.escapethemansion.controller.menu.MenuController;
import com.escapethemansion.model.menu.Menu;
import com.escapethemansion.viewer.menu.MenuViewer;
import com.escapethemansion.viewer.Viewer;

public class MenuState extends State<Menu>{
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
            return new MenuViewer(getModel());
        }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
