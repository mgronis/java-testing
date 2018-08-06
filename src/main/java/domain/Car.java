package domain;

import java.awt.*;

import static java.awt.Color.*;

public enum Car {

    VOLVO(RED, 4),
    SAAB(BLACK, 2),
    OPEL(RED, 0),
    MG(GREEN, 0),
    LOTUS(WHITE, 0);

    private final Color color;
    private final int noOfExtraLights;

    Car(Color color, int noOfExtraLights) {
        this.color = color;
        this.noOfExtraLights = noOfExtraLights;
    }

    public Color getColor() {
        return color;
    }

    public int getNoOfExtraLights() {
        return noOfExtraLights;
    }

    public boolean hasExtraLights(){
        return noOfExtraLights != 0;
    }

}