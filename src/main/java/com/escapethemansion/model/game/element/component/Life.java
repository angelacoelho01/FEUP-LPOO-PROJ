package com.escapethemansion.model.game.element.component;

import com.escapethemansion.model.game.Position;

public class Life extends PlayerComponent{
    public Life(int value) {
        super(value);
        this.color = "#B70F0A";
        this.text = "life";
        this.position = new Position(1, 8);
    }

    public void decreaseValue() {
        this.value -= 10;
    }

    public void attack(int value) {
        this.value -= value;
    }

}
