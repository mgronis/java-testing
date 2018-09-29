package domain.presentation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.awt.*;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class BikeParametrizedTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                { createBike(Color.GREEN), Color.GREEN },
                { createBike(Color.BLUE), Color.BLUE },
                { createBike(Color.RED), Color.RED }
        });
    }

    private final Bike bike;
    private final Color expectedColor;

    public BikeParametrizedTest(Bike bike, Color expectedColor) {
        this.bike = bike;
        this.expectedColor = expectedColor;
    }

    @Test
    public void colorOfBike() {
        assertThat(bike.getColor(), is(expectedColor));
    }

    private static Bike createBike(Color color) {
        return new Bike(3, Breaks.MECHANIC, Frame.STEEL, color, "Scott");
    }

}