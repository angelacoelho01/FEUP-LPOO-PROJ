package com.escapethemansion.model.game.element;

import com.escapethemansion.model.game.Position;

public class Key extends Element{
    public Key(Position position) {
        super(position);
        this.appearance = "K";
        this.color = "#FFFF00";
    }
}
