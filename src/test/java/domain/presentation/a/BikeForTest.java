package domain.presentation.a;

import domain.presentation.a.Bike;
import domain.presentation.a.Breaks;
import domain.presentation.a.Frame;
import lombok.Value;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.awt.*;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BikeForTest {

    @Test
    public void greenBike() {
        Bike bike = createBike(Color.GREEN);

        assertThat(bike.getColor(), is(Color.GREEN));
    }

    @Test
    public void blueBike() {
        Bike bike = createBike(Color.BLUE);

        assertThat(bike.getColor(), is(Color.BLUE));
    }

    @Test
    public void redBike() {
        Bike bike = createBike(Color.RED);

        assertThat(bike.getColor(), is(Color.RED));
    }

    private Bike createBike(Color color) {
        return new Bike(3, Breaks.MECHANIC, Frame.STEEL, color, "Scott");
    }

    @Test
    public void manyBikes() {
        Collection<Tuple> data = Lists.newArrayList(new Tuple(createBike(Color.GREEN), Color.GREEN), new Tuple(createBike(Color.BLUE), Color.BLUE), new Tuple(createBike(Color.RED), Color.RED));

        for (Tuple item : data) {
            assertThat(item.getBike().getColor(), is(item.getExpectedColor()));
        }
    }

    @Value
    private static class Tuple{
        private final Bike bike;
        private final Color expectedColor;
    }

}