package com.escapethemansion.model.game.element;

import com.escapethemansion.model.game.Position;

public class Door extends Element{

    public Door(Position position, boolean vertical){
        super(position);

        if(vertical)
            this.appearance = "|";
        else
            this.appearance = "-";

        this.color = "#A66317";
    }
}
