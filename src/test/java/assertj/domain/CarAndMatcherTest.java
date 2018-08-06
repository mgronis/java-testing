package assertj.domain;

import domain.Car;
import org.assertj.core.api.Condition;
import org.junit.Test;

import java.awt.*;

import static assertj.domain.matchers.ExtraLightsMatcher.equippedWithExtralights;
import static domain.Car.MG;
import static org.assertj.core.api.Assertions.assertThat;

public class CarAndMatcherTest {

    @Test
    public void colorAndLights() {
        assertThat(MG).isNot(equippedWithExtralights()).is(colored(Color.BLUE));
    }

    private Condition<Car> colored(Color expectedColor) {
        return new Condition<Car>(){
            @Override
            public boolean matches(Car value) {
                return value.getColor().equals(expectedColor);
            }

            @Override
            public Condition<Car> as(String newDescription, Object... args) {
                return super.as("colored " + expectedColor, args);
            }
        };
    }

}