package com.escapethemansion.model.game.element;

import com.escapethemansion.model.game.Position;

public class Weapon extends Element{

    private int power;

    public Weapon(Position position) {
        super(position);
        this.appearance = "W";
        this.color = "#AAAAAA";
        this.power = 50;
    }

    public int getPower() {
        return power;
    }

    public void catchWeapon(Player player) {
        player.setAppearance(this.appearance);
        player.setStrength(this.power);
        this.color = "#000000";
    }
}
