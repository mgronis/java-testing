package junit.domain;

import domain.Car;
import org.hamcrest.CustomTypeSafeMatcher;
import org.hamcrest.Description;
import org.junit.Test;

import java.awt.*;

import static domain.Car.MG;
import static junit.domain.matchers.ExtraLightsMatcher.isExtralightsEquipped;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.CombinableMatcher.both;
import static org.junit.Assert.assertThat;

public class CarAndMatcherTest {

    @Test
    public void colorAndLights() {
        assertThat(MG, both(not(isExtralightsEquipped())).and(hasColor(Color.RED)));
    }

    private CustomTypeSafeMatcher<Car> hasColor(Color expectedColor) {
        return new CustomTypeSafeMatcher<Car>("Color " + expectedColor) {
            @Override
            protected boolean matchesSafely(Car item) {
                return item.getColor().equals(expectedColor);
            }

            @Override
            protected void describeMismatchSafely(Car item, Description mismatchDescription) {
                mismatchDescription.appendText("was ").appendValue(item.getColor());
            }
        };
    }

}