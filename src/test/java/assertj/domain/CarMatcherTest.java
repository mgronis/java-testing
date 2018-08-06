package assertj.domain;

import domain.Car;
import org.assertj.core.api.Condition;
import org.junit.Test;

import static domain.Car.SAAB;
import static org.assertj.core.api.Assertions.assertThat;

public class CarMatcherTest {

    @Test
    public void lights() {
        assertThat(SAAB).is(equippedWithExtralights());
    }

    private Condition<Car> equippedWithExtralights() {
        return new Condition<Car>(){
            @Override
            public boolean matches(Car value) {
                return value.hasExtraLights();
            }
        };
    }

}