package com.escapethemansion.gui;

import com.escapethemansion.model.game.Position;
import com.escapethemansion.model.game.element.Key;
import com.escapethemansion.model.game.element.component.PlayerComponent;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.escapethemansion.model.game.element.Element;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.Character.toLowerCase;


public class LanternaGUI implements GUI{
    private TerminalScreen screen;
    private TextGraphics tg;
    private final int widthWindow;
    private final int heightWindow;
    private AWTTerminalFontConfiguration fontConfig;
    private Map<KeyType, ACTION> keyAction;
    private Map<Character, ACTION> charAction;


    public LanternaGUI(int width, int height) throws FontFormatException, IOException, URISyntaxException {
        this.widthWindow = width;
        this.heightWindow = height;
        this.fontConfig = loadFont();
        this.drawWindow();
        keyAction = new TreeMap<KeyType, ACTION>();
        charAction =  new TreeMap<Character, ACTION>();
        initializeKeyActions();
        initializeCharActions();
    }

    public Map<KeyType, ACTION> getKeyAction() {
        return this.keyAction;
    }

    public Map<Character, ACTION> getCharAction() {
        return this.charAction;
    }

    /*public void setCharAction() {
        this.charAction = newCharAction;
    }

    public void setKeyActions(Map<KeyType, ACTION> newKeyAction) {
        this.keyAction = newKeyAction;
    }*/

    private void initializeCharActions() {
        charAction.put('w', ACTION.JUMPUP);
        charAction.put('s', ACTION.JUMPDOWN);
        charAction.put('a', ACTION.JUMPLEFT);
        charAction.put('d', ACTION.JUMPRIGHT);
    }

    private void initializeKeyActions() {
        keyAction.put(KeyType.ArrowUp, ACTION.UP);
        keyAction.put(KeyType.ArrowDown, ACTION.DOWN);
        keyAction.put(KeyType.ArrowLeft, ACTION.LEFT);
        keyAction.put(KeyType.ArrowRight, ACTION.RIGHT);
        keyAction.put(KeyType.EOF, ACTION.QUIT);
        keyAction.put(KeyType.Escape, ACTION.PAUSE);
        keyAction.put(KeyType.Enter, ACTION.SELECT);
    }

    private AWTTerminalFontConfiguration loadFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/etm_font.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fc = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fc;
    }


    @Override
    public void drawWindow() throws IOException {
        TerminalSize terminalSize = new TerminalSize(widthWindow, heightWindow + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();

        this.screen = new TerminalScreen(terminal);
        this.tg = screen.newTextGraphics();

        this.screen.setCursorPosition(null);   // we don't need a cursor
        this.screen.startScreen();             // screens must be started
        this.screen.doResizeIfNecessary();     // resize screen if necessary
    }

    @Override
    public <T extends Element> void drawElement(T element) {
        tg.setForegroundColor(TextColor.Factory.fromString(element.getColor()));
        tg.enableModifiers(SGR.BOLD);
        tg.putString(new TerminalPosition(element.getPosition().getX(), element.getPosition().getY()), element.getAppearance());
    }

    public <T extends PlayerComponent> void drawPlayerComponent(T playerComponent) {
        tg.setForegroundColor(TextColor.Factory.fromString(playerComponent.getColor()));
        tg.enableModifiers(SGR.BOLD);

        tg.putString(new TerminalPosition(playerComponent.getPosition().getX(), playerComponent.getPosition().getY()), playerComponent.getText());

        for(int i = 0; i < playerComponent.getValue()/10; i++) {
            Position position = playerComponent.getPosition().add(playerComponent.getInterval()).addX(i);
            tg.putString(new TerminalPosition(position.getX(), position.getY()), playerComponent.getAppearance());
        }
    }

    @Override
    public void drawText(Position position, String text, String color) {
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.enableModifiers(SGR.BOLD);
        tg.putString(new TerminalPosition(position.getX(), position.getY()), text);
    }

    @Override
    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput(); //TODO: is this the better way? - se continuarmos a carregar o player continua a ir
        if (keyStroke == null) return ACTION.NONE;

        ACTION nextAction;
        if(keyStroke.getKeyType() != KeyType.Character) {
            nextAction = keyAction.get(keyStroke.getKeyType());
        } else {
            nextAction = charAction.get(toLowerCase(keyStroke.getCharacter()));
        }

        return nextAction == null ? ACTION.NONE : nextAction;
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}
