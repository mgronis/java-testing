package assertj;

import org.junit.Test;

import java.awt.*;

import static domain.Car.VOLVO;
import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    public void color() {
        assertThat(VOLVO.getColor()).isEqualTo(Color.RED);
    }

}