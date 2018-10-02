package domain.presentation.b;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FancyColourTest {

    public static final String ERROR_MSG = "Implementation has changed update " + PaintShopTest.class.getCanonicalName() + " accordingly";

    @Test
    public void implementationChanged(){
        assertThat(ERROR_MSG, PaintShop.FancyColour.values().length, is(2));
    }

}