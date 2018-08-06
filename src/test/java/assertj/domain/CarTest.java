package assertj.domain;

import org.junit.Test;

import java.awt.*;

import static domain.Car.VOLVO;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void color() {
        assertThat(VOLVO.getColor()).isEqualTo(Color.RED);
    }

}