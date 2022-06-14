package com.escapethemansion.model.game.element.component;

import com.escapethemansion.model.game.Position;

public class FlashLight extends PlayerComponent{
    public FlashLight(int value) {
        super(value);
        this.color = "#F4EB49";
        this.text = "battery";
        this.position = new Position(1, 12);
    }

    @Override
    public void increaseValue() {
        if(this.value < 100)
            this.value += 10;
    }

    @Override
    public void decreaseValue() {
        if(this.value > 0)
            this.value -= 10;
    }
}
