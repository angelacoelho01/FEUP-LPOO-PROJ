package com.escapethemansion.model.game.element;

import com.escapethemansion.model.game.Position;

public class Box extends Element{
    public Box(Position position) {
        super(position);
        this.appearance = "B";
        this.color = "#B76F20";
    }
}
