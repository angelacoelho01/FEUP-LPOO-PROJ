package com.escapethemansion.controller.game;

import com.escapethemansion.Game;
import com.escapethemansion.gui.GUI;
import com.escapethemansion.model.game.Position;
import com.escapethemansion.model.game.floor.Floor;
import com.escapethemansion.model.game.element.Box;

import java.io.IOException;

public class BoxController extends ElementController{

    private Box box;

    public BoxController(Floor floor) {
        super(floor);
    }

    public Box getBox() {
        return this.box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public void moveElementUp() {
        moveElement(this.getBox().getPosition().getUp());
    }

    public void moveElementRight() {
        moveElement(this.getBox().getPosition().getRight());
    }

    public void moveElementDown() {
        moveElement(this.getBox().getPosition().getDown());
    }

    public void moveElementLeft() {
        moveElement(this.getBox().getPosition().getLeft());
    }

    public void moveElement(Position position) {
        if(canElementMove(position))
            this.getBox().setPosition(position);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
    }
}
