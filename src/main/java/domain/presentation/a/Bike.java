package domain.presentation.a;

import lombok.Value;

import java.awt.*;
import java.time.Instant;

@Value
public class Bike {

    private final int noOfGears;
    private final Breaks breaks;
    private final Frame frame;
    private final Color color;
    private final String Brand;
    private final Instant manufacturingDate = Instant.now();

}
