package com.escapethemansion.model.game.timer;

import com.escapethemansion.model.game.floor.FloorBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TimeTest {

    private Time time;

    @BeforeEach
    void setup() {
        this.time = new Time(30, 5);
    }

    @Test
    public void getSecond() {
        assertEquals(this.time.getSecond(), 30);
    }

    @Test
    public void getMinute() {
        assertEquals(this.time.getMinute(), 5);
    }

    @Test
    public void reduceTime() throws IOException {
        assertTrue(this.time.reduceTime(true, new FloorBuilder("./src/test/resources/floors/floor.map").createFloor()));

        this.time = new Time(0, 0);
        assertFalse(this.time.reduceTime(false, new FloorBuilder("./src/test/resources/floors/floor.map").createFloor()));

        this.time = new Time(0, 5);
        assertTrue(this.time.reduceTime(false, new FloorBuilder("./src/test/resources/floors/floor.map").createFloor()));

        this.time = new Time(10, 5);
        assertTrue(this.time.reduceTime(false, new FloorBuilder("./src/test/resources/floors/floor.map").createFloor()));
    }
}
