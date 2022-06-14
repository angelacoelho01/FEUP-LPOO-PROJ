package com.escapethemansion.model.game.element.component;

import com.escapethemansion.model.game.Position;

public class Fear extends PlayerComponent{
    public Fear(int value) {
        super(value);
        this.color = "#7E2199";
        this.text = "fear";
        this.position = new Position(1, 10);
    }

    @Override
    public void increaseValue() {
        if(this.value <= 95)
            this.value += 5;
    }

    @Override
    public void decreaseValue() {
        if(this.value >= 10)
            this.value -= 10;
        else if(this.value == 5)
            this.value = 0;
    }
}
