package assertj.domain.matchers;

import domain.Car;
import org.assertj.core.api.Condition;

public final class ExtraLightsMatcher {

    public static Condition<Car> equippedWithExtralights() {
        return new Condition<Car>(){
            @Override
            public boolean matches(Car value) {
                return value.hasExtraLights();
            }

            @Override
            public Condition<Car> as(String newDescription, Object... args) {
                return super.as("equipped with extralights", args);
            }
        };
    }

}
