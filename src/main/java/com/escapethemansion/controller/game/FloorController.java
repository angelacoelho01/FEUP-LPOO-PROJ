package com.escapethemansion.controller.game;

import com.escapethemansion.Game;
import com.escapethemansion.gui.GUI;
import com.escapethemansion.model.menu.GameOver;
import com.escapethemansion.model.menu.LevelComplete;
import com.escapethemansion.model.menu.Pause;
import com.escapethemansion.state.GameOverState;
import com.escapethemansion.state.LevelCompleteState;

import com.escapethemansion.model.game.floor.Floor;
import com.escapethemansion.state.PauseState;

import java.io.IOException;
import java.util.Objects;

public class FloorController extends GameController {
    private final PlayerController playerController;
    private final GhostController ghostController;
    private final BoxController boxController;

    public FloorController(Floor floor) {
        super(floor);

        this.playerController = new PlayerController(floor);
        this.ghostController = new GhostController(floor);
        this.boxController = new BoxController(floor);
    }

    public PlayerController getPlayerController(){
        return this.playerController;
    }

    public GhostController getGhostController() {
        return this.ghostController;
    }

    private boolean isLevelComplete(){
        return getModel().getLevelEnd().getPosition().equals(getModel().getPlayer().getPosition()) && getModel().getKeys().isEmpty();
    }

    private boolean isPlayerDead() {
        return getModel().getPlayer().getLife().getValue() == 0;
    }

    public BoxController getBoxController() {
        return this.boxController;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FloorController that = (FloorController) o;
        return Objects.equals(playerController, that.playerController) && Objects.equals(ghostController, that.ghostController);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerController, ghostController);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        if (action == GUI.ACTION.PAUSE) {
            getModel().getTimer().pauseTimer();
            game.setState(new PauseState(new Pause(getModel())));
        }
        else if (isLevelComplete()) {
            getModel().getTimer().endTimer();
            game.addPoints(getModel().getCurrPoints());
            game.setState(new LevelCompleteState(new LevelComplete(getModel().getCurrPoints(), game.getTotalPoints())));
        }
        else if (getModel().getTimer().timeIsUp() || isPlayerDead()){
            getModel().getTimer().endTimer();
            game.setState(new GameOverState(new GameOver()));
        }
        else {
            getModel().getTimer().resumeTimer();
            playerController.step(game, action, time);
            ghostController.step(game, action, time);
        }
    }
}
