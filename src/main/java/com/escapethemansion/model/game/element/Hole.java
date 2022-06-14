package com.escapethemansion.model.game.element;

import com.escapethemansion.model.game.Position;

public class Hole extends Element{

    public Hole(Position position) {
        super(position);
        this.appearance = "H";
        this.color = "#A1A9A8";
    }
}
