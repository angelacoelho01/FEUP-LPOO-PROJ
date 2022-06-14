package com.escapethemansion.model.game.floor;

import com.escapethemansion.model.game.Position;
import com.escapethemansion.model.game.element.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FloorBuilder {
    private int width;
    private int height;
    private final List<Wall> walls;
    private final List<Ghost> ghosts;
    private final List<Key> keys;
    private final List<Door> doors;
    private final List<Hole> holes;
    private final List<Battery> batteries;
    private EndLevel levelEnd;
    private final List<Box> boxes;
    private Player player;
    private Weapon weapon;
    private Position offset;
    private String title;

    public FloorBuilder(String path) throws IOException {
        this.walls = new ArrayList<>();
        this.ghosts = new ArrayList<>();
        this.keys = new ArrayList<>();
        this.doors = new ArrayList<>();
        this.levelEnd = null;
        this.boxes = new ArrayList<>();
        this.holes = new ArrayList<>();
        this.batteries = new ArrayList<Battery>();
        File map = new File(path);
        BufferedReader mapReader = new BufferedReader(new FileReader(map));
        this.loadMap(mapReader);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Player getPlayer() {
        return player;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public List<Ghost> getGhosts() {
        return ghosts;
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public List<Hole> getHoles() {
        return holes;
    }

    public Position getOffset() {
        return offset;
    }

    public String getTitle() {
        return title;
    }

    public List<Key> getKeys() {
        return keys;
    }

    public List<Door> getDoors() {
        return doors;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public EndLevel getLevelEnd() { return  levelEnd;}

    public List<Battery> getBatteries() {
        return batteries;
    }

    public Floor createFloor() {
        Floor arena = new Floor(getWidth(), getHeight(), getGhosts().size());

        arena.setPlayer(getPlayer());
        arena.setWeapon(getWeapon());
        arena.setWalls(getWalls());
        arena.setGhosts(getGhosts());
        arena.setKeys(getKeys());
        arena.setDoors(getDoors());
        arena.setLevelEnd(getLevelEnd());
        arena.setBoxes(getBoxes());
        arena.setHoles(getHoles());
        arena.setBatteries(getBatteries());
        arena.setTitle(getTitle());
        arena.setOffset(offset);

        return arena;
    }

    protected String loadTitle(BufferedReader mapReader) throws IOException {
        return mapReader.readLine();
    }

    protected Position loadOffset(BufferedReader mapReader) throws IOException {
        String line;
        int x = 0;
        int y = 0;

        for(int i = 0; i < 2 && (line = mapReader.readLine()) != null; i++) {
            if(i == 0) x = Integer.parseInt(line);
            else y = Integer.parseInt(line);
        }
        return new Position(x, y);
    }

    public void loadMap(BufferedReader mapReader) throws IOException {
        this.title = loadTitle(mapReader);
        this.offset = loadOffset(mapReader);

        String line;
        int numLine = 0;
        int numCol = 0;

        for(; (line = mapReader.readLine()) != null; numLine++) {
            for(numCol = 0; numCol < line.length(); numCol++) {
                String c = String.valueOf(line.charAt(numCol));
                Position position = this.offset.add(new Position(numCol, numLine));

                switch (c) {
                    case "#":
                        this.walls.add(new Wall(position));
                        break;

                    case "G":
                        this.ghosts.add(new Ghost(position));
                        break;

                    case "X":
                        this.player = new Player(position);
                        break;

                    case "K":
                        this.keys.add(new Key(position));
                        break;

                    case "-":
                        this.doors.add(new Door(position, false));
                        break;

                    case "|":
                        this.doors.add(new Door(position, true));
                        break;

                    case "P":
                        this.levelEnd = new EndLevel(position);
                        break;

                    case "B":
                        this.boxes.add(new Box(position));
                        break;

                    case "H":
                        this.holes.add(new Hole(position));
                        break;

                    case "F":
                        this.batteries.add(new Battery(position));
                        break;
                        
                    case "W":
                        this.weapon = (new Weapon(position));
                        break;

                    default:
                        break;
                }
            }
        }

        this.width = numCol;
        this.height = numLine;
    }
}

