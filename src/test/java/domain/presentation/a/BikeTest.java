package domain.presentation.a;

import org.assertj.core.util.Lists;
import org.hamcrest.CustomTypeSafeMatcher;
import org.junit.Test;

import java.util.ArrayList;

import static domain.presentation.a.Breaks.MECHANIC;
import static domain.presentation.a.Frame.STEEL;
import static java.awt.Color.BLUE;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class BikeTest {

    public static final Bike BIKE = new Bike(3, MECHANIC, STEEL, BLUE, "Acme Inc");
    public static final ArrayList<String> LIST = Lists.newArrayList("Kalle", "Kula", "äter", "glass", "i", "stora", "lass");

    @Test
    public void firstBike(){
        assertTrue(BIKE.getNoOfGears() == 3);
        assertTrue(BIKE.getBreaks() == MECHANIC);
        assertTrue(BIKE.getFrame() == STEEL);
        assertTrue(BIKE.getColor() == BLUE);
        assertTrue(BIKE.getBrand().equals("Acme Inc"));
    }


















    @Test
    public void secondBike(){
        assertThat(BIKE.getNoOfGears(), is(3));
        assertThat(BIKE.getBreaks(), is(MECHANIC));
        assertThat(BIKE.getFrame(), is(STEEL));
        assertThat(BIKE.getColor(), is(BLUE));
        assertThat(BIKE.getBrand(), is("Acme Inc"));
    }

























    @Test
    public void firstMatchers(){
        assertThat(LIST, is(Lists.newArrayList("Kalle", "Kula", "äter", "glass", "i", "stora", "lass")));
        assertThat(LIST, not(empty()));
        assertThat(LIST, hasSize(7));
        assertThat(LIST, contains("Kalle", "Kula", "äter", "glass", "i", "stora", "lass"));
        assertThat(LIST, containsInAnyOrder("stora", "glass", "Kalle", "Kula", "äter", "i", "lass"));
        assertThat(LIST, hasItem("Kula"));
        assertThat(LIST, hasItems("lass", "Kula"));
    }























    @Test
    public void secondMatchers(){
        assertThat(LIST, both(hasItem("glass")).and(not(hasItem("Olle"))));
        assertThat(LIST, either(hasItem("Lisa")).or(hasItem("Kalle")));
    }





























    @Test
    public void firstCustomMatchers(){
        assertThat(BIKE, is(new Bike(3, MECHANIC, STEEL, BLUE, "Acme Inc")));
    }




























    @Test
    public void secondCustomMatchers(){
        assertThat(BIKE, is(expectedBike()));
    }

    private Bike expectedBike() {
        return new Bike(3, MECHANIC, STEEL, BLUE, "Acme Inc");
    }























    @Test
    public void thirdCustomMatchers(){
        assertThat(BIKE, isStandardBike());
    }

    private CustomTypeSafeMatcher<Bike> isStandardBike() {
        Bike bike = new Bike(3, MECHANIC, STEEL, BLUE, "Acme Inc");
        return new CustomTypeSafeMatcher<Bike>("Bike without manufacturing date") {
            @Override
            protected boolean matchesSafely(Bike item) {
                return bike.getBrand().equals(item.getBrand())
                        && bike.getBreaks() == item.getBreaks()
                        && bike.getColor() == item.getColor()
                        && bike.getFrame() == item.getFrame()
                        && bike.getNoOfGears() == item.getNoOfGears();
            }
        };
    }

}