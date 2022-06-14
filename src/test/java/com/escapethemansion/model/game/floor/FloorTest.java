package com.escapethemansion.model.game.floor;

import com.escapethemansion.model.game.element.Ghost;
import com.escapethemansion.model.game.element.Player;
import com.escapethemansion.model.game.Position;
import com.escapethemansion.model.game.element.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FloorTest {
    private Floor floor;

    @BeforeEach
    void setup() throws IOException {
        floor = new FloorBuilder("./src/test/resources/floors/floor.map").createFloor();
    }

    @Test
    void getPlayer() {
        Position offset = new Position(12, 8);
        assertEquals(new Player(offset.add(new Position(6,13))), floor.getPlayer());
    }

    @Test
    void setPlayer() {
        floor.setPlayer(new Player(new Position(50, 25)));
        assertEquals(new Player(new Position(50, 25)), floor.getPlayer());
    }

    @Test
    void getWalls() {
        List<Wall> walls = new ArrayList<>();
        Position offset = new Position(12, 8);
        int width = 15, height = 15;

        for (int x = 0; x < width; x++)
            walls.add(new Wall(offset.add(new Position(x, 0))));

        for(int y = 1; y < height - 1; y++) {
            walls.add(new Wall(offset.add(new Position(0, y))));
            walls.add(new Wall(offset.add(new Position(width - 1, y))));
        }

        for(int x = 0; x < width; x++)
            walls.add(new Wall(offset.add(new Position(x, height - 1))));

        assertEquals(walls, floor.getWalls());
    }

    @Test
    void setWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int x = 0; x < 80; x++) {
            walls.add(new Wall(new Position(8 + x, 8 + 1)));
            walls.add(new Wall(new Position(8 + x, 8 + 40 - 1)));
        }

        for (int y = 1; y < 40 - 1; y++) {
            walls.add(new Wall(new Position(8, 8 + y)));
            walls.add(new Wall(new Position(8 + 80 - 1, 8 + y)));
        }

        floor.setWalls(walls);
        assertEquals(walls, floor.getWalls());
    }

    @Test
    void getGhosts() {
        List<Ghost> ghosts = new ArrayList<>();
        Position offset = new Position(12, 8);

        ghosts.add(new Ghost(offset.add(new Position(12, 1))));

        assertEquals(ghosts, floor.getGhosts());
    }

    @Test
    void setGhosts() {
        List<Ghost> ghosts = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            ghosts.add(new Ghost(new Position(8 + 80/2 + i + 1, 8 + 40/2 + i)));
        }

        floor.setGhosts(ghosts);
        assertEquals(ghosts, floor.getGhosts());

    }
}