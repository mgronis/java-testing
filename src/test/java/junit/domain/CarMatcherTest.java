package junit.domain;

import domain.Car;
import org.hamcrest.CustomTypeSafeMatcher;
import org.junit.Test;

import static domain.Car.SAAB;
import static org.junit.Assert.assertThat;

public class CarMatcherTest {

    @Test
    public void lights() {
        assertThat(SAAB, isExtralightsEquipped());
    }

    private CustomTypeSafeMatcher<Car> isExtralightsEquipped(){
        return new CustomTypeSafeMatcher<Car>("Equipped with extralights") {
            @Override
            protected boolean matchesSafely(Car item) {
                return item.hasExtraLights();
            }
        };
    }

}