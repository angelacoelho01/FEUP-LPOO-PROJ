package com.escapethemansion.model.game.element;

import com.escapethemansion.model.game.Position;

public class Battery extends Element{
    public Battery(Position position) {
        super(position);
        this.appearance = "F";
        this.color = "#00FFFF";
    }
}