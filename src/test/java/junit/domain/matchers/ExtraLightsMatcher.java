package junit.domain.matchers;

import domain.Car;
import org.hamcrest.CustomTypeSafeMatcher;
import org.hamcrest.Description;

public final class ExtraLightsMatcher {

    public static CustomTypeSafeMatcher<Car> isExtralightsEquipped() {
        return new CustomTypeSafeMatcher<Car>("Equipped with extralights") {
            @Override
            protected boolean matchesSafely(Car item) {
                return item.hasExtraLights();
            }

            @Override
            protected void describeMismatchSafely(Car item, Description mismatchDescription) {
                mismatchDescription.appendValue(item).appendText(" is not equipped with extralights");
            }
        };
    }

}
