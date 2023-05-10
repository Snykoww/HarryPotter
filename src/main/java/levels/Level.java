package levels;

import characters.Wizard;
import input.InputSource;

public abstract class Level {
    private String name;

    public Level(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean startLevel(Wizard wizard, InputSource inputSource);
}