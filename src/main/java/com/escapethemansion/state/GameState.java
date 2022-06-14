package com.escapethemansion.state;

import com.escapethemansion.controller.Controller;
import com.escapethemansion.controller.game.FloorController;
import com.escapethemansion.model.game.floor.Floor;
import com.escapethemansion.viewer.Viewer;
import com.escapethemansion.viewer.game.GameViewer;

public class GameState extends State<Floor>{
    private FloorController floorController;

    public GameState(Floor floor) {
        super(floor);
    }


    @Override
    protected Viewer<Floor> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Floor> getController() {
        return new FloorController(getModel());
    }
}
