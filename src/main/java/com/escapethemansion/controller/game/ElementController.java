package com.escapethemansion.controller.game;

import com.escapethemansion.model.game.element.*;
import com.escapethemansion.model.game.Position;
import com.escapethemansion.model.game.floor.Floor;

import java.util.Objects;

public abstract class ElementController extends GameController {

    public ElementController (Floor model) {
        super(model);
    }

    public abstract void moveElementUp();

    public abstract void moveElementRight();

    public abstract void moveElementDown();

    public abstract void moveElementLeft();

    public abstract void moveElement(Position position);

    public boolean canElementMove(Position position){
        for (Wall wall : this.getModel().getWalls())
            if (wall.getPosition().equals(position)) return false;

        for (Ghost ghost : this.getModel().getGhosts())
            if (ghost.getPosition().equals(position)) return false;

        for (Key key : this.getModel().getKeys())
            if (key.getPosition().equals(position)) return false;

        for (Box box : this.getModel().getBoxes())
            if (box.getPosition().equals(position)) return false;

        for (Door door : this.getModel().getDoors())
            if (door.getPosition().equals(position)) return false;

        if(this.getModel().getWeapon() != null && this.getModel().getWeapon().getPosition().equals(position)) return false;

        return !this.getModel().getPlayer().getPosition().equals(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElementController that = (ElementController) o;
        return Objects.equals(this.getModel(), that.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getModel());
    }
}
