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
public class BikeParametrized2Test {

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                { "Green", createBike(Color.GREEN), Color.GREEN },
                { "Blue", createBike(Color.BLUE), Color.BLUE },
                { "Red", createBike(Color.RED), Color.RED }
        });
    }

    private final String name;
    private final Bike bike;
    private final Color expectedColor;

    public BikeParametrized2Test(String name, Bike bike, Color expectedColor) {
        this.name = name;
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