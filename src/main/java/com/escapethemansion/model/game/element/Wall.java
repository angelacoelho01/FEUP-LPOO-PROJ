package com.escapethemansion.model.game.element;

import com.escapethemansion.model.game.Position;

public class Wall extends Element{
    public Wall(Position position) {
        super(position);
        this.appearance = "#";
        this.color = "#8C2D19";
    }
}
