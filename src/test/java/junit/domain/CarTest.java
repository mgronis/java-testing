package junit.domain;

import org.junit.Test;

import java.awt.*;

import static domain.Car.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CarTest {

    @Test
    public void color() {
        assertThat(VOLVO.getColor(), is(Color.RED));
    }

}