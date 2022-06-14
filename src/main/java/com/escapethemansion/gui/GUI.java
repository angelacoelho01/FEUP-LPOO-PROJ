package com.escapethemansion.gui;

import com.escapethemansion.model.game.Position;
import com.escapethemansion.model.game.element.Element;
import com.escapethemansion.model.game.element.component.PlayerComponent;

import java.io.IOException;

public interface GUI {

    void drawWindow() throws IOException;

    <T extends Element> void drawElement(T element);

    <T extends PlayerComponent> void drawPlayerComponent(T playerComponent);

    void drawText(Position position, String text, String color);

    ACTION getNextAction() throws IOException;

    void refresh() throws IOException;

    void clear();

    void close() throws IOException;

    enum ACTION { NONE, UP, DOWN, LEFT, RIGHT, JUMPUP, JUMPDOWN, JUMPLEFT, JUMPRIGHT, PAUSE, QUIT, SELECT };
}
