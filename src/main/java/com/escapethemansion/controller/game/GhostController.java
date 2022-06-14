package com.escapethemansion.controller.game;

import com.escapethemansion.Game;
import com.escapethemansion.gui.GUI;
import com.escapethemansion.model.game.element.*;
import com.escapethemansion.model.game.Position;
import com.escapethemansion.model.game.floor.Floor;

import java.io.IOException;
import java.util.Random;

public class GhostController extends ElementController{

    private Ghost ghost;
    private long lastMovement;

    public GhostController(Floor floor) {
        super(floor);
        this.lastMovement = 0;
    }

    public Ghost getGhost() {
        return this.ghost;
    }

    public void setGhost(Ghost ghost) {
        this.ghost = ghost;
    }

    public void moveElementUp() {
        moveElement(this.getGhost().getPosition().getUp());
    }

    public void moveElementRight() {
        moveElement(this.getGhost().getPosition().getRight());
    }

    public void moveElementDown() {
        moveElement(this.getGhost().getPosition().getDown());
    }

    public void moveElementLeft() {
        moveElement(this.getGhost().getPosition().getLeft());
    }

    public void moveElement(Position position) {
            if(canElementMove(position))
                this.getGhost().setPosition(position);
    }

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

        if(this.getModel().getPlayer().getPosition().equals(position)){
            this.getModel().getPlayer().getLife().decreaseValue();
            return false;
        }
        return true;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if(time - lastMovement > 500) {
            Random rand = new Random();
            for (Ghost g : this.getModel().getGhosts()) {
                this.setGhost(g);
                int randAction = rand.nextInt(4);

                if (randAction == 0) moveElementUp();
                else if (randAction == 1) moveElementRight();
                else if (randAction == 2) moveElementDown();
                else moveElementLeft();
            }
            this.lastMovement = time;
        }
    }
}
