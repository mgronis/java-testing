package domain;

import java.awt.*;

import static java.awt.Color.*;

public enum Car {

    VOLVO(RED),
    SAAB(BLACK),
    OPEL(RED),
    MG(GREEN),
    LOTUS(WHITE);

    private final Color color;

    Car(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}