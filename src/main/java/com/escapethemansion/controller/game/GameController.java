package com.escapethemansion.controller.game;

import com.escapethemansion.controller.Controller;
import com.escapethemansion.model.game.floor.Floor;

public abstract class GameController extends Controller<Floor> {
    public GameController(Floor floor) {
        super(floor);
    }
}
