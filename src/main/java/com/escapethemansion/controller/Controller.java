package com.escapethemansion.controller;

import com.escapethemansion.Game;
import com.escapethemansion.gui.GUI;

import java.io.IOException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model){
        this.model = model;
    }

    public T getModel(){
        return model;
    }

    public abstract void step(Game game, GUI.ACTION action, long time) throws IOException;
}
