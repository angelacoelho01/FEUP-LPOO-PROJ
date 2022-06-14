package com.escapethemansion.controller;

import com.escapethemansion.controller.game.PlayerController;
import com.escapethemansion.model.game.Position;
import com.escapethemansion.model.game.element.Player;
import com.escapethemansion.model.game.floor.Floor;
import com.escapethemansion.model.game.floor.FloorBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

// TODO : CORRIGIR OS TESTES
public class PlayerControllerTest {

    private PlayerController playerController;

    @BeforeEach
    void setup() throws IOException {
        Floor floor = new FloorBuilder("src/test/resources/floors/floor.map").createFloor();
        this.playerController = new PlayerController(floor);
    }

    @Test
    void getFloor() throws IOException {
        Floor test = new FloorBuilder("src/test/resources/floors/floor.map").createFloor();
        assertEquals(this.playerController.getModel(), test);
    }

    @Test
    void getPlayer(){
        assertEquals(this.playerController.getModel().getPlayer(), new Player(new Position(18,21)));
    }

    @Test
    void setPlayer(){
        this.playerController.getModel().getPlayer().setPosition(new Position(20,13));
        assertEquals(this.playerController.getModel().getPlayer(), new Player(new Position(20,13)));
    }

    @Test
    void canPlayerMove() {
        assertFalse(this.playerController.canElementMove(new Position(18,22)));
        assertTrue(this.playerController.canElementMove(new Position(18,20)));
    }

    @Test
    void catchKey() {
        this.playerController.moveElementRight();
        assertEquals(this.playerController.getModel().getPlayer().getNumKeys(), 1);
    }

    @Test
    void fallToHole() {
        this.playerController.moveElementLeft();
        assertEquals(this.playerController.getModel().getPlayer().getLife().getValue(), 0);
    }

    @Test
    void attackGhost() {
        this.playerController.getModel().getPlayer().setStrength(50);
        this.playerController.getModel().getPlayer().setPosition(new Position(23, 9));
        this.playerController.moveElementRight();
        assertEquals(this.playerController.getModel().getGhosts().get(0).getLife().getValue(), 50);
        this.playerController.getModel().getPlayer().setStrength(50);
        assertEquals(this.playerController.getModel().getGhosts().get(0).getLife().getValue(), 50);
    }

    @Test
    void pushBox() {
        Position position = this.playerController.getModel().getBoxes().get(0).getPosition();
        this.playerController.getModel().getPlayer().setPosition(new Position(25, 11));
        this.playerController.moveElementDown();
        assertEquals(this.playerController.getModel().getBoxes().get(0).getPosition(), new Position(25,13));
    }

    @Test
    void pickWeapon() {
        this.playerController.moveElementUp();
        assertEquals(this.playerController.getModel().getPlayer().getStrength(), 50);
        assertEquals(this.playerController.getModel().getPlayer().getAppearance(), "W");
    }

    @Test
    void pickBattery() {
        this.playerController.getModel().getPlayer().getBattery().setValue(50);
        this.playerController.getModel().getPlayer().setPosition(new Position(18, 18));
        this.playerController.moveElementUp();
        assertEquals(this.playerController.getModel().getPlayer().getBattery().getValue(), 60);
    }
}
