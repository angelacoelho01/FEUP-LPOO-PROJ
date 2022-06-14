package com.escapethemansion.model.game.element;

import com.escapethemansion.model.game.Position;
import com.escapethemansion.model.game.element.component.Life;

public class Ghost extends Element{

    private Life life;

    public Ghost(Position position) {
        super(position);
        this.appearance = "G";
        this.color = "#FFFFFF";
        this.life = new Life(100);
    }

    public Life getLife() {
        return life;
    }
}
