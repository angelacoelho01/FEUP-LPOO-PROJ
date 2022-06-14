package com.escapethemansion.model.game.element;

import com.escapethemansion.model.game.Position;

public class EndLevel extends Element{
    public EndLevel(Position position) {
        super(position);

        this.appearance = "P";
        this.color = "#3111A6";
    }
}
