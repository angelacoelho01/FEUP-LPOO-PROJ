package com.escapethemansion.controller;

import com.escapethemansion.controller.game.BoxController;
import com.escapethemansion.controller.game.PlayerController;
import com.escapethemansion.gui.GUI;
import com.escapethemansion.model.game.Position;
import com.escapethemansion.model.game.element.Box;
import com.escapethemansion.model.game.floor.Floor;
import com.escapethemansion.model.game.floor.FloorBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class BoxControllerTest {

    private BoxController boxController;

    @BeforeEach
    void setup() throws IOException {
        Floor floor = new FloorBuilder("src/test/resources/floors/floor.map").createFloor();
        this.boxController = new BoxController(floor);
    }

    @Test
    void getFloor() throws IOException {
        Floor test = new FloorBuilder("src/test/resources/floors/floor.map").createFloor();
        assertEquals(this.boxController.getModel(), test);
    }

    @Test
    void getBox(){
        assertEquals(this.boxController.getModel().getBoxes().get(0), new Box(new Position(25,12)));
    }

    @Test
    void setBox(){
        this.boxController.getModel().getBoxes().get(0).setPosition(new Position(25,13));
        assertEquals(this.boxController.getModel().getBoxes().get(0), new Box(new Position(25,13)));
    }

    @Test
    void canBoxMove(){
        assertFalse(this.boxController.canElementMove(new Position(26,12)));
        assertTrue(this.boxController.canElementMove(new Position(25,13)));
    }

}
