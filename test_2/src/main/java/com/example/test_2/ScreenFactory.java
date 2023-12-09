package com.example.test_2;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class ScreenFactory {
    public Screen getScreen(String screenType, Stage stage, Game game) {//factory methods
        if (screenType == null) {
            return null;
        } else if (screenType.equalsIgnoreCase("ENDSCREEN")) {
            return EndScreen.getInstance().createScreen(stage, game);
        } else if (screenType.equalsIgnoreCase("PAUSESCREEN")) {
            return PauseScreen.getInstance().createScreen(stage, game);

        }
        return null;
    }
}