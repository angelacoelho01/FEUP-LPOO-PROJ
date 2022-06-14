package com.escapethemansion.model;

import com.escapethemansion.model.game.Mansion;
import com.escapethemansion.model.game.floor.Floor;
import com.escapethemansion.model.game.floor.FloorBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MansionTest {

    private Mansion mansion;

    @BeforeEach
    public void setup() throws IOException {
        this.mansion = new Mansion();
    }

    @Test
    public void getFloors() throws IOException {
        List<Floor> test = new ArrayList<>();
        test.add(new FloorBuilder("src/main/resources/floors/basement.map").createFloor());
        test.add(new FloorBuilder("src/main/resources/floors/1stfloor.map").createFloor());
        test.add(new FloorBuilder("src/main/resources/floors/2ndfloor.map").createFloor());
        test.add(new FloorBuilder("src/main/resources/floors/attic.map").createFloor());
        assertEquals(this.mansion.getFloors(), test);
    }

    @Test
    public void resetFloors() throws IOException {
        List<Floor> test = new ArrayList<>();
        test.add(new FloorBuilder("src/main/resources/floors/basement.map").createFloor());
        test.add(new FloorBuilder("src/main/resources/floors/1stfloor.map").createFloor());
        test.add(new FloorBuilder("src/main/resources/floors/2ndfloor.map").createFloor());
        test.add(new FloorBuilder("src/main/resources/floors/attic.map").createFloor());
        this.mansion.getFloors().add(new FloorBuilder("src/test/resources/floors/floor.map").createFloor());
        this.mansion.resetFloors();
        assertEquals(this.mansion.getFloors(), test);
    }
}
