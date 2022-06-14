package com.escapethemansion.controller.game;

import com.escapethemansion.Game;
import com.escapethemansion.gui.GUI;

import com.escapethemansion.model.game.Position;
import com.escapethemansion.model.game.element.*;
import com.escapethemansion.model.game.floor.Floor;

import java.io.IOException;

public class PlayerController extends ElementController{

    private final BoxController boxController;
    private int directionSel;

    public PlayerController (Floor floor) {
        super(floor);
        this.boxController = new BoxController(floor);
    }

    public BoxController getBoxController() {
        return boxController;
    }

    public void moveElementUp() {
        this.setDirectionSel(0);
        moveElement(this.getModel().getPlayer().getPosition().getUp());
    }

    public void moveElementRight() {
        this.setDirectionSel(1);
        moveElement(this.getModel().getPlayer().getPosition().getRight());
    }

    public void moveElementDown() {
        this.setDirectionSel(2);
        moveElement(this.getModel().getPlayer().getPosition().getDown());
    }

    public void moveElementLeft() {
        this.setDirectionSel(3);
        moveElement(this.getModel().getPlayer().getPosition().getLeft());
    }

    public void jumpElementUp() {
        this.setDirectionSel(-1);
        if(canElementMove(this.getModel().getPlayer().getPosition().getUp())) {
            moveElement(this.getModel().getPlayer().getPosition().getUp());
            moveElementUp();
            this.inHole(this.getModel().getPlayer().getPosition());
        }
    }

    public void jumpElementRight() {
        this.setDirectionSel(-1);
        if(canElementMove(this.getModel().getPlayer().getPosition().getRight())) {
            moveElement(this.getModel().getPlayer().getPosition().getRight());
            moveElementRight();
            this.inHole(this.getModel().getPlayer().getPosition());
        }
    }

    public void jumpElementDown() {
        this.setDirectionSel(-1);
        if(canElementMove(this.getModel().getPlayer().getPosition().getDown())) {
            moveElement(this.getModel().getPlayer().getPosition().getDown());
            moveElementDown();
            this.inHole(this.getModel().getPlayer().getPosition());
        }
    }

    public void jumpElementLeft() {
        this.setDirectionSel(-1);
        if (canElementMove(this.getModel().getPlayer().getPosition().getLeft())){
            moveElement(this.getModel().getPlayer().getPosition().getLeft());
            moveElementLeft();
            this.inHole(this.getModel().getPlayer().getPosition());
        }
    }

    public boolean canElementMove(Position position) {
        for (Wall wall : this.getModel().getWalls())
            if (wall.getPosition().equals(position)) return false;

        for (Key key : this.getModel().getKeys()) {
            if (key.getPosition().equals(position))
                return this.getModel().collectPlayerKey(key);
        }

        for (Hole hole : this.getModel().getHoles()) {
            if (hole.getPosition().equals(position)) {
                if (this.getDirectionSel() != -1)
                    this.getModel().getPlayer().getLife().setValue(0);
            }
        }

        for (Ghost ghost : this.getModel().getGhosts()) {
            if (ghost.getPosition().equals(position)) {
                this.getModel().getPlayer().getFear().increaseValue();
                ghost.getLife().attack(this.getModel().getPlayer().getStrength());

                if (ghost.getLife().getValue() <= 0){
                    this.getModel().getGhosts().remove(ghost);
                    this.getModel().addPoints(500);
                    System.out.println("Ghost killed!");
                }

                return false;
            }
        }

        for (Door door : this.getModel().getDoors()) {
            if (door.getPosition().equals(position)) {
                return false;
            }
        }

        if (this.getModel().getWeapon() != null && this.getModel().getWeapon().getPosition().equals(position)){
            getModel().getWeapon().catchWeapon(getModel().getPlayer());
            getModel().removeWeapon();
        }

        for (Box box : this.getModel().getBoxes()) {
            if (box.getPosition().equals(position)) {
                this.getBoxController().setBox(box);

                if (this.getDirectionSel() == -1)
                    return false;
                if (this.getDirectionSel() == 0)
                    this.getBoxController().moveElementUp();
                else if (this.getDirectionSel() == 1)
                    this.getBoxController().moveElementRight();
                else if (this.getDirectionSel() == 2)
                    this.getBoxController().moveElementDown();
                else if (this.getDirectionSel() == 3)
                    this.getBoxController().moveElementLeft();

                return !(this.getBoxController().getBox().getPosition().equals(position));
            }
        }

        for (Battery battery : this.getModel().getBatteries()) {
            if(battery.getPosition().equals(position)) {
                this.getModel().removeBattery(battery);
                this.getModel().getPlayer().getBattery().increaseValue();
                return true;
            }
        }

        return true;
    }

    public void moveElement(Position position) {
        if(canElementMove(position))
            this.getModel().getPlayer().setPosition(position);
    }

    public void inHole(Position position){
        for (Hole hole : this.getModel().getHoles()) {
            if (hole.getPosition().equals(position)) {
                this.getModel().getPlayer().getLife().setValue(0);
            }
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.UP) moveElementUp();
        if (action == GUI.ACTION.RIGHT) moveElementRight();
        if (action == GUI.ACTION.DOWN) moveElementDown();
        if (action == GUI.ACTION.LEFT) moveElementLeft();
        if (action == GUI.ACTION.JUMPUP) jumpElementUp();
        if (action == GUI.ACTION.JUMPDOWN) jumpElementDown();
        if (action == GUI.ACTION.JUMPLEFT) jumpElementLeft();
        if (action == GUI.ACTION.JUMPRIGHT) jumpElementRight();
    }

    public int getDirectionSel() {
        return directionSel;
    }

    public void setDirectionSel(int directionSel) {
        this.directionSel = directionSel;
    }
}


